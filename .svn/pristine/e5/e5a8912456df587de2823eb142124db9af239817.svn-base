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

// 设置查询按钮是否可用
$queryInput.on('keyup paste change', function() {
	var self = this;
	if($queryInput.val().length>21){
		$queryInput.val($queryInput.val().substring(0,21));
	}
	setTimeout(function() {
		if (self.value.trim()) {
			$confirm.removeAttr("disabled");
		} else {
			$confirm.attr("disabled", "disabled");
		}
	}, 0)
});

$(document).ready(function() {
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
})
//var keyWord = $.cookie('the_cookie_keyWord');

$.toast.prototype.defaults.duration = 2000;

$confirm.click(function() {
	$.showLoading('');
	setTimeout(function() {
		var keyWord = $queryInput[0].value;
		/*$.cookie('the_cookie_keyWord', keyWord, {
			path : "/",
			expires : 30
		});*/
		$.hideLoading();
		$.ajax({
			url : baseUrl + "api/findFlowCardByKeyWord/" + keyWord + "/true",
			success : function(data) {
				if (data.cardInfo == null){
					$.toast("卡号信息错误，请重新输入", "text");
				}
				else {
					sessionStorage.setItem("cardInfo",JSON.stringify(data.cardInfo));
					location.href = baseUrl + "html/queryFlow/flowDetail.html";
				}
			},
		})

	}, 1000)
});
