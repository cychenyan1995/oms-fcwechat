$.ajax({
	type : "post",
	url : baseUrl + "api/toAuth",
	success : function(data) {
		var obj = data.cardInfo;
		$("#iccid").html(obj.iccid.replace(/(\d{4})/g, "$1 "));
		$("#imsi").html(obj.imsi.replace(/(\d{4})/g, "$1 "));
		$("#cardNo").html(obj.cardNo.replace(/(\d{2})/, "$1 "));
		var isAuth = data.isAuth;

		// 待审核
		if ((isAuth == 0 || isAuth == 3)) {
			$("#authStatus").removeClass();
			$("#authStatus").addClass("weui-icon-lg weui-icon-reviewing");
			$(".weui-msg__desc").css("display", "none");
			$(".weui-msg__opr-area").css("display", "none");
			$(".weui-icon_msg").html("待审核");
		} else if (isAuth == 4) { // 未实名
			location.href = "fillMaterialCertification.html";
		} else if (isAuth == 1) {// 已实名
			$("#authStatus").removeClass();
			$("#authStatus").addClass("weui-icon-lg weui-icon-successed");
			$(".weui-msg__desc").css("display", "none");
			$(".weui-msg__opr-area").css("display", "none");
			$(".weui-icon_msg").html("已实名");
		} else if (isAuth == 2) {// 审核不通过
			$("#authStatus").removeClass();
			$("#authStatus").addClass("weui-icon-lg weui-icon-failed");
			$(".weui-icon_msg").html("审核不通过");
			// 审核不通过的理由
			if (typeof (data.fail_reason) != "undefined" || data.fail_reason != null
					|| data.fail_reason != "") {
				$(".weui-msg__desc").html(data.fail_reason);
			}

		}
	}
})
