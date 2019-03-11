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
@XmlRootElement(name = "sendMsgResponse")
public class SendMsgResponse
{
	@XmlAttribute
	String retrunCode;
	
	@XmlAttribute
	String message;
	
	public String getRetrunCode() {
		return retrunCode;
	}

	public void setRetrunCode(String retrunCode) {
		this.retrunCode = retrunCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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