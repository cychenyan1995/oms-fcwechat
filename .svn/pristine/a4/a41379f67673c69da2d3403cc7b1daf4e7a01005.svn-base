/*package com.glsx.oms.fcwechat;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.dubbo.config.annotation.Reference;
import com.glsx.biz.common.message.service.MessageService;
import com.glsx.cloudframework.exception.ServiceException;
import com.glsx.oms.OMSTestBootStarter;
import com.glsx.oms.fcwechat.biz.flowcard.model.Auth;
import com.glsx.oms.fcwechat.biz.flowcard.util.HttpUtils;
import com.glsx.oms.fcwechat.framework.config.StaticProperty;

*//**
 * 流量平台中心卡信息 单元测试
 *//*
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OMSTestBootStarter.class)
public class FlowCardClientTest
{
    private final static Logger LOGGER = LoggerFactory.getLogger(FlowCardClientTest.class);
    
    
    private HttpUtils httpUtils = new HttpUtils();
    
    @Autowired
    private StaticProperty staticProperty;
    
    @Reference(version="2.2.0",timeout=10000)
	private MessageService messageService;
    
    @Test
    public void testGetCardFlow()
    {
    	//String[] iccids = new String[]{"1189860615010030652"};
        //LOGGER.info("testGetCardFlow = {} \n", httpUtils.getCardFlow(iccids, staticProperty));
    }
    
    @Test
    public void testGetCardIccid()
    {
        LOGGER.info("testGetCardIccid = {} \n", httpUtils.getCardIccid("460060082076518", staticProperty));
    }
   
    @Test
    public void testGetDealsHistory()
    {
        LOGGER.info("testGetDealsHistory = {} \n", httpUtils.getDealsHistory("460060082076516",0,staticProperty));
    }
    
    @Test
    public void testGetValidFlowPkg()
    {
    	
        LOGGER.info("testGetValidFlowPkg = {} \n", httpUtils.getValidFlowPkg("8986061602001666518", staticProperty));
    }
    
    @Test
    public void testGetAuthStatus()
    {
        LOGGER.info("testGetAuthStatus = {} \n", httpUtils.getAuthStatus("460060082076518", staticProperty));
    }
    
    @Test
    public void testSetAuthStatus()
    {
        LOGGER.info("testSetAuthStatus = {} \n", httpUtils.setAuthStatus("460060082076518",1, staticProperty));
    }
    
    @Test
    public void testNameAuth() throws Exception {
    	Auth auth=new Auth("460060082076516","刘诗诗","18368823120","463255198010234453","http://183.62.222.182:8525/v1/tfscom/T1izETBgZ_1RCvBVdK.jpeg","http://183.62.222.182:8525/v1/tfscom/T1izETBgZ_1RCvBVdK.jpeg","http://183.62.222.182:8525/v1/tfscom/T1izETBgZ_1RCvBVdK.jpeg");
        LOGGER.info("testNameAuth = {} \n", httpUtils.nameAuth(auth, staticProperty));
    }
    
    @Test
    public void testSubmitOrder(){
    	String[] imsiList=new String[]{"460060082076518"};
        LOGGER.info("testSubmitOrder = {} \n", httpUtils.submitOrder(imsiList,1,12,0, staticProperty));
    }
    
    @Test    
    public void testProcessOrder(){
    	String content="微信支付";
        LOGGER.info("testProcessOrder = {} \n", httpUtils.processOrder("170419113400840","d87adf72940d83723fo0485s82934y23",content, staticProperty));
    }
    
    @Test
    public void testSendMess() throws ServiceException
    {
    	messageService.sendMessage("13163293375", "fcwechat", (short) 2, "验证码为{0}，30分钟内有效，若不是本人操作请忽略");
    	LOGGER.info("testCheckMess = {} \n","ok");

    }
    
    @Test
    public void testCheckMess() throws ServiceException
    {
    	boolean b=messageService.checkRandomPassword("13163293375", "1210");
    	Assert.assertTrue(b);
    	if(b){
    		LOGGER.info("testCheckMess = {} \n","ok");
    	}
    	 
    }
    

    @Test
    public void testGetFlowHistory()
    {
        LOGGER.info("testGetFlowHistory = {} \n", httpUtils.getFlowHistory("8986061501003065300",0,"2017-5-16","2017-5-16", staticProperty));
    }
}*/