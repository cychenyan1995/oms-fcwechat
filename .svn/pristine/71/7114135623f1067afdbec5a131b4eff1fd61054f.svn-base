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

var keyWord = $.cookie('the_cookie_keyWord');
if (typeof(keyWord) != 'undefined') {
    $queryInput.val(keyWord);
    $confirm.removeAttr("disabled");
}

$queryInput.on('keyup paste change',
function() {
    var self = this;
    if ($queryInput.val().length > 21) {
        $queryInput.val($queryInput.val().substring(0, 21));
    }
    setTimeout(function() {
        if (self.value.trim()) {
            $confirm.removeAttr("disabled");
        } else {
            $confirm.attr("disabled", "disabled");
        }
    },
    0)
});
$.toast.prototype.defaults.duration = 2000;

$confirm.click(function() {
    $.showLoading('');
    setTimeout(function() {
        var keyWord = $queryInput[0].value;
        $.cookie('the_cookie_keyWord', keyWord, {
            path: "/",
            expires: 30
        });
        $.hideLoading();
        $.ajax({
            url: baseUrl + "api/findFlowCardByKeyWord/" + keyWord + "/false",
            success: function(data) {
                if (data.cardInfo == null) {
                    $.toast("卡号信息错误，请重新输入", "text");
                } else {
                	sessionStorage.setItem("cardInfo",JSON.stringify(data.cardInfo));
                    $.ajax({
                        type: "post",
                        url: baseUrl + "api/toAuth",
                        success: function(data) {
                            var isAuth = data.isAuth;
                            if (isAuth == 4) { //未实名
                                location.href = baseUrl + "html/auth/" + "fillMaterialCertification.html";
                            } else {
                                if (isAuth == 2) {
                                    window.location.href = baseUrl + "html/auth/" + "authenticationResult.html?" + isAuth + "?" + encodeURI(data.msg);
                                } else {
                                    window.location.href = baseUrl + "html/auth/" + "authenticationResult.html?" + isAuth;
                                }
                            }
                        }
                    })
                }
            },
        })
    },
    1000)
})