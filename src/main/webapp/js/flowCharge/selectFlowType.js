$(document).ready(function() {
    $('#flowPkg').hide();
    $('#monthPkg').hide();
    $('#cumulativePkg').hide();
    $('#nonPkg').hide();
    var redirectUrl = "";
    
    $.ajax({
    	url: baseUrl + "api/isOpenPackage",
        success: function(data) {
        	if(null != data.redirect_url && "" != data.redirect_url){
        		redirectUrl = data.redirect_url;
        		$('#nonPkg').html("您有一个套餐未开通，<br/>请点击<a href=\"" + redirectUrl + "\">立即开通</a>");
        		$('#nonPkg').show();
        		$("#tab1").empty();
            	$("#tab2").empty();
            	$("#tab3").empty();
        	}else{
        		$.ajax({
                    url: baseUrl + "api/getFlowPkg",
                    success: function(data) {

                        // 填写数据
                        if (null != data.pkList) {

                            var htmlTemplate1 = $('#tab1').html();
                            $("#tab1").empty();

                            var htmlTemplate2 = $('#tab2').html();
                            $("#tab2").empty();

                            var htmlTemplate3 = $('#tab3').html();
                            $("#tab3").empty();

                            for (var i = 0; i < data.pkList.length; i++) {
                                var pk = data.pkList[i];
                                var flowTile;

                                // 有效期周期单位 （0：天 /1：月 2:年）
                                var valid_cycle_unit;
                                if (0 == pk.valid_cycle_unit) {
                                    valid_cycle_unit = '天';
                                }
                                if (1 == pk.valid_cycle_unit) {
                                    valid_cycle_unit = '月';
                                }
                                if (2 == pk.valid_cycle_unit) {
                                    valid_cycle_unit = '年';
                                }
                                
                                // 有效期周期单位 （0：天 /1：月 2:年）
                                var charge_mode;
                                if (0 == pk.charge_mode) {
                                    valid_cycle_unit = '天';
                                }
                                if (1 == pk.charge_mode) {
                                	charge_mode = '月';
                                }
                                if (2 == pk.charge_mode) {
                                	charge_mode = '年';
                                }

                                // 流量细则 如：总流量／有效期
                                if (pk.total_flow.indexOf(".00") > 0) {
                                    pk.total_flow = pk.total_flow.split(".")[0];
                                }
                                
                                // 流量细则 如：总流量／有效期
                                if (pk.per_cycle_flow.indexOf(".00") > 0) {
                                    pk.per_cycle_flow = pk.per_cycle_flow.split(".")[0];
                                }

                                // 累计套餐
                                if(pk.flowpkgtype==2 && pk.flowserv_type==0)
                                {
                                    $('#flowPkg').show();
                                    flowTile = pk.total_flow + pk.flow_unit + "/" + pk.valid_cycle + valid_cycle_unit;
                                    if(pk.is_unlimit_flow==1){
                                    	flowTile = "不限流量/" + pk.valid_cycle + valid_cycle_unit;
                                    }
                                    //var flowTile = pk.total_flow + pk.flow_unit;
                                    var record = htmlTemplate1;
                                    var tab = $("#tab1");
                                    tab.append(record);
                                    tab.children("div:first-child").attr("class", "weui-panel weui-panel_grid open");
                                    record = tab.find(".weui-panel_grid:last");

                                    record.find(".text-pay").text(pk.price + "元");
                                    record.find(".text-primary").text(flowTile);
                                    record.find("#packName").text(pk.flowpkgname);
                                    record.find("#flow").text(flowTile);
                                    record.find("#valid_cycle").text(pk.valid_cycle + valid_cycle_unit);

                                    var button = record.find("button");
                                    button.attr("relation_id", pk.relation_id);
                                    button.attr("flowpkgtype", pk.flowpkgtype);
                                    button.attr("pkgdesc", pk.pkgdesc);
                                    button.attr("valid_cycle", pk.valid_cycle + valid_cycle_unit);
                                    button.attr("flow_title", flowTile);
                                    button.attr("valid_des", record.find("#valid_des").text());

                                }
                                // 月付套餐
                                else if(pk.flowpkgtype==2 && pk.flowserv_type==1)
                                {
                                    $('#monthPkg').show();
                                    // 流量细则 如：月付流量*月数／有效期
                                    //flowTile = (parseFloat(pk.per_cycle_flow) * parseFloat(pk.charge_cycle)) + pk.flow_unit+"/" + pk.valid_cycle + valid_cycle_unit;
                                    flowTile = pk.per_cycle_flow + pk.flow_unit+"*" + pk.charge_cycle +"/" + pk.valid_cycle + valid_cycle_unit;
                                    if(pk.is_unlimit_flow==1){
                                    	flowTile = "不限流量/" + pk.valid_cycle + valid_cycle_unit;
                                    }
                                    
                                    var record = htmlTemplate2;
                                    var tab = $("#tab2");
                                    tab.append(record);
                                    tab.children("div:first-child").attr("class", "weui-panel weui-panel_grid open");
                                    record = tab.find(".weui-panel_grid:last");

                                    record.find(".text-pay").text(pk.price + "元");
                                    record.find(".text-primary").text(flowTile);
                                    record.find("#packName").text(pk.flowpkgname);
                                    record.find("#flow").text(flowTile);
                                    record.find("#valid_cycle").text(pk.valid_cycle + valid_cycle_unit);
                                    record.find("#flowserv_pay_date").text("每月"+pk.flowserv_pay_date+"日");
                                    if(pk.is_month_clean==1){
                                    	record.find("#is_month_clean").text("月底清零");
                                    }else{
                                    	record.find("#is_month_clean").text("月底不清零");
                                    }
                                    
                                    var button = record.find("button");
                                    button.attr("relation_id", pk.relation_id);
                                    button.attr("flowpkgtype", pk.flowpkgtype);
                                    button.attr("pkgdesc", pk.pkgdesc);
                                    button.attr("valid_cycle", pk.valid_cycle + valid_cycle_unit);
                                    button.attr("flow_title", flowTile);
                                    button.attr("valid_des", record.find("#valid_des").text());
                                    button.attr("pay_date", record.find("#flowserv_pay_date").text());
                                    button.attr("month_clean", record.find("#is_month_clean").text());

                                }
                                // 累计叠加包
                                else if(pk.flowpkgtype==3 && pk.flowserv_type==0)
                                {
                                    // 流量细则 如：总流量／有效期
                                    flowTile = pk.total_flow + pk.flow_unit + "/" + pk.valid_cycle + valid_cycle_unit;
                                    if(pk.is_unlimit_flow==1){
                                    	flowTile = "不限流量/" + pk.valid_cycle + valid_cycle_unit;
                                    }
                                    
                                    if (pk.flowserv_type == 0) {
                                        $('#cumulativePkg').show();
                                        var record = htmlTemplate3;
                                        var tab = $("#tab3");
                                        tab.append(record);
                                        tab.children("div:first-child").attr("class", "weui-panel weui-panel_grid open");
                                        record = tab.find(".weui-panel_grid:last");

                                        record.find(".text-pay").text(pk.price + "元");
                                        record.find(".text-primary").text(flowTile);
                                        record.find("#packName").text(pk.flowpkgname);
                                        record.find("#flow").text(flowTile);
                                        record.find("#valid_cycle").text(pk.valid_cycle + valid_cycle_unit);
                                        record.find("#valid_des").text('立即生效，流量叠加，'+pk.valid_cycle + valid_cycle_unit+'内有效，总使用周期不变');
                                        var button = record.find("button");
                                        button.attr("relation_id", pk.relation_id);
                                        button.attr("flowpkgtype", pk.flowpkgtype);
                                        button.attr("pkgdesc", pk.pkgdesc);
                                        button.attr("valid_cycle", pk.valid_cycle + valid_cycle_unit);
                                        button.attr("flow_title", flowTile);
                                        button.attr("valid_des", record.find("#valid_des").text());
                                    }

                                }
                                else {
                                	$("#tab1").empty();
                                	$("#tab2").empty();
                                	$("#tab3").empty();
                                	$('#nonPkg').show();
                                }
                            }
                        } else {
                        	$("#tab1").empty();
                        	$("#tab2").empty();
                        	$("#tab3").empty();
                        	$('#nonPkg').show();
                        }
                        
                        $(".weui-navbar__item").each(function(){
                    	    if($(this).is(':visible')){
                    	    	$(this).addClass("weui-bar__item--on");
                    	    	var tab = $(this).attr("href");
                    	    	$(tab).addClass("weui-tab__bd-item weui-tab__bd-item--active");
                    	    	return false;
                    	    }
                    	});
                    }
                });
        	}
        }
    });
    
    $(".weui-tab").on("click", '.weui-btn_inline',
    function() {
        $('#relation_id').val($(this).attr("relation_id"));
        $('#flowpkgtype').val($(this).attr("flowpkgtype"));
        $('#pkgdesc').val($(this).attr("pkgdesc"));
        $('#validCycle').val($(this).attr('valid_cycle'));
        $('#flowTitle').val($(this).attr('flow_title'));
        $('#validDes').val($(this).attr('valid_des'));
        $('#pay_date').val($(this).attr('pay_date'));
        $('#month_clean').val($(this).attr('month_clean'));

        if ($(this).attr("parent") == "tab1") {
            $('#flowTypeName').val('累计流量套餐');
        } else if ($(this).attr("parent") == "tab2") {
            $('#flowTypeName').val('月付流量套餐');
        } else if ($(this).attr("parent") == "tab3") {
            $('#flowTypeName').val('累计流量包');
        }

        gotoOrderInf();

    });
    
    $(".weui-tab").on("click", '.weui-panel__hd',
    		function() {
    		    var display = $(this).parent().attr("class");
    		    var dom = document.getElementsByClassName("weui-panel weui-panel_grid open");
    		    for(var i=0;i<dom.length;){
    		    	dom[i].className = "weui-panel weui-panel_grid";
    		    }
    		    if(display.indexOf("open")<0){
    		    	$(this).parent().attr("class", "weui-panel weui-panel_grid open");
    		    }
    });
});


function gotoOrderInf() {
    // 提交订单
    $.ajax({
        type: "post",
        url: baseUrl + "api/commitOrder",
        data: {
            "flowpkgtype": $('#flowpkgtype').val(),
            "relation_id": $('#relation_id').val()
        },
        success: function(data) {
        	
        	if (data.flowOrder == null) {
        		$.toast("已存在待生效的订单 !", "text");
        		return;
        	}else if (data.flowOrder != "undefined") {
                var url = baseUrl + "html/flowCharge/orderConfirmation.html?" + "price=" + data.flowOrder.price + "&flowTitle=" + encodeURI($('#flowTitle').val()) + "&flowTypeName=" + encodeURI($('#flowTypeName').val()) + "&validDes=" + encodeURI($('#validDes').val()) + "&order_no=" + data.flowOrder.orderNo + "&flowpkgname=" + encodeURI(data.flowOrder.flowName) + "&validtime=" + $('#validCycle').val() + "&is_month_clean=" + encodeURI($('#month_clean').val()) + "&flowserv_pay_date=" + encodeURI($('#pay_date').val());
                window.location.href = url;
            } else {
                $.toast('生成订单失败 !');
                return;
            }

        }

    })
}