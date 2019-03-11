package com.glsx.oms.fcwechat.biz.flowcard.mapper;

import org.apache.ibatis.annotations.Mapper;

import org.oreframework.datasource.mybatis.mapper.OreMapper;

import com.glsx.oms.fcwechat.biz.flowcard.model.PayLog;

@Mapper
public interface PayLogMapper extends OreMapper<PayLog>{
    
	public void insertLog(PayLog payLog);
}