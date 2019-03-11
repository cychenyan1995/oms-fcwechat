
$(document).ready(function (){
	$.ajax({
		type:"post",
		url:baseUrl+"api/flowRecords",
		success:function(data){
			if(data.flowRecordsList!=null){
				for(var i=0;i<data.flowRecordsList.length;i++)
				{			
					$("#flowRecord").append("<div class=\"weui-form-preview\">"+
								        "<div class=\"weui-form-preview__bd\">"+
										"<div class=\"weui-form-preview__item\">"+
								        "<label class=\"weui-form-preview__label\">套餐名称</label>"+
								        "<span class=\"weui-form-preview__value\">"+data.flowRecordsList[i].pkname+
								        "</span></div>"+
								        "<div class=\"weui-form-preview__item\">"+
						                "<label class=\"weui-form-preview__label\">购买价格</label>"+
						                "<span class=\"weui-form-preview__value\">"+data.flowRecordsList[i].pkprice+
						                " 元</span></div>"+
						                "<div class=\"weui-form-preview__item\">"+
								        "<label class=\"weui-form-preview__label\">交易时间</label>"+
								        "<span class=\"weui-form-preview__value\">"+data.flowRecordsList[i].create_time+
								        "</span></div>"+
								        "<div class=\"weui-form-preview__item\">"+
						                "<label class=\"weui-form-preview__label\">订单编号</label>"+
						                "<span class=\"weui-form-preview__value\">"+data.flowRecordsList[i].order_no+
						                "</span></div></div></div>"
								        );
				}	
			}else{
				$("#flowRecord").html('<div class="box-flow-info">没查询到购买信息!</div>');
			}
			
		}
	})
});

//将时间戳转化为正常时间
function add0(m){return m<10?'0'+m:m }
function format(tm)
{
//tm是整数，否则要parseInt转换
var time = new Date(parseInt(tm)*1000);
var y = time.getFullYear();
var m = time.getMonth()+1;
var d = time.getDate();
var h = time.getHours();
var mm = time.getMinutes();
var s = time.getSeconds();
return y+'-'+add0(m)+'-'+add0(d)+' '+add0(h)+':'+add0(mm)+':'+add0(s);
}

function gotoSelectFlow(){
	window.location.href=baseUrl+"html/flowCharge/selectFlowType.html";
}
