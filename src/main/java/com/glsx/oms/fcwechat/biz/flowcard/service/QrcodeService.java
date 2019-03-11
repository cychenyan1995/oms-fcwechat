package com.glsx.oms.fcwechat.biz.flowcard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.glsx.oms.fcwechat.biz.flowcard.mapper.QrcodeMapper;
import com.glsx.oms.fcwechat.biz.flowcard.model.Qrcode;

@Service
public class QrcodeService {

	@Autowired
	private QrcodeMapper qrcodeMapper;
	
	public Qrcode selectQrcode(String imsi){
		return qrcodeMapper.selectQrcode(imsi);
    }
	
	public void insertQrcode(Qrcode qrcode){
		qrcodeMapper.insertQrcode(qrcode);
    }
	
	public void updateQrcode(Qrcode qrcode){
		qrcodeMapper.updateQrcode(qrcode);
    }
}
