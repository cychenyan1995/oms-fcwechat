package com.glsx.oms.fcwechat.biz.flowcard.controller;

import java.util.HashMap;
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
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;
import com.glsx.oms.fcservice.api.core.FlowResponse;
import com.glsx.oms.fcservice.api.manager.OpsMgrManager;
import com.glsx.oms.fcservice.api.request.FcOpenPackageRequest;
import com.glsx.oms.fcwechat.biz.Constants;
import com.glsx.oms.fcwechat.biz.flowcard.model.FlowCard;
import com.glsx.oms.fcwechat.biz.flowcard.model.OpenPackage;
import com.glsx.oms.fcwechat.biz.flowcard.service.FlowcardService;

@RestController
public class OpenPackageController
{
    
    private static Logger logger = LoggerFactory.getLogger(OpenPackageController.class);
    
    @Autowired
    private FlowcardService flowcardService;
    
    // 如果用@Reference注解版本号不能去掉
 	@Reference(version = "1.0.0")
 	private OpsMgrManager opsMgrManager;
 	
    // 提交开卡套餐开通手机号 //开通开卡套餐
    @RequestMapping(value = "/api/openPackage", method = {RequestMethod.POST, RequestMethod.GET})
    public Map<String, Object> openPackage(HttpServletRequest request,HttpSession session, OpenPackage openPackage)
        throws Exception
    {
    	logger.info("开通套餐IMSI:"+openPackage.getImsi() + "，phoneNo：" + openPackage.getPhoneNo());
        Map<String, Object> myMap = new HashMap<String, Object>();
        // 调用开通卡套餐接口
        FcOpenPackageRequest openRequest = new FcOpenPackageRequest();
        openRequest.setKeyWord(openPackage.getImsi());
        openRequest.setConsumer("oms-fcwechat");
        openRequest.setVersion("1.0.0");
        openRequest.setTime(DateUtils.getCurrentDate(DateFormatConstants.TIMEF_FORMAT));
        FlowResponse<?> response = opsMgrManager.emptyToOpenPackage(openRequest);
        myMap.put("summitRes", response.getCode());
        myMap.put("errorMsg", response.getMessage());
        if(Constants.OPEN_SUCCESS.equals(response.getCode())){
        	//开通套餐成功更改卡表中的phoneNo
            FlowCard bean = new FlowCard();
            bean.setImsi(openPackage.getImsi());
            bean.setPhoneNo(openPackage.getPhoneNo());
            flowcardService.updatePhoneNo(bean);
        }
        return myMap;
    }
}
