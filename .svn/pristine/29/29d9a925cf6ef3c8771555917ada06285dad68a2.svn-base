var wcPay;
$(document).ready(function() {
	
	var cardInfo = JSON.parse(sessionStorage.getItem("cardInfo"));
	$("#iccid").html(cardInfo.iccid.replace(/(\d{4})/g, "$1 "));
	$("#imsi").html(cardInfo.imsi.replace(/(\d{4})/g, "$1 "));
	$("#cardNo").html(cardInfo.cardNo.replace(/(\d{2})/, "$1 "));
	
	var args = new Object();
	args = $.getUrlParams();
	
	$("#flowTypeName").html(args["flowTypeName"]);
	$("#flowTitle").html(args["flowTitle"]);
	$("#validDes").html(args["validDes"]);
	$(".text-pay").html(args["price"]+"元");
	$("#flowpkgname").html(args["flowpkgname"]);
	$("#validtime").html(args["validtime"]);
	
	if(args["flowTypeName"] == '月付流量套餐'){
		$('#clearZeroRule').show();
		$('#monthPayTime').show();
		$("#is_month_clean").html(args["is_month_clean"]);
		$("#flowserv_pay_date").html(args["flowserv_pay_date"]);
	}
	
	$("#orderPay").click(function() {
		$.ajax({
			type : "post",
			url : baseUrl + "api/processOrder",
			data : {},
			success : function(data) {
				if (null != data.order_no) {
					wcPay = data.wcPay;
					callPay();
				} else {
					$.toast('订单生成失败!');
					return;
				}
			}
		})
	})
});

// 调用微信JS api 支付
function onBridgeReady() {
	WeixinJSBridge.invoke('getBrandWCPayRequest', {
		"appId" : wcPay.appId, // 公众号名称，由商户传入
		"timeStamp" : wcPay.timeStamp, // 时间戳，自1970年以来的秒数
		"nonceStr" : wcPay.nonceStr, // 随机串
		"package" : wcPay.package,
		"signType" : wcPay.signType, // 微信签名方式：
		"paySign" : wcPay.paySign
	// 微信签名
	}, function(res) {
		// 使用以上方式判断前端返回,微信团队郑重提示：res.err_msg将在用户支付成功后返回
		// ok，但并不保证它绝对可靠。
		if (res.err_msg == "get_brand_wcpay_request:ok") {
			// $.toast("用户支付成功");
			window.location.href = baseUrl + "/html/flowCharge/paymentOk.html";
		}
		if (res.err_msg == "get_brand_wcpay_request:cancel") {
			$.toast("用户取消支付");
		}
		if (res.err_msg == "get_brand_wcpay_request:fail") {
			// $.toast("用户支付失败：" + "err_code["+res.err_code +"],err_msg["+
			// res.err_desc + res.err_msg+"]");
		}
	});
}

function callPay() {
	if (typeof WeixinJSBridge == "undefined") {
		alert('浏览器不支持支付!');
		if (document.addEventListener) {
			document.addEventListener('WeixinJSBridgeReady', onBridgeReady,
					false);
		} else if (document.attachEvent) {
			document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
			document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
		}
	} else {
		onBridgeReady();
	}
};

