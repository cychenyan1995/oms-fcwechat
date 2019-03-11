package com.glsx.oms.fcwechat.biz.flowcard.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.WxJsapiConfig;
import com.soecode.wxtools.exception.WxErrorException;

@RestController
public class ScanController
{
    private static Logger logger = LoggerFactory.getLogger(ScanController.class);
    
    /**
     * 微信WebView入库
     * 
     * @param request
     * @return
     */
    @RequestMapping(value = "/scan", method = {RequestMethod.POST, RequestMethod.GET})
    public Map<String, String> scan(HttpServletRequest request)
    {
        IService service = new WxService();
        WxJsapiConfig wxJsapiConfig = null;
        String url = "http://devwx.glsx.com.cn/fcwechat/jssdk.html";
        List<String> jsApiList = new ArrayList<String>();
        jsApiList.add("scanQRCode");
        Map<String, String> map = null;
        try
        {
            map = Sign.sign(service.getJsapiTicket(),url);
            //wxJsapiConfig = service.createJsapiConfig(url, jsApiList);
        }
        catch (WxErrorException e)
        {
            e.printStackTrace();
            logger.error(e.getMessage());
        }
        return map;
    }
}
