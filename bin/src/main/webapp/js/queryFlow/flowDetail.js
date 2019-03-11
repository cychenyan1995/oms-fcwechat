$(document).ready(function() {
    $('#detailList').click(function() {
        location.href = baseUrl + "html/queryFlow/flowUsedDetail.html";
    });

    var cardInfo = JSON.parse(sessionStorage.getItem("cardInfo"));

    iccid = cardInfo.iccid.replace(/(\d{4})/g, "$1 ").trim();
    imsi = cardInfo.imsi.replace(/(\d{4})/g, "$1 ").trim();
    cardNo = cardInfo.cardNo.replace(/(\d{2})/, "$1 ").trim();
    $("#iccid").html(iccid);
    $("#imsi").html(imsi);
    $("#cardNo").html(cardNo);

    if (null != imsi) {
        var status = cardInfo.cardstatus;
        $("#status").removeClass();
        if (status == 0) // (0=可测试/1=库存卡/3=可激活/4=已激活/5=已停卡/6=已销卡)
            $("#status").addClass("weui-icon weui-icon-status weui-icon-enable");
        else if (status == 1) $("#status").addClass("weui-icon weui-icon-status weui-icon-stock");
        else if (status == 3) $("#status").addClass("weui-icon weui-icon-status weui-icon-activating");
        else if (status == 4) $("#status").addClass("weui-icon weui-icon-status weui-icon-actived");
        else if (status == 5) $("#status").addClass("weui-icon weui-icon-status weui-icon-disabled");
        else if (status == 6) $("#status").addClass("weui-icon weui-icon-status weui-icon-disabled");
        
        
        if (cardInfo.package_status == 0) // 套餐状态（0：库存/1:已激活2：已过期）
            $("#pkg_status").text("库存");
        else if (cardInfo.package_status == 1) $("#pkg_status").text("已激活").css("color","#4AC119");
        else if (cardInfo.package_status == 2) $("#pkg_status").text("已过期").css("color","#E93838");
        
        if (cardInfo.is_authname == 0) // 实名认证状态 （0：未实名 1：已实名）
            $("#realname_status").text("待审核");
        else if (cardInfo.is_authname == 1) $("#realname_status").text("已实名").css("color","#4AC119");
        else if (cardInfo.is_authname == 2) $("#realname_status").text("审核不通过").css("color","#E93838");
        else if (cardInfo.is_authname == 3) $("#realname_status").text("重新审核").css("color","#E93838");
        else if (cardInfo.is_authname == 4) $("#realname_status").text("未实名");
        
        if (cardInfo.flowserviceList) {
            var flowserviceListLen = cardInfo.flowserviceList.length;
            var flowList = $("#myFlowInfor").html();
            $("#myFlowInfor").empty();
            for (var i = 0; i < flowserviceListLen; i++) {
                var record = flowList;
                var obj = cardInfo.flowserviceList[i];
                var remainflow = cardInfo.flowserviceList[i].remainflow;
                $("#myFlowInfor").append(record);
                record = $("#myFlowInfor").find(".box-flow-info:last");
                record.attr("id", "info" + i);
                record.find(".box-title").text(obj.package_name);
                record.find(".text-primary").text(remainflow + "M");
                
                var percent = (obj.usedflow / obj.totalflow) * 100;
                var fPercent = parseInt(percent);
                /*if (fPercent == 0) {
                    fPercent = 0.5;
                }*/
                if(isNaN(fPercent)){
                	fPercent = 0;
                }
                
                var leftP = fPercent;
                if (fPercent < 5) {
                    leftP = 1;
                }
                
                if(obj.is_unlimit_flow==0){
                	record.find("span[name='totalflow']").after("总流量：" + (obj.totalflow-0)+ "M");
                	record.find(".percent").text(fPercent + "%");
                    record.find(".percent").attr("style", "left: " + leftP + "%;");
                    record.find(".js_progress").attr("style", "width: " + fPercent + "%;");
                }else{
                	record.find(".text-primary").text("");
                	record.find("span[name='totalflow']").text("不限流量");
                }
                
                record.find("div[name='endtime']").text("有效期至：" + obj.endtime.replace(/-/g, "/"));
                
                
            }
            $('.box-flow-info').show();
        }

    } else {
        $("#myFlowInfor").html('<div class="box-flow-info">没查询到流量信息!</div>');
    }
    
    var dailyData = new Array();
	var monthData = new Array();
	// 查询日走视数据
	$.ajax({
		type : "post",
		url : baseUrl + "api/flowUsedChart",
		success : function(data) {
			if (data.dailyData != null) {
				for (var i = 0; i < data.dailyData.length; i++) {
					var obj = data.dailyData[i];
					dailyData[i] = new Array();
					dailyData[i][0] = obj.datetime;
					dailyData[i][1] = obj.usedflow;
				}
			}
			
			if (data.monthData != null) {
				for (var i = 0; i < data.monthData.length; i++) {
					var obj = data.monthData[i];
					monthData[i] = new Array();
					monthData[i][0] = obj.datetime;
					monthData[i][1] = obj.usedflow;
				}
			}

			buildChart(dailyData, monthData);
		}
	});
});

function flowRecords() {
    // location.href =baseUrl + "html/queryFlow/purchasingRecords.html";
    location.href = baseUrl + "html/queryFlow/purchaseHistoryRecord.html";
}

function gotoBuyFlow() {
    window.location.href = baseUrl + "html/flowCharge/selectFlowType.html";
}