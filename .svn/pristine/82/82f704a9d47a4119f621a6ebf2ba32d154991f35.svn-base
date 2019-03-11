var cardInfo = JSON.parse(sessionStorage.getItem("cardInfo"));
var iccid = cardInfo.iccid.replace(/(\d{4})/g, "$1 ").trim();
var imsi = cardInfo.imsi.replace(/(\d{4})/g, "$1 ").trim();
var cardNo = cardInfo.cardNo.replace(/(\d{2})/, "$1 ").trim();
var checkResult = false;

$("#iccid").html(iccid);
$("#imsi").html(imsi);
$("#cardNo").html(cardNo);

var $phoneNo=$("#phoneNo");
var $authCode=$("#authCode");
var $submit=$("#submit");
$submit.attr("disabled",true);

//小叉叉
$('#phoneNo').clearable();
$('#idNo').clearable();
$('#name').clearable();

//验证码发送的提示
$.toast.prototype.defaults.duration = 3000;


//按钮能不能可用
$("input").keyup(function(){
	if(($("#phoneNo").val()!="")&&($("#code").val()!="")&&($("#name").val()!="")&&($("#idNo").val()!="")&&($(".id-card_front").find($("img")).attr("src")!=undefined)&&($(".id-card_obverse").find($("img")).attr("src")!=undefined)&&($(".id-card_handheld").find($("img")).attr("src")!=undefined))
	{
		$submit.removeAttr("disabled");
	}else if(($("#phoneNo").val()=="")&&($("#code").val()=="")||($("#name").val()=="")||($("#idNo").val()=="")||($(".id-card_front").find($("img")).attr("src")==undefined)||($(".id-card_obverse").find($("img")).attr("src")==undefined)||($(".id-card_handheld").find($("img")).attr("src")==undefined))
	{
		$submit.attr("disabled",true);
	}
});

//验证码是否可用
$phoneNo.keyup(function(){
	var value = $(this).val();
	value = value.replace(/\D/g,'');
	$(this).val(value);
	if($("#phoneNo").val().length==11){
		$authCode.removeAttr("disabled");
	}	
});

//验证码获取
$("#authCode").click(function(){
	//先验证手机号是否正确
	var reg = /^1[34578]\d{9}$/;
	if(!reg.test($("#phoneNo").val())) {
		$.toptip('请输入正确的手机号');
		$("#phoneNo").val("");
		$("#phoneNo").focus(); 
	}
	else{
		//发送提示
		$.toast("验证码已发送", "text");
		//倒计时
		$.ajax({
			type:"post",
			url:baseUrl+"api/sendMess",
			data:{"phoneNo":$("#phoneNo").val(),
			success:function(){
				setCodetime();
				checkResult = false;
			}}
		})
	}

});

//验证码倒计时
var count=59;
function setCodetime(){
	if (count == 0) {
		$authCode.removeAttr("disabled");
		$authCode.html("重新获取");
		$("#code").focus();
		count=59;
	}else {
		$authCode.attr("disabled",true);
		$authCode.html(count+"S");
		//$("#code").focus();
		count--;
		setTimeout(function(){
			setCodetime();
		},1000)
	}
}

$submit.click(function(){
	
	//验证身份证有效
	var reg = /(^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$)|(^[1-9]\d{5}\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{2}$)/;
	if(!reg.test($("#idNo").val())) {
		$.toptip('请输入有效的身份证号码');
		$("#idNo").val("");
		$("#idNo").focus();
		$submit.attr("disabled",true);
	}else{
		//其他信息传到后台接口
		var jsonData={"imsi":cardInfo.imsi,
				  "name":$("#name").val(),
				  "phoneNo":$("#phoneNo").val(),
				  "idNo":$("#idNo").val(),
				  "photoPos":$(".id-card_front").find($(".progress input")).attr("value"),
				  "photoOpp":$(".id-card_obverse").find($(".progress input")).attr("value"),
				  "photo":$(".id-card_handheld").find($(".progress input")).attr("value"),
				  "phoneNo":$("#phoneNo").val(),
				  "randomPassword":$("#code").val()};
		
		
		if(checkResult){
			$.ajax({
				type:"post",
				url:baseUrl+"api/saveAuth",
				data:jsonData,
				success:function(data)
				{
					if(data.summitRes=="0"){
						window.location.href=baseUrl+"html/auth/"+"commitInfo.html";
					}								
				}
			})		
		}else{
			//判断验证码是否正确
			$.ajax({
				type:"post",
				url: baseUrl+"api/checkMess",
				data:{"phoneNo":$("#phoneNo").val(),"randomPassword":$("#code").val()},
				success:function(data){
					checkResult = data.checkResult;
					
					if(!data.checkResult){
						$.toptip('请输入正确验证码');
						$("#code").val("");
						$("#code").focus();
						
					}else{
						$.ajax({
							type:"post",
							url:baseUrl+"api/saveAuth",
							data:jsonData,
							success:function(data)
							{
								if(data.summitRes=="0"){
									window.location.href=baseUrl+"html/auth/"+"commitInfo.html";
								}								
							}
						})		
					}			
				}
			})
		}
		
	}
	
	
		
})