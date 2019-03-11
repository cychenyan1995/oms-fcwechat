package com.glsx.oms.fcwechat;

import java.io.StringWriter;
import java.io.Writer;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.junit.Test;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.pay.PayUtil;
import org.weixin4j.pay.SignUtil;
import org.weixin4j.pay.UnifiedOrder;
import org.weixin4j.pay.UnifiedOrderResult;
import org.weixin4j.pay.WCPay;

import com.glsx.oms.fcwechat.biz.flowcard.util.RandomUtil;

public class PayUnifiedOrderTest
{
    Weixin weixin = new Weixin();
   
    
    @Test
    public void payUnifiedOrder()
    {
        
        UnifiedOrder unifiedorder = new UnifiedOrder();
        unifiedorder.setAppid("wx1cf40dc91c28a7fd");// 公众账号ID
        unifiedorder.setBody("流量卡购买流量");// 商品描述
        unifiedorder.setMch_id("1230909502");// 商户号
        unifiedorder.setNonce_str(RandomUtil.createNonceStr());// 随机字符串
        unifiedorder.setNotify_url("http://devwx.glsx.com.cn/fcwechat/repay.html");// 通知地址
        unifiedorder.setOpenid("oslKftyEN4gKX9EDbSD4CdpYbexQ");// 用户标识
        unifiedorder.setOut_trade_no("20170425125346");// 商户订单号
        unifiedorder.setSpbill_create_ip("183.62.222.180");
        unifiedorder.setTotal_fee("1");// 标价金额
        unifiedorder.setTrade_type("JSAPI");// 标价币种
        
        unifiedorder.setSign(SignUtil.getSign(unifiedorder.toMap(), "7eb0b8a6b5d2942d4bb485e2a44a5eb6"));// 签名
        try
        {
            UnifiedOrderResult result = weixin.payUnifiedOrder(unifiedorder);
            JAXBContext context = JAXBContext.newInstance(UnifiedOrderResult.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            Writer w = new StringWriter();
            marshaller.marshal(result, w);
            String xml = w.toString();
            
            System.out.println("\n \n 返回结果：\n"+xml);
        }
        catch (WeixinException e)
        {
            e.printStackTrace();
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
    
    @Test
    public void pay()
    {
        WCPay wcPay = PayUtil.getBrandWCPayRequest("wx1cf40dc91c28a7fd",
            "wx2017042517332588c273e2c30486349539",
            "7eb0b8a6b5d2942d4bb485e2a44a5eb6");
        System.out.println(wcPay.getPaySign());
    }
}
