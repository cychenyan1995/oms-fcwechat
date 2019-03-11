var checkResult = false;

var urlSearch = location.search;
var i=urlSearch.lastIndexOf("=");
var imsi = urlSearch.substring(i+1,urlSearch.length);

var $phoneNo=$("#phoneNo");
var $authCode=$("#authCode");
var $submit=$("#submit");
$submit.attr("disabled",true);

//小叉叉
$('#phoneNo').clearable();

//验证码发送的提示
$.toast.prototype.defaults.duration = 3000;

//按钮能不能可用
$("input").keyup(function(){
	if($("#phoneNo").val()!="")
	{
		$submit.removeAttr("disabled");
	}else if($("#phoneNo").val()=="")
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
		count--;
		setTimeout(function(){
			setCodetime();
		},1000)
	}
}

$submit.click(function(){
	//信息传到后台接口
	var jsonData={"imsi":imsi,
			  "phoneNo":$("#phoneNo").val(),
			  "randomPassword":$("#code").val()};
	
	if(checkResult){
		$.ajax({
			type:"post",
			url:baseUrl+"api/openPackage",
			data:jsonData,
			success:function(data)
			{
				if(data.summitRes=="1000"){
					window.location.href=baseUrl+"html/openPackage/openSuccess.html";
				}else{
					var msg = data.errorMsg;
					window.location.href=encodeURI(baseUrl+"html/openPackage/openFail.html?msg="+msg);
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
						url:baseUrl+"api/openPackage",
						data:jsonData,
						success:function(data)
						{
							if(data.summitRes=="1000"){
								window.location.href=baseUrl+"html/openPackage/openSuccess.html";
							}else{
								var msg = data.errorMsg;
								window.location.href=encodeURI(baseUrl+"html/openPackage/openFail.html?msg="+msg);
							}							
						}
					})		
				}			
			}
		})
	}
})