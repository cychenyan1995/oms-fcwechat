package com.glsx.oms.fcwechat.biz.flowcard.model;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.ibatis.type.JdbcType;

import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "wechat_msglog")
public class MsgLog
{
    @Id
    private long id;
    
    @ColumnType(jdbcType=JdbcType.VARCHAR)
    private String imsi;
    
    @ColumnType(jdbcType=JdbcType.VARCHAR)
    private String content;
    
    @ColumnType(jdbcType=JdbcType.VARCHAR)
    private String openId;
    
    @ColumnType(jdbcType=JdbcType.DATE)
    private Date createTime;
    
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private String fail_reason;
    
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private int processRet;
    

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }
    
    public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public int getProcessRet()
    {
        return processRet;
    }

    public void setProcessRet(int processRet)
    {
        this.processRet = processRet;
    }

    public String getFail_reason()
    {
        return fail_reason;
    }

    public void setFail_reason(String fail_reason)
    {
        this.fail_reason = fail_reason;
    }

    public String getImsi()
    {
        return imsi;
    }

    public void setImsi(String imsi)
    {
        this.imsi = imsi;
    }

    public String getContent()
    {
        return content;
    }

    public void setContent(String content)
    {
        this.content = content;
    }

    public Date getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }
    
    
}
