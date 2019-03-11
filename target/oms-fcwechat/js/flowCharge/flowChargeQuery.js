
var $confirm = $('#comfirm');
var $queryInput = $("#query-input")
$('input').clearable({
	callback : function() {
		if ($('input').val()!= '') {
			$confirm.removeAttr("disabled");
		} else {
			$confirm.attr("disabled", "disabled");
		}
	}
});
//链接代参数
var url = window.location.href;
if(new RegExp("state").test(url)){
	keyWord = url.split("state=")[1];
	
	if(keyWord==""||keyWord=="1"){
		$.ajax({
			url : baseUrl + "api/getKeyword",
			success : function(data) {
				var keyWord = data;
				
				if(typeof(keyWord) != 'undefined'){
					$queryInput.val(keyWord);
					$confirm.removeAttr("disabled");
				}
			}
		})
	}
	
	if (typeof(keyWord) != 'undefined') {
	    $queryInput.val(keyWord);
	    $confirm.removeAttr("disabled");
	}
	
}else{
	//keyWord = $.cookie('the_cookie_keyWord');
	$.ajax({
		url : baseUrl + "api/getKeyword",
		success : function(data) {
			var keyWord = data;
			
			if(typeof(keyWord) != 'undefined'){
				$queryInput.val(keyWord);
				$confirm.removeAttr("disabled");
			}
		}
	})
}

/*if(keyWord==""||keyWord=="1"){
	keyWord = $.cookie('the_cookie_keyWord');
}

if (typeof(keyWord) != 'undefined') {
    $queryInput.val(keyWord);
    $confirm.removeAttr("disabled");
}*/

$queryInput.on('keyup paste change',function() {
	var self = this;
	if($queryInput.val().length>21){
		$queryInput.val($queryInput.val().substring(0,21));
	}
	setTimeout(function(){		
	    if (self.value.trim()) {
	    	$confirm.removeAttr("disabled");
	    } else {
	    	$confirm.attr("disabled","disabled");
	    }
	},0)
});

$.toast.prototype.defaults.duration = 2000;

$confirm.click(function() {
    $.showLoading('');   
    setTimeout(function() {
    	var keyWord=$queryInput[0].value;
    	//$.cookie('the_cookie_keyWord', keyWord,{path: "/",expires: 30}); 
        $.hideLoading();
	        $.ajax({
            url: baseUrl + "api/findFlowCardByKeyWord/" + keyWord + "/false",
            success: function(data) {
                if (data.cardInfo == null) {
                    $.toast("卡号信息错误，请重新输入", "text");
                } else {
                	sessionStorage.setItem("cardInfo",JSON.stringify(data.cardInfo));
                	location.href = baseUrl+"html/flowCharge/selectFlowType.html";
                }
            },
        })

    }, 1000)
});

