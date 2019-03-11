package com.glsx.oms.fcwechat.biz.flowcard.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glsx.oms.fcwechat.biz.flowcard.mapper.PayLogMapper;
import com.glsx.oms.fcwechat.biz.flowcard.model.PayLog;

/**
 * @author xiaowy 2017年3月18日
 */
@Service
public class PayLogService
{
    
    @Autowired
    private PayLogMapper payLogMapper;
    
    public void insertLog(PayLog payLog){
        payLogMapper.insertLog(payLog);
    }
    
}
