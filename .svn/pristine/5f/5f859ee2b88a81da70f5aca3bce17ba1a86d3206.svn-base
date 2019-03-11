package com.glsx.oms.fcwechat.biz.flowcard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glsx.oms.fcwechat.biz.flowcard.mapper.FlowcardMapper;
import com.glsx.oms.fcwechat.biz.flowcard.model.FlowCard;

@Service
public class FlowcardService {

	@Autowired
	private FlowcardMapper flowcardMapper;
	
	public void updateOpenId(FlowCard flowCard){
		flowcardMapper.updateOpenId(flowCard);
	}
	
	public void updateOpenIdNotify(FlowCard flowCard){
		flowcardMapper.updateOpenIdNotify(flowCard);
	}
	
	public String getKeyword(String openId){
		return flowcardMapper.getKeyword(openId);
	}
	
	public void updatePhoneNo(FlowCard bean){
		flowcardMapper.updatePhoneNo(bean);
	}
	
	public FlowCard getCardPackageInfo(String imsi){
		return flowcardMapper.getCardPackageInfo(imsi);
	}
}
