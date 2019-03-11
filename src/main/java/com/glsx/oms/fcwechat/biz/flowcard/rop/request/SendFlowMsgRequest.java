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
public class SendFlowMsgRequest extends AbstractRopRequest
{
	@XmlAttribute
    private String openId;

    @XmlAttribute
    private String imsi;
    
    @XmlAttribute
    private String iccid;
    
    //当前时间
    @XmlAttribute
    private String nowTime;
    
    //1G:剩余流量不足1G   500M:剩余流量不足500M  0:流量已用完
    @XmlAttribute
    private String type;
    
    //总流量
    @XmlAttribute
    private String totalFlow;
    
    //剩余流量
    @XmlAttribute
    private String remainedFlow;
    
    //消耗流量
    @XmlAttribute
    private String consumedFlow;
    
    //单位
    @XmlAttribute
    private String unit;
    
    //套餐有效期
    @XmlAttribute
    private String packageValid;
    
    
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




	public String getNowTime() {
		return nowTime;
	}




	public void setNowTime(String nowTime) {
		this.nowTime = nowTime;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public String getTotalFlow() {
		return totalFlow;
	}




	public void setTotalFlow(String totalFlow) {
		this.totalFlow = totalFlow;
	}




	public String getRemainedFlow() {
		return remainedFlow;
	}




	public void setRemainedFlow(String remainedFlow) {
		this.remainedFlow = remainedFlow;
	}




	public String getConsumedFlow() {
		return consumedFlow;
	}




	public void setConsumedFlow(String consumedFlow) {
		this.consumedFlow = consumedFlow;
	}




	public String getUnit() {
		return unit;
	}




	public void setUnit(String unit) {
		this.unit = unit;
	}




	public String getPackageValid() {
		return packageValid;
	}




	public void setPackageValid(String packageValid) {
		this.packageValid = packageValid;
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