package com.glsx.oms.fcwechat;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.result.WxOAuth2AccessTokenResult;
import com.soecode.wxtools.exception.WxErrorException;

public class WxAccessTokenTest {

	private final static Logger logger = LoggerFactory.getLogger(WxAccessTokenTest.class);
	private IService service = new WxService();
	
	@Test
	public void getAccessToken(){
		try {
			String accessToken = service.getAccessToken();
			logger.info("------------------------------>"+accessToken);
			Assert.assertNotNull(accessToken);
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void oauth2buildAuthorizationUrl(){
		try {
			String code = service.oauth2buildAuthorizationUrl("http://devwx.glsx.com.cn/fcwechat/oauth2/authorize","snsapi_base","STATE");
			logger.info("------------------------------>"+code);
			Assert.assertNotNull(code);
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void oauth2ToGetAccessToken(){
		try {
			WxOAuth2AccessTokenResult code = service.oauth2ToGetAccessToken("061uy9nh1L9Tsz0tPvoh1Rnpnh1uy9nC");
			logger.info("------------------------------>"+code);
			Assert.assertNotNull(code);
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
	}
	
	
}
