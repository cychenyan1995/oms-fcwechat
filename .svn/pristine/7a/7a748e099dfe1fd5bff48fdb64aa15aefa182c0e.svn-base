$(document).ready(function() {
	$.ajax({
		type:"post",
		url:baseUrl+"api/flowRecords?isapply=2",
		success:function(data){
			if(data.list!=null){
				for(var i=0;i<data.list.length;i++)
				{			
					var obj = data.list[i];
						var pkType = '其他';
						var flowTile = '';
						
						
						//流量细则 如：总流量／有效期	
						if(obj.total_flow.indexOf(".00")>0){
							obj.total_flow = obj.total_flow.split(".")[0];
						}
						
						 // 流量细则 如：总流量／有效期
	                    if (obj.per_cycle_flow.indexOf(".00") > 0) {
	                    	obj.per_cycle_flow = obj.per_cycle_flow.split(".")[0];
	                    }
						
						
						//有效期周期单位 （0：天 /1：月 2:年）
						var valid_cycle_unit;
						if(0 == obj.valid_cycle_unit){
							valid_cycle_unit = '天';
						}
						if(1 == obj.valid_cycle_unit){
							valid_cycle_unit = '月';
						}
						if(2 == obj.valid_cycle_unit){
							valid_cycle_unit = '年';
						}
						
						
						//1:初始套餐 2:续约套餐 3:续约流量包
						if(obj.pktype==2 && obj.flowserv_type==0){
							pkType = '累计套餐';
							if(obj.is_unlimit_flow==1){
								flowTile = "不限流量/"+obj.valid_cycle+valid_cycle_unit;
							}else{
								flowTile = obj.total_flow+obj.flow_unit+"/"+obj.valid_cycle+valid_cycle_unit;
							}
							
						}
						else if(obj.pktype==2 && obj.flowserv_type==1){
							pkType = '月付套餐';
							//flowTile = obj.total_flow+obj.flow_unit+"/"+obj.valid_cycle+valid_cycle_unit;
							flowTile = obj.per_cycle_flow + obj.flow_unit+"*" + obj.charge_cycle +"/" + obj.valid_cycle + valid_cycle_unit;
						}
						else if(obj.pktype==3 && obj.flowserv_type==0){
							pkType = '累计流量包';
							flowTile = obj.total_flow+obj.flow_unit+"/"+obj.valid_cycle+valid_cycle_unit;
						}
						
						 
						var style = "label_activing";
						//0：待生效 1：已生效
						if(obj.isapply==1){
							style = "label_actived";
						}
						
						if(obj.apply_time.indexOf("0000-00-00")>=0){
							obj.apply_time = '';
						}
						var html;
						
						html = "<div class=\"weui-form-preview\">"+

						'<div class="weui-form-preview__hd '+style+'">'+
						    '<label class="weui-form-preview__label">订单编号</label>'+
						    '<em class="weui-form-preview__value">'+obj.order_no+'</em>'+
						  '</div>'+

					        "<div class=\"weui-form-preview__bd\">"+
			                
							"<div class=\"weui-form-preview__item\">"+
					        "<label class=\"weui-form-preview__label\">套餐名称</label>"+
					        "<span class=\"weui-form-preview__value\">"+obj.pkname+
					        "</span></div>"+
					        
					        "<div class=\"weui-form-preview__item\">"+
					        "<label class=\"weui-form-preview__label\">套餐类型</label>"+
					        "<span class=\"weui-form-preview__value\">"+pkType+
					        "</span></div>"+
					        
					        "<div class=\"weui-form-preview__item\">"+
			                "<label class=\"weui-form-preview__label\">流量细则</label>"+
			                "<span class=\"weui-form-preview__value\">"+flowTile+
			                "</span></div>";
			                
							if(obj.isapply==1){
								  html = html + "<div class=\"weui-form-preview__item\">"+
							        "<label class=\"weui-form-preview__label\">开通时间</label>"+
							        "<span class=\"weui-form-preview__value\">"+obj.apply_time+
							        "</span></div>";
							}
							
							html = html + "<div class=\"weui-form-preview__item\">"+
					        "<label class=\"weui-form-preview__label\">交易时间</label>"+
					        "<span class=\"weui-form-preview__value\">"+obj.create_time+
					        "</span></div>"+
					        "</div>"+
						  '<div class="weui-form-preview__ft">'+
						  	'<label class="weui-form-preview__label">交易金额</label>'+
						  	'<span class="text-pay">'+obj.pkprice+'</span>'+
						  '</div>'+
					    "</div>";
						
						$("#record").append(html);
				}	
			}else{
				$("#record").html('<div class="box-flow-info">没查询到购买信息!</div>');
			}
			
		}
	})
});