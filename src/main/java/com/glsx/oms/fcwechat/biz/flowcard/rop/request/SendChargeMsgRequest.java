package com.glsx.oms.fcwechat.biz.flowcard.rop.request;

import javax.xml.bind.annotation.XmlAttribute;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.rop.AbstractRopRequest;

/**
 * 模版消息参数实体类
 * 
 * @author   
 * @version  
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class SendChargeMsgRequest extends AbstractRopRequest
{
	@XmlAttribute
    private String openId;

    @XmlAttribute
    private String imsi;
    
    @XmlAttribute
    private String iccid;
    
    
    //充值订单号
    @XmlAttribute
    private String orderNo;
    
    //充值套餐名称
    @XmlAttribute
    private String chargePkg;
    
    //充值套餐价格
    @XmlAttribute
    private String price;
    
   

	public String getOpenId() {
		return openId;
	}



	public void setOpenId(String openId) {
		this.openId = openId;
	}



	public String getImsi() {
		return imsi;
	}



	public void setImsi(String imsi) {
		this.imsi = imsi;
	}



	public String getIccid() {
		return iccid;
	}



	public void setIccid(String iccid) {
		this.iccid = iccid;
	}



	public String getOrderNo() {
		return orderNo;
	}



	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}



	public String getChargePkg() {
		return chargePkg;
	}



	public void setChargePkg(String chargePkg) {
		this.chargePkg = chargePkg;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	/**
     * 得到属性字符串
     * @return String 属性字符串
     */
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }

}