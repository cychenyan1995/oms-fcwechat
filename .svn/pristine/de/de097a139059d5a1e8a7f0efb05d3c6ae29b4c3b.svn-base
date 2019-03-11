package com.glsx.oms.fcwechat.biz.flowcard.rop;

import org.apache.commons.lang.StringUtils;
import org.oreframework.common.lang.date.DateCalculation;
import org.oreframework.common.lang.date.DateFormatConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.glsx.oms.fcwechat.biz.flowcard.model.Qrcode;
import com.glsx.oms.fcwechat.biz.flowcard.rop.request.QrcodeRquest;
import com.glsx.oms.fcwechat.biz.flowcard.rop.response.QrcodeGeneResponse;
import com.glsx.oms.fcwechat.biz.flowcard.service.QrcodeService;
import com.rop.annotation.IgnoreSignType;
import com.rop.annotation.NeedInSessionType;
import com.rop.annotation.ServiceMethod;
import com.rop.annotation.ServiceMethodBean;
import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.WxQrcode;
import com.soecode.wxtools.bean.WxQrcode.WxQrActionInfo;
import com.soecode.wxtools.bean.WxQrcode.WxQrActionInfo.WxScene;
import com.soecode.wxtools.bean.result.QrCodeResult;
import com.soecode.wxtools.exception.WxErrorException;

@ServiceMethodBean(version = "1.0.0", needInSession = NeedInSessionType.NO)
public class QrCodeGenerateController {

    private static String QR_STR_SCENE = "QR_STR_SCENE";

    /**
     * logger
     */
    protected final Logger logger = LoggerFactory.getLogger(QrCodeGenerateController.class);

    //实例化 统一业务API入口
    private IService  iService = new WxService();
    
    @Autowired
    private QrcodeService qrcodeService;
    
    private String saveQrCode(String kewWord, String flag) throws WxErrorException{
		String accessToken = iService.getAccessToken();
		String qrcodeUrl = "";
        if (!"".equals(accessToken) && accessToken != null) {
        	WxQrcode qrcode = new WxQrcode();
            WxScene scene = new WxScene(0);
            scene.setScene_str(kewWord);
            WxQrActionInfo wxQrActionInfo = new WxQrActionInfo(scene);

            qrcode.setAction_info(wxQrActionInfo);
            qrcode.setAction_name(QR_STR_SCENE);
            qrcode.setExpire_seconds(2592000);

            QrCodeResult qrCodeResult = iService.createQrCode(qrcode);
            if (StringUtils.isNotEmpty(qrCodeResult.getUrl())) {
            	qrcodeUrl = qrCodeResult.getUrl();
            	String ticket = qrCodeResult.getTicket();
            	int expireSeconds = qrCodeResult.getExpire_seconds();
            	
            	Qrcode saveQrcode = new Qrcode();
            	saveQrcode.setImsi(kewWord);
            	saveQrcode.setQrcodeUrl(qrcodeUrl);
            	saveQrcode.setTicket(ticket);
            	saveQrcode.setExpireSeconds(expireSeconds);
                
                if(flag.equals("update")){
                	qrcodeService.updateQrcode(saveQrcode);
                }
                
                if(flag.equals("insert")){
                	qrcodeService.insertQrcode(saveQrcode);
                }
            }
            
        }
        return qrcodeUrl;
	}
    
    private boolean checkStayDay(String startDate) throws Exception {

        String endDate = DateCalculation.getCurrentDate(DateFormatConstants.DATE_FORMAT);

        DateCalculation.addDay(DateCalculation.getCurrentDate(DateFormatConstants.DATE_FORMAT), 2);
        int day = DateCalculation.getComDays(startDate, endDate, DateFormatConstants.DATE_FORMAT);
        if (day >= 29) {
            return true;
        } else {
            return false;
        }
    }
    
    @ServiceMethod(method = "glsx.fcwechat.api.qrCodeGenerate", ignoreSign = IgnoreSignType.YES, needInSession = NeedInSessionType.NO)
    public QrcodeGeneResponse qrCodeGenerate(QrcodeRquest qrcodeRquest) {
    	QrcodeGeneResponse response = new QrcodeGeneResponse();
        String kewWord = qrcodeRquest.getKewWord();
        logger.info("qrCodeGenerate request params imsi: {}", kewWord);
        
        if("".equals(kewWord) || kewWord == null){
    		response.setRetrunCode(1);
    		response.setRetrunMessage("传入imsi为空!");
    		return response;
    	}
        
        try {
        	Qrcode qrcode = qrcodeService.selectQrcode(kewWord);
        	if(qrcode != null && qrcode.getQrcodeUrl() != null){
        		int expireSeconds = qrcode.getExpireSeconds();
        		String creatTime = qrcode.getCreateTime();
        		/*String nowTime = DateUtils.getCurrentDate(DateFormatConstants.DATE_FORMAT);
        		SimpleDateFormat myFormatter = new SimpleDateFormat( "yyyy-MM-dd");
        		long timeInterval = (myFormatter.parse(nowTime).getTime() - myFormatter.parse(creatTime).getTime())/(24*60*60*1000);*/
        		
        		if(checkStayDay(creatTime)) { //过期
        			String qrcodeUrl = saveQrCode(kewWord,"update");
        			response.setRetrunCode(0);
        			response.setQrcodeUrl(qrcodeUrl);
        		} else {
        			response.setRetrunCode(0);
        			response.setQrcodeUrl(qrcode.getQrcodeUrl());
        		}
        	} else {
        		String qrcodeUrl = saveQrCode(kewWord,"insert");
        		response.setRetrunCode(0);
    			response.setQrcodeUrl(qrcodeUrl);
        	}
        	

        } catch (Exception e) {
            e.printStackTrace();
            response.setRetrunCode(1);
    		response.setRetrunMessage("qrCodeGenerate Exception!" + e);
            logger.error("QrCodeGenerate Exception:" + e);
        }

        logger.info("qrCodeGenerate response: "+response.toString());
        return response;

    }

}
