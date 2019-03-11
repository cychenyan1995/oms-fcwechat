var baseUrl = "/fcwechat/";
var url = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx4a3fe8eba7ab8bd5&redirect_uri=";
var param = "&response_type=code&scope=snsapi_base&state=1#wechat_redirect";

(function($) {
	$.getUrlParams = function() {
		var args = new Object();
		// 获取查询串
		var query = location.search.substring(1);
		// 在逗号处断开
		var pairs = query.split("&");
		for (var i = 0; i < pairs.length; i++) {
			// 查找name=value
			var pos = pairs[i].indexOf('=');
			// 如果没有找到就跳过
			if (pos == -1) {
				continue;
			}
			// 提取name
			var argname = pairs[i].substring(0, pos);
			// 提取value
			var value = pairs[i].substring(pos + 1);
			// 存为属性
			args[argname] = decodeURI(value);
		}
		return args;
	}
})(jQuery);
