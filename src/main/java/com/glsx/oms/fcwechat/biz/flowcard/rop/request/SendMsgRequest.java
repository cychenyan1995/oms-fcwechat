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
public class SendMsgRequest extends AbstractRopRequest
{
	@XmlAttribute
    private String openId;

    @XmlAttribute
    private String imsi;
    
    @XmlAttribute
    private String iccid;
    
    @XmlAttribute
    private String cardNo;
    
    //实名认证结果
    @XmlAttribute
    private String isauth;
    
    //认证不通过原因说明
    @XmlAttribute
    private String fail_reason;
    
    
    public String getFail_reason() {
		return fail_reason;
	}


	public void setFail_reason(String fail_reason) {
		this.fail_reason = fail_reason;
	}


	public String getIccid() {
		return iccid;
	}


	public void setIccid(String iccid) {
		this.iccid = iccid;
	}


	public String getCardNo() {
		return cardNo;
	}


	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}


	public String getIsauth() {
		return isauth;
	}


	public void setIsauth(String isauth) {
		this.isauth = isauth;
	}


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


	/**
     * 得到属性字符串
     * @return String 属性字符串
     */
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }

}