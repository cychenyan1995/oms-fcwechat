package com.glsx.oms.fcwechat.framework.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getCode")
public class WxCodeServlet extends HttpServlet{

	 public void doGet(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  
	  
	        doPost(request, response);  
	    }  
	  
	    public void doPost(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  
	  
	        response.setContentType("text/html");  
	        response.setCharacterEncoding("UTF-8");  
	        request.setCharacterEncoding("UTF-8");  
	                //这里要将你的授权回调地址处理一下，否则微信识别不了  
	        String redirect_uri=URLEncoder.encode("http://devwx.glsx.com.cn/fcwechat/oauth", "UTF-8");  
	                //简单获取openid的话参数response_type与scope与state参数固定写死即可  
	        StringBuffer url=new StringBuffer("https://open.weixin.qq.com/connect/oauth2/authorize?redirect_uri="+redirect_uri+  
	                "&appid=wx4a3fe8eba7ab8bd5"/*你的appid*/
	        		+"&response_type=code&scope=snsapi_base&state=1#wechat_redirect");  
	        response.sendRedirect(url.toString());//这里请不要使用get请求单纯的将页面跳转到该url即可  
	    }
}
