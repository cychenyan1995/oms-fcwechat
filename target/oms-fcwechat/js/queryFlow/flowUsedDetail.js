$(document).ready(function() {
    $.ajax({
        type: "post",
        url: baseUrl + "api/flowUsedDetail/30",
        success: function(data) {
            if (data.list != null) {
                for (var i = 0; i < data.list.length; i++) {
                    var obj = data.list[i];
                    $("#flowRecord").append('<div class=\"weui-cell\"><div class=\"weui-cell__bd\"><p>' + obj.datetime + '</p></div><div class=\"weui-cell__ft\">' + obj.usedflow + obj.flow_unit+'</div></div>');
                }
            } else {
                $("#flowRecord").html('<div class="box-flow-info">没查询到流量消耗明细!</div>');
            }
        }
    });
    
    $('.weui-btn').on("click",function(){
    	$('.weui-btn').each(function(){
    		$(this).removeClass("active");
    	});
    	$(this).addClass("active");
    	 $.ajax({
    	        type: "post",
    	        url: baseUrl + "api/flowUsedDetail/"+$(this).attr("value"),
    	        success: function(data) {
    	        	$("#flowRecord").empty();
    	            if (data.list != null) {
    	                for (var i = 0; i < data.list.length; i++) {
    	                    var obj = data.list[i];
    	                    $("#flowRecord").append('<div class=\"weui-cell\"><div class=\"weui-cell__bd\"><p>' + obj.datetime + '</p></div><div class=\"weui-cell__ft\">' + obj.usedflow + obj.flow_unit+'</div></div>');
    	                }
    	            } else {
    	                $("#flowRecord").html('<div class="box-flow-info">没查询到流量消耗明细!</div>');
    	            }
    	        }
    	  });
    	
    });
});
