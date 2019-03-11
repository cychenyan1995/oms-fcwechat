package com.glsx.oms.fcwechat.biz.flowcard.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.oreframework.datasource.mybatis.mapper.OreMapper;

import com.glsx.oms.fcwechat.biz.flowcard.model.Qrcode;

@Mapper
public interface QrcodeMapper extends OreMapper<Qrcode> {

	public Qrcode selectQrcode(String imsi);
	
	public void insertQrcode(Qrcode qrcode);
	
	public void updateQrcode(Qrcode qrcode);
}
