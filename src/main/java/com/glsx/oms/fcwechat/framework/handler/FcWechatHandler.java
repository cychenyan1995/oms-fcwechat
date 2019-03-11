package com.glsx.oms.fcwechat.framework.handler;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.oreframework.context.SpringContext;

import com.glsx.oms.fcwechat.biz.Constants;
import com.glsx.oms.fcwechat.biz.flowcard.model.FlowCard;
import com.glsx.oms.fcwechat.biz.flowcard.service.FlowcardService;
import com.glsx.oms.fcwechat.biz.wechat.user.model.User;
import com.glsx.oms.fcwechat.biz.wechat.user.service.UserService;
import com.glsx.oms.fcwechat.framework.config.WxToolsProperties;
import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxConsts;
import com.soecode.wxtools.api.WxMessageHandler;
import com.soecode.wxtools.bean.WxXmlMessage;
import com.soecode.wxtools.bean.WxXmlOutMessage;
import com.soecode.wxtools.exception.WxErrorException;

/**
 * 示例：DemoHandler 目的：返回用户 “恭喜你中奖了”
 * 
 * @author antgan
 * @date 2016/12/15
 *
 */
public class FcWechatHandler implements WxMessageHandler {
    private UserService       userService;
    
    private FlowcardService flowcardService;

    private static String     merchantId     = "19180001";

    private static String     weclomeContent = "欢迎关注广联流量管理平台!";

    private WxToolsProperties wxToolsProperties;
    
    String tip_message = "";

    private User welcome(WxXmlMessage wxMessage, IService iService, String bindKey) throws WxErrorException {
        User eventUser = new User();
        String keyWord = null;

        if (StringUtils.isNotEmpty(wxMessage.getEventKey())) {
            if (wxMessage.getEventKey().indexOf("_") > 0) {
                String[] eventKey = wxMessage.getEventKey().split("_");
                keyWord = eventKey[1];
            } else {
                keyWord = wxMessage.getEventKey();
            }
        } else {
            keyWord = wxMessage.getEventKey();
        }

        if (StringUtils.isEmpty(keyWord)) {
            return null;
        }
        
        wxToolsProperties = (WxToolsProperties) SpringContext.getBean("wxToolsProperties");
        String appid = wxToolsProperties.getAppId();
        String baseUrl = wxToolsProperties.getBaseUrl();
        String redirect_url = "";
        
        //判断当前套餐是否已开通
        flowcardService = (FlowcardService) SpringContext.getBean("flowcardService");
        FlowCard bean = flowcardService.getCardPackageInfo(keyWord);
        
        if((Constants.STATUS_STOCK.equals(bean.getPackage_status()) && Constants.WHITE_STATUS_NO.equals(bean.getEmptyStatus()))
        		|| (Constants.STATUS_STOCK.equals(bean.getPackage_status()) && Constants.WHITE_STATUS_OPEN.equals(bean.getEmptyStatus()))
        		|| (Constants.STATUS_STOCK.equals(bean.getPackage_status()) && Constants.WHITE_STATUS_USE.equals(bean.getEmptyStatus()))
        		|| (Constants.STATUS_ACTIVE.equals(bean.getPackage_status()) && Constants.WHITE_STATUS_USE.equals(bean.getEmptyStatus()))
        		|| (Constants.STATUS_WHITE_EXCEED.equals(bean.getPackage_status()) && Constants.WHITE_STATUS_USE.equals(bean.getEmptyStatus())))
        {
        	//如果当前开卡套餐未开通或者为白卡套餐
        	redirect_url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appid + "&redirect_uri=" + baseUrl + "/html/api/router?action=openPackage&response_type=code&" + "scope=snsapi_base&state=" + keyWord + "#wechat_redirect";
        	tip_message = "请点我立即开通套餐^_^";
        }else{
        	redirect_url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=" + appid + "&redirect_uri=" + baseUrl + "/html/api/router?action=flowCharge&response_type=code&" + "scope=snsapi_base&state=" + keyWord + "#wechat_redirect";
            tip_message = "请点我立即续费^_^";
        }

        String short_url = iService.getShortUrl(redirect_url);

        if (StringUtils.isNotEmpty(short_url)) {
            eventUser.setRechargeUrl(short_url);
        } else {
            eventUser.setRechargeUrl(redirect_url);
        }

        String weclome = builderWeclcome(redirect_url,tip_message);
        eventUser.setWelcomeContent(weclome);
        eventUser.setBindKey(keyWord);
        return eventUser;
    }

    private String builderWeclcome(String redirect_url,String tip_message) {
        StringBuilder builder = new StringBuilder();
        builder.append(weclomeContent + " \n");
        builder.append("<a href=\"" + redirect_url + "\"> " + tip_message + "</a>\n");
        return builder.toString();
    }

    private WxXmlOutMessage getOutMsg(WxXmlMessage wxMessage, String welcomeContent) {
        WxXmlOutMessage xmlOutMsg;
        xmlOutMsg = WxXmlOutMessage.TEXT().content(welcomeContent).toUser(wxMessage.getFromUserName()).fromUser(wxMessage.getToUserName()).build();
        return xmlOutMsg;
    }

    @Override
    public WxXmlOutMessage handle(WxXmlMessage wxMessage, Map<String, Object> context, IService iService) throws WxErrorException {

        // 必须以build()作为结尾，否则不生效。
        WxXmlOutMessage xmlOutMsg = null;
        userService = (UserService) SpringContext.getBean("userService");

        // 关注
        if (WxConsts.EVT_SUBSCRIBE.equals(wxMessage.getEvent())) {
            User user = new User();
            user.setWxNo(wxMessage.getFromUserName());
            user = userService.getUser(user);
            
            String bindKey = null;
            if (null != user) {
                bindKey = user.getBindKey();
            }

            User eventUser = welcome(wxMessage, iService, bindKey);
            if (null != eventUser) {
                user.setBindKey(eventUser.getBindKey());
                user.setRechargeUrl(eventUser.getRechargeUrl());
                user.setWelcomeContent(eventUser.getWelcomeContent());
            }

            if (null == user) {
                user = new User();
                user.setWxNo(wxMessage.getFromUserName());
                user.setMerchantId(merchantId);
                user.setStatus(1);
                userService.save(user);
            } else {
                user.setMerchantId(merchantId);
                user.setStatus(1);
                userService.updateUserStatus(user);
            }

            if (StringUtils.isNotEmpty(user.getRechargeUrl())) {
                xmlOutMsg = getOutMsg(wxMessage, builderWeclcome(user.getRechargeUrl(),tip_message));
                return xmlOutMsg;
            } else {
                xmlOutMsg = getOutMsg(wxMessage, weclomeContent);
            }
        }

        if (WxConsts.EVT_SCAN.equals(wxMessage.getEvent())) {
            User user = new User();
            user.setWxNo(wxMessage.getFromUserName());
            user = userService.getUser(user);
            if (wxMessage.getEventKey() != null && null != user) {
                User eventUser = welcome(wxMessage, iService, user.getBindKey());
                if (null != eventUser) {
                    user.setBindKey(eventUser.getBindKey());
                    user.setRechargeUrl(eventUser.getRechargeUrl());
                    user.setWelcomeContent(eventUser.getWelcomeContent());
                    user.setMerchantId(merchantId);
                    user.setStatus(1);
                    userService.updateUserStatus(user);
                }
                if (StringUtils.isNotEmpty(user.getRechargeUrl())) {
                    xmlOutMsg = getOutMsg(wxMessage, builderWeclcome(user.getRechargeUrl(),tip_message));
                } else {
                    xmlOutMsg = getOutMsg(wxMessage, weclomeContent);
                }
                return xmlOutMsg;
            } else {
                xmlOutMsg = getOutMsg(wxMessage, weclomeContent);
            }
        }

        // 取消关注
        if (WxConsts.EVT_UNSUBSCRIBE.equals(wxMessage.getEvent())) {
            User user = new User();
            user.setWxNo(wxMessage.getFromUserName());
            user = userService.getUser(user);
            if (null == user) {
                user = new User();
                user.setWxNo(wxMessage.getFromUserName());
                user.setMerchantId(merchantId);
                user.setStatus(0);
                userService.save(user);
            } else {
                user.setMerchantId(merchantId);
                user.setStatus(0);
                user.setBindKey("");
                userService.updateUserStatus(user);
            }
        }

        return xmlOutMsg;
    }

}
