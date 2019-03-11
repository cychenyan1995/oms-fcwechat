package com.glsx.oms.fcwechat.biz.flowcard.rop.response;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.commons.lang.builder.ToStringBuilder;


/**
 * SendMsg
 * 
 * @author  
 * @version  [版本号, ]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "qrcodeGeneResponse")
public class QrcodeGeneResponse
{
	@XmlAttribute
	Integer retrunCode;
	
	@XmlAttribute
	String retrunMessage;
	
	@XmlAttribute
	String qrcodeUrl;
	
	public Integer getRetrunCode() {
		return retrunCode;
	}

	public void setRetrunCode(Integer retrunCode) {
		this.retrunCode = retrunCode;
	}

	public String getRetrunMessage() {
		return retrunMessage;
	}

	public void setRetrunMessage(String retrunMessage) {
		this.retrunMessage = retrunMessage;
	}

	public String getQrcodeUrl() {
		return qrcodeUrl;
	}

	public void setQrcodeUrl(String qrcodeUrl) {
		this.qrcodeUrl = qrcodeUrl;
	}

	/**
     * 得到属性字符串
     * 
     * @return String 属性字符串
     */
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this);
    }
    
}