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
public class SendPkgMsgRequest extends AbstractRopRequest
{
	@XmlAttribute
    private String openId;

    @XmlAttribute
    private String imsi;
    
    //套餐剩余天数
    @XmlAttribute
    private String remainedDays;
    
    //套餐到期时间
    @XmlAttribute
    private String pkgEndTime;
    
    //套餐服务类型
    @XmlAttribute
    private String pkgType;

    
 

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




	public String getRemainedDays() {
		return remainedDays;
	}




	public void setRemainedDays(String remainedDays) {
		this.remainedDays = remainedDays;
	}




	public String getPkgEndTime() {
		return pkgEndTime;
	}




	public void setPkgEndTime(String pkgEndTime) {
		this.pkgEndTime = pkgEndTime;
	}




	public String getPkgType() {
		return pkgType;
	}




	public void setPkgType(String pkgType) {
		this.pkgType = pkgType;
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