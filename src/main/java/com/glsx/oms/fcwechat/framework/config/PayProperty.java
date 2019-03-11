package com.glsx.oms.fcwechat.framework.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("wechat.pay")
public class PayProperty
{
    private String appId;
    private String mchId;
    private String notifyUrl;
    private String paternerKey;
    private String openId;
    private String price;
    
    /*private String appId = "wx1cf40dc91c28a7fd";
    private String mchId = "1230909502";
    private String notifyUrl = "http://devwx.glsx.com.cn/fcwechat/repay.html";
    private String payTitle = "流量卡购买流量";
    private String paternerKey = "7eb0b8a6b5d2942d4bb485e2a44a5eb6";*/
    
   
    public String getAppId()
    {
        return appId;
    }
    public void setAppId(String appId)
    {
        this.appId = appId;
    }
    public String getMchId()
    {
        return mchId;
    }
    public void setMchId(String mchId)
    {
        this.mchId = mchId;
    }
    public String getNotifyUrl()
    {
        return notifyUrl;
    }
    public void setNotifyUrl(String notifyUrl)
    {
        this.notifyUrl = notifyUrl;
    }
   
    public String getPaternerKey()
    {
        return paternerKey;
    }
    public void setPaternerKey(String paternerKey)
    {
        this.paternerKey = paternerKey;
    }
    public String getOpenId()
    {
        return openId;
    }
    public void setOpenId(String openId)
    {
        this.openId = openId;
    }
    public String getPrice()
    {
        return price;
    }
    public void setPrice(String price)
    {
        this.price = price;
    }
    
    
	
}
