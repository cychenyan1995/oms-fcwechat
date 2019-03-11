package com.glsx.oms.fcwechat.biz.flowcard.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.glsx.oms.fcwechat.biz.Constants;
import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.result.WxOAuth2AccessTokenResult;
import com.soecode.wxtools.exception.WxErrorException;

@Controller
public class CommonController
{
    private static Logger logger = LoggerFactory.getLogger(CommonController.class);
    
    /** 
     * 微信WebView入库
     * @param request
     * @return
     */
    @RequestMapping(value = "/html/api/router", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView router(HttpServletRequest request)
    {
        ModelAndView view = null;
        String code = request.getParameter("code");
        IService service = new WxService();
        
        try
        {
            if (null != code)
            {
                String openId = (String)request.getSession().getAttribute("openId");
               
                if (null == openId)
                {
                    
                    WxOAuth2AccessTokenResult auth = service.oauth2ToGetAccessToken(code);
                    if (null == auth)
                    {
                        logger.error("获取用户权限失败,code {}", code);
                    }
                    else if (null == auth.getOpenid())
                    {
                        logger.error("获取用户openId失败,openId {}", auth.getOpenid());
                    }
                    else
                    {
                        logger.info("获取用户,openId {}", auth.getOpenid());
                        request.getSession().setAttribute(Constants.OPEN_ID, auth.getOpenid());
                    }
                }
            }
            else
            {
                logger.error("获取OAuth2失败,code is {}", code);
            }
            
            String page = request.getParameter("action");
            
            if ("flowQuery".equals(page))
            {
                // 流量查询
                view = new ModelAndView("/html/queryFlow/flowQuery.html");
            }
            else if ("authQuery".equals(page))
            {
                // 实名认证
                view = new ModelAndView("/html/auth/authQuery.html");
            }
            else if ("flowCharge".equals(page))
            {
                // 流量充值
                view = new ModelAndView("/html/flowCharge/flowChargeQuery.html");
            }
            else if ("paymentQrcode".equals(page))
            {
            	String state = request.getParameter("state");
            	
                // 流量充值
                view = new ModelAndView("/api/commitOrderByQrcode?state="+state);
            }
            else if("openPackage".equals(page))
            {
            	//开通套餐
            	view = new ModelAndView("/html/openPackage/openPackage.html");
            }
            
        }
        catch (WxErrorException e)
        {
            logger.error("WxErrorException",e);
        }
        return view;
    }
}
