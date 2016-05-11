$(function(){
	$(".tmui-tips").tmTip();
});

function loading2(target,mark){
	$.loading({target:$(target),mark:1}); 
};

var tzAdmin = {
	timer :null,
	ltimer :null,
	initPage:function(itemCount){
		$(".cpage").tzPage(itemCount, {
			num_edge_entries : 1, //边缘页数
			num_display_entries :4, //主体页数
			num_edge_entries:5,
			current_page:0,
			showGo:true,
			showSelect:true,
			items_per_page : 10, //每页显示X项
			prev_text : "前一页",
			next_text : "后一页",
			callback : function(pageNo,psize){//回调函数
				tzAdmin.loadData(pageNo,psize);
			}
		});
	},
	loadData:function(pageNo,pageSize,callback){
		var keyword = $("#keywords").val();
		var model = $("#tbody").data("model");
		var $this = this;
		clearTimeout(this.ltimer);
		this.ltimer = setTimeout(function(){
			$.ajax({
				type:"post",
				beforeSend:function(){loading2($("#tbody"),4);},
				url:adminPath+"/"+model+"/template",
				data:{pageNo:pageNo*pageSize,pageSize:pageSize,keyword:keyword},
				success:function(data){
					var $data = $(data);
					$("#tbody").html($data);//追加元素到dom中
					$(".tmui-tips").tmTip();
					var itemCount = $data.find("#itemCount").val();
					if(isNotEmpty(keyword))$this.highligter(keyword);
					if(callback)callback(itemCount);
				}
			});
		},300);
	},
	highligter:function(key){
		if(isEmpty(key))return;
		$("#tbody").find(".keys").each(function(){
			var text = $(this).text();
			//var nt = text.replace(key,"<span class='red'>"+key+"</span>");
			//var nt = text.replace(key,"<span class='red'>"+key+"</span>");
			var regex = new RegExp(key,"ig");
			var nt = text.replace(regex,"<span class='red'>"+key+"</span>");
			$(this).html(nt);
		});
	},
	search:function(){
//		var keyword = $("#keywords").val();
//			if(isEmpty(keyword)){
//				loading("请输入关键字...",3);
//				$("#keywords").focus();
//				return;
//			}
		tzAdmin.loadData(0,10,function(itemCount){
			tzAdmin.initPage(itemCount);//分页加载一次吗
		});
	},
	op:function(obj){
		var $this = $(obj);
		var opid = $this.attr("opid");
		var mark = $this.attr("mark");
		var val = $this.attr("val");
		var model = $("#tbody").data("model");
		var params = {};
		params[mark] = val;
		params["id"] = opid;
		//alert(JSON.stringify(params));
		clearTimeout(this.timer);
		this.timer = setTimeout(function(){
			loading("请稍后数据执行中...");
			$.ajax({
				type:"post",
				url:adminPath+"/"+model+"/update",
				data:params,
				success:function(data){
					loading("执行成功...",3);
					if(data=="success"){
						$this.attr({opid:opid,val:val==0?1:0}).removeClass().addClass(val==0?"red":"green").text(val==0?"否":"是");
					}
				}
			});
		},200); 
	},
	child:function(obj){
		var $this = $(obj);
		var opid = $this.attr("opid");
		var mark = $this.attr("mark");
		var val = $this.attr("val");
		var model = $("#tbody").data("model");
		var params = {};
		params[mark] = val;
		params["id"] = opid;
	//	alert(JSON.stringify(params));
		clearTimeout(this.timer);
		this.timer = setTimeout(function(){
			loading("请稍后数据执行中...");
			$.ajax({
				type:"post",
				url:adminPath+"/"+model+"/child",
				data:params,
				success:function(data){
					loading("执行成功...",3);
					var len = data.length;
	 				var html = "";
	 				for(var i=0;i<len;i++){
	 					html+="<tr>"+
	 					"	<td>"+data[i].userName+"</td>"+
	 					"	<td>"+data[i].phone+"</td>"+
	 					"	<td>"+data[i].male+"</td>"+
	 					"	<td>"+data[i].age+"</td>"+
	 					"	<td>"+data[i].createTime+"</td>"+
	 					"</tr>";
	 				}
	 				$("#tbody1").html(html);
				}
			});
		},200); 
	},
	remove:function(obj){
		$.tzConfirm({title:"友情提示",content:"您确定此操作吗?",callback:function(ok){
			if(ok){
				var $this = $(obj);
				var opid = $this.data("opid");
				var model = $("#tbody").data("model");
				clearTimeout(this.timer);
				var params = {};
				params["id"] = opid;
			//	alert(JSON.stringify(params));
				this.timer = setTimeout(function(){
					loading("请稍后数据执行中...");
					$.ajax({
						type:"post",
						url:adminPath+"/"+model+"/delete",
						data:params,
						success:function(data){
							loading("执行成功...",3);
							$this.parents("tr").remove();
							var len = $("#tbody").find("tr").length;
							if(len==0){
								//window.location.href =window.location.href;
								tzAdmin.loadData(0,10,function(itemCount){
									tzAdmin.initPage(itemCount);//分页加载一次吗
								});
							}
						}
					});
				},200); 
			}
		}});
	}
};

//自己封装 的ajax
var tzAjax = {
	request: function(options,params){
		//继承参数
		var opts = $.extend({},{
			path:"",
			type:"post",
			model:"",
			method:"",
			params:"",
			before:function(){loading("请稍后数据执行中...");},
			success:function(){},
			error:function(){loading("remove");},
			logout:function(){}
		},options);
		//url拼接
		if(!opts.url){
			opts.url = opts.path+"/"+opts.model+"/"+opts.method+(opts.params?"?"+opts.params:"");
		}
		
		$.ajax({
			type:opts.type,
			url:opts.url,
			beforeSend:opts.before,
			error:opts.error,
			data:params,
			success:function(data){
				loading("remove");
				if(data=="logout"){
					if(opts.logout)opts.logout();
					//第一种方案：登陆弹出框
					alert("登陆弹出框在此弹出");
					//第二种方案：直接跳转
					window.location.href = opts.path+"/login";
				}else{
					if(opts.success)opts.success(data);
				}
			}
		});
	}	
};