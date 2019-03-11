package com.glsx.oms.fcwechat.biz.flowcard.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.glsx.oms.fcwechat.biz.flowcard.model.FlowCard;

@Mapper
public interface FlowcardMapper{

	public void updateOpenId(FlowCard flowCard);
	
	public void updateOpenIdNotify(FlowCard flowCard);
	
	public String getKeyword(String openId);
	
	public void updatePhoneNo(FlowCard bean);
	
	public FlowCard getCardPackageInfo(String imsi);
}
