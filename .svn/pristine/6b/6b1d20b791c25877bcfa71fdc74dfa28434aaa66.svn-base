package com.glsx.oms.fcwechat.biz.flowcard.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.oreframework.common.lang.date.DateFormatConstants;
import org.oreframework.common.lang.date.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.dubbo.config.annotation.Reference;
import com.glsx.biz.common.message.service.MessageService;
import com.glsx.cloudframework.exception.ServiceException;
import com.glsx.oms.fcservice.api.core.FlowResponse;
import com.glsx.oms.fcservice.api.entity.NameAuth;
import com.glsx.oms.fcservice.api.manager.OpsMgrManager;
import com.glsx.oms.fcservice.api.request.FlowCardRequest;
import com.glsx.oms.fcservice.api.request.NameAuthRequest;
import com.glsx.oms.fcwechat.biz.flowcard.model.Auth;
import com.glsx.oms.fcwechat.biz.flowcard.model.FlowCard;
import com.glsx.oms.fcwechat.biz.flowcard.service.FlowcardService;
import com.glsx.oms.fcwechat.biz.flowcard.util.HttpUtils;
import com.glsx.oms.fcwechat.framework.config.StaticProperty;

@RestController
public class AuthController
{
    
    private static Logger logger = LoggerFactory.getLogger(AuthController.class);
    
    @Reference(version = "2.2.0", timeout = 10000)
    private MessageService messageService;
    
    @Autowired
    private FlowcardService flowcardService;
    
    @Autowired
    private StaticProperty staticProperty;
    
    // 如果用@Reference注解版本号不能去掉
 	@Reference(version = "1.0.0")
 	private OpsMgrManager opsMgrManager;
 	
 	private HttpUtils httpUtils = new HttpUtils();
    
    private FlowCard flowCard;
    
    /**
     * 实名认证
     * 
     * @param session
     * @return
     * @throws Exception 
     */
    @RequestMapping(value = "/api/toAuth", method = {RequestMethod.POST, RequestMethod.GET})
    public Map<String, Object> toAuth(HttpServletRequest request,HttpSession session) throws Exception
    {
    	flowCard = (FlowCard)session.getAttribute("cardInfo");
        Map<String, Object> myMap = new HashMap<String, Object>();
        
        // 查询实名认证状态接口 在js中根据状态跳到不同的页面
        FlowCardRequest flowCardRequest = new FlowCardRequest();
        flowCardRequest.setImsi(flowCard.getImsi());
        flowCardRequest.setConsumer("oms-fcwechat");
        flowCardRequest.setVersion("1.0.0");
        flowCardRequest.setTime(DateUtils.getCurrentDate(DateFormatConstants.TIMEF_FORMAT));
        FlowResponse<NameAuth> nameAuth = opsMgrManager.getAuthStatus(flowCardRequest);
        if("1000".equals(nameAuth.getCode())){
        	myMap.put("isAuth", nameAuth.getEntiy().getIsAuth());
        	myMap.put("fail_reason", nameAuth.getEntiy().getFailReason());
        }else{
        	myMap.put("isAuth", null);
        }
        myMap.put("cardInfo", flowCard);
        return myMap;
    }
    
    // 提交实名认证的信息 //传入Auth的属性
    @RequestMapping(value = "/api/saveAuth", method = {RequestMethod.POST, RequestMethod.GET})
    public Map<String, Object> saveAuth(HttpServletRequest request,HttpSession session, Auth auth)
        throws Exception
    {
    	String openId = (String)request.getSession().getAttribute("openId");
        if (null == openId)
        {
            logger.error("\n \n request.getSession() openId： {}", openId);
            return null;
        }
        Map<String, Object> myMap = new HashMap<String, Object>();
        flowCard = (FlowCard)session.getAttribute("cardInfo");
        // 调用提交实名认证的信息接口
        NameAuthRequest nameAuthRequest = new NameAuthRequest();
        nameAuthRequest.setImsi(flowCard.getImsi());
        nameAuthRequest.setName(auth.getName());
        nameAuthRequest.setPhoneNo(auth.getPhoneNo());
        nameAuthRequest.setIdNo(auth.getIdNo());
        nameAuthRequest.setPhoto(auth.getPhoto());
        nameAuthRequest.setPhotoOpp(auth.getPhotoOpp());
        nameAuthRequest.setPhotoPos(auth.getPhotoPos());
        nameAuthRequest.setOpenId(openId);
        nameAuthRequest.setConsumer("oms-fcwechat");
        nameAuthRequest.setVersion("1.0.0");
        nameAuthRequest.setTime(DateUtils.getCurrentDate(DateFormatConstants.TIMEF_FORMAT));
        FlowResponse<?> nameAuth = opsMgrManager.nameAuth(nameAuthRequest);
        myMap.put("summitRes", nameAuth.getCode());
        //实名认证交互成功更改卡表中的openId
        flowcardService.updateOpenId(flowCard);
        flowcardService.updateOpenIdNotify(flowCard);
        return myMap;
    }
    
    // 发送验证码
    @RequestMapping(value = "/api/sendMess", method = {RequestMethod.POST, RequestMethod.GET})
    public Map<String, Object> sendMess(String phoneNo)
        throws ServiceException
    {
        Map<String, Object> myMap = new HashMap<String, Object>();
        logger.info("发送验证码  phoneNo {}", phoneNo);
        messageService.sendMessage(phoneNo, "fcwechat", (short)2, "验证码为{0}，30分钟内有效，若不是本人操作请忽略");
        return myMap;
    }
    
    // 验证 验证码是否输入正确
    @RequestMapping(value = "/api/checkMess", method = {RequestMethod.POST, RequestMethod.GET})
    public Map<String, Object> checkMess(String phoneNo, String randomPassword)
    {
        Map<String, Object> myMap = new HashMap<String, Object>();
        boolean checkResult = true;
        try
        {
            checkResult = messageService.checkRandomPassword(phoneNo, randomPassword);
        }
        catch (ServiceException e)
        {
            checkResult = false;
            logger.error("验证验证码失败!", e);
        }
        myMap.put("checkResult", checkResult);
        return myMap;
    }
    
    // 上传图片的接口
    @RequestMapping(value = "/api/addPhoto", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, Object>> addPhoto(HttpServletRequest request, MultipartFile imagefile)
    {
        logger.info("上传图片的接口 start");
        Map<String, Object> myMap = new HashMap<String, Object>();
        String downUrl = httpUtils.addPhoto(imagefile, staticProperty);
        myMap.put("path", downUrl);
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(myMap);
        logger.info("上传图片的接口 {} end", downUrl);
        return list;
    }
}
