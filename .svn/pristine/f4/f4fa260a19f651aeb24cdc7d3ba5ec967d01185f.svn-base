package com.glsx.oms.fcwechat.biz.flowcard.model;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.ibatis.type.JdbcType;

import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "flowmgn_pay_log")
public class PayLog
{
    @Id
    private long id;
    
    @ColumnType(jdbcType=JdbcType.VARCHAR)
    private String content;
    
    @ColumnType(jdbcType=JdbcType.DATE)
    private Date createTime;
    
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private int status;
    
    @ColumnType(jdbcType = JdbcType.INTEGER)
    private int processRet;
    
    
    

    public int getProcessRet()
    {
        return processRet;
    }

    public void setProcessRet(int processRet)
    {
        this.processRet = processRet;
    }

    public int getStatus()
    {
        return status;
    }

    public void setStatus(int status)
    {
        this.status = status;
    }

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
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
