package com.glsx.oms.fcwechat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.exception.WxErrorException;

public class WxUserListTest {

	private final static Logger logger = LoggerFactory.getLogger(WxUserListTest.class);
	private IService service = new WxService();
	
	@Test
	public void getUserList(){
		try {
		    Map<String, String> params = new HashMap<String, String>();
		    params.put("access_token", "YUOgyfnmetZNse-HUaSt2WLTnUqkKY2Y7GNk8Na_Bi47-Pjx9afZ0zAe0-3zrv9fqy3KctU30gXgIH_ORKtvO_pdawIpGwwNVTW3j3RdXtrl9QR-uyASKtT7esMNrqCtCYMaAEAYUI");
		    params.put("next_openid", "");
		    String userList = service.get("https://api.weixin.qq.com/cgi-bin/user/get", params);
			logger.info("user \n {}",userList);
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
	}
	
	@Test
    public void getUser(){
        try {
            //用户授权并获取code
            String authString = service.oauth2buildAuthorizationUrl("http://devwx.glsx.com.cn/fcwechat/repay.html", "snsapi_base", "200OK");
            logger.info("用户授权并获取code \n {}",authString);
            
           /* Map<String, String> params = new HashMap<String, String>();
            params.put("access_token", "YstMdVJcqmOuzoOXxsnKG4L_xZoxWsLR-gsrD97VzhM5LMyRhHnx6kd9TQs0dgmZ6_PppHI0LPLTPWsd1rBMQuo6dMpm2JauN0711e0rd1GxE7hqyyWLNv4MxIucdJT5ZIFaACAQZW");
            params.put("openid", "oJGDQwXBlzQjlpHI7udoavluSYS0");
            String userList = service.get("https://api.weixin.qq.com/sns/userinfo", params);
            logger.info("user \n {}",userList);*/
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
    }
}
