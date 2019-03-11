package com.glsx.oms.fcwechat.biz.flowcard.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glsx.oms.fcwechat.biz.flowcard.mapper.MsgLogMapper;
import com.glsx.oms.fcwechat.biz.flowcard.model.MsgLog;



/**
 * @author xiaowy 2017年3月18日
 */
@Service
public class MsgLogService
{
    
    @Autowired
    private MsgLogMapper msgLogMapper;
    
    public void insertLog(MsgLog msgLog){
    	msgLogMapper.insertLog(msgLog);
    }
    
}
