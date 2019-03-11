
package com.glsx.oms.fcwechat.biz.wechat.user.model;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.oreframework.web.model.BaseModel;
import org.apache.ibatis.type.JdbcType;

import tk.mybatis.mapper.annotation.ColumnType;

/**
 * 微信用户表 实体
 */
@Table(name = "wechat_user")
public class User {
	
	
	/**
	 * 主键
	 */
	@Id
	private Integer id;
	
	/**
	 * 商户号
	 */
	@ColumnType(jdbcType=JdbcType.VARCHAR)
	private String merchantId;
	
	/**
	 * 微信号
	 */
	@ColumnType(jdbcType=JdbcType.VARCHAR)
	private String wxNo;
	
	/**
	 * 微信名
	 */
	@ColumnType(jdbcType=JdbcType.VARCHAR)
	private String wxName;
	
	/**
	 * 头像
	 */
	@ColumnType(jdbcType=JdbcType.VARCHAR)
	private String logo;
	
	/**
	 * 地区
	 */
	@ColumnType(jdbcType=JdbcType.VARCHAR)
	private String address;
	
	/**
	 * 姓名
	 */
	@ColumnType(jdbcType=JdbcType.VARCHAR)
	private String name;
	
	/**
	 * 手机号码
	 */
	@ColumnType(jdbcType=JdbcType.VARCHAR)
	private String phone;
	
	/**
	 * 性别0男，1女
	 */
	@ColumnType(jdbcType=JdbcType.INTEGER)
	private Integer sex;
	
	/**
	 * 关注状态0,未关注，1已经关注
	 */
	@ColumnType(jdbcType=JdbcType.INTEGER)
	private Integer status;
	
	/**
	 * 地理位置纬度
	 */
	@ColumnType(jdbcType=JdbcType.VARCHAR)
	private String latitude;
	
	/**
	 * 地理位置经度
	 */
	@ColumnType(jdbcType=JdbcType.VARCHAR)
	private String longitude;
	
	/**
	 * 地理位置精度
	 */
	@ColumnType(jdbcType=JdbcType.VARCHAR)
	private String precisionx;

	/**
     * 续费URL，通过微信接口生成的短链接
     */
    @ColumnType(jdbcType=JdbcType.VARCHAR)
	private String rechargeUrl;
    
    /**
     * 用户与微信绑定key
     */
    @ColumnType(jdbcType=JdbcType.VARCHAR)
    private String bindKey;
    
    @Transient
    private String welcomeContent;
    
    public User(){
    }

    public User(
        java.lang.Integer id
    ){
        this.id = id;
    }

		
	public void setId(Integer value) {
		this.id = value;
	}
		
	public Integer getId() {
		return this.id;
	}
		
	
		
	public void setMerchantId(String value) {
		this.merchantId = value;
	}
		
	public String getMerchantId() {
		return this.merchantId;
	}
		
	
		
	public void setWxNo(String value) {
		this.wxNo = value;
	}
		
	public String getWxNo() {
		return this.wxNo;
	}
		
	
		
	public void setWxName(String value) {
		this.wxName = value;
	}
		
	public String getWxName() {
		return this.wxName;
	}
		
	
		
	public void setLogo(String value) {
		this.logo = value;
	}
		
	public String getLogo() {
		return this.logo;
	}
		
	
		
	public void setAddress(String value) {
		this.address = value;
	}
		
	public String getAddress() {
		return this.address;
	}
		
	
		
	public void setName(String value) {
		this.name = value;
	}
		
	public String getName() {
		return this.name;
	}
		
	
		
	public void setPhone(String value) {
		this.phone = value;
	}
		
	public String getPhone() {
		return this.phone;
	}
		
	
		
	public void setSex(Integer value) {
		this.sex = value;
	}
		
	public Integer getSex() {
		return this.sex;
	}
		
	
		
	public void setStatus(Integer value) {
		this.status = value;
	}
		
	public Integer getStatus() {
		return this.status;
	}
		
	
		
	public void setLatitude(String value) {
		this.latitude = value;
	}
		
	public String getLatitude() {
		return this.latitude;
	}
		
	
		
	public void setLongitude(String value) {
		this.longitude = value;
	}
		
	public String getLongitude() {
		return this.longitude;
	}
		
	
		
	public void setPrecisionx(String value) {
		this.precisionx = value;
	}
		
	public String getPrecisionx() {
		return this.precisionx;
	}
		
	public String getRechargeUrl() {
        return rechargeUrl;
    }

    public void setRechargeUrl(String rechargeUrl) {
        this.rechargeUrl = rechargeUrl;
    }

    public String getBindKey() {
        return bindKey;
    }

    public void setBindKey(String bindKey) {
        this.bindKey = bindKey;
    }

    public String getWelcomeContent() {
        return welcomeContent;
    }

    public void setWelcomeContent(String welcomeContent) {
        this.welcomeContent = welcomeContent;
    }

}

