package com.glsx.oms.fcwechat.framework.matcher;

import com.soecode.wxtools.api.WxMessageMatcher;
import com.soecode.wxtools.bean.WxXmlMessage;

/**
 * 示例：DemoMatcher匹配器
 * 目的：拦截“在吗”的消息
 * 
 * @author antgan
 * @date 2016/12/15
 *
 */
public class FcWechatMatcher implements WxMessageMatcher{

	@Override
	public boolean match(WxXmlMessage message) {
		//拦截“在吗”的消息，true通行；false拦截
		if("在吗".equals(message.getContent())){
			return false;
		}
		return true;
	}
}
