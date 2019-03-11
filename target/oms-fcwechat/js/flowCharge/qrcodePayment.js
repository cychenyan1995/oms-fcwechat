var $confirm = $('#comfirm');
$(document).ready(function() {
	var args = new Object();
	args = $.getUrlParams();
	$("#qrcode").attr("src","../../qrcode/"+args["sessionId"]);
});
$confirm.click(function() {
	window.location.href = baseUrl + "api/discernQrcode";
});
