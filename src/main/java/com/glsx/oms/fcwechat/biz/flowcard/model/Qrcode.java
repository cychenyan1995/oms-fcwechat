package com.glsx.oms.fcwechat.biz.flowcard.model;

public class Qrcode {

	private int id;
	
	private String imsi;
	
	private String qrcodeUrl;
	
	private int expireSeconds;
	
	private String ticket;
	
	private String createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getQrcodeUrl() {
		return qrcodeUrl;
	}

	public void setQrcodeUrl(String qrcodeUrl) {
		this.qrcodeUrl = qrcodeUrl;
	}


	public int getExpireSeconds() {
		return expireSeconds;
	}

	public void setExpireSeconds(int expireSeconds) {
		this.expireSeconds = expireSeconds;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}


	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "Qrcode [id=" + id + ", imsi=" + imsi + ", qrcodeUrl=" + qrcodeUrl + ", expireSeconds=" + expireSeconds
				+ ", ticket=" + ticket + ", createTime=" + createTime + "]";
	}

}
