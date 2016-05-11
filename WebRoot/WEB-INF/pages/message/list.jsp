<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>消息管理 - 后台管理界面</title>
	<meta http-equiv="pragma" message="no-cache">
	<meta http-equiv="cache-control" message="no-cache">
	<meta http-equiv="expires" message="0">    
	<meta http-equiv="keywords" message="keyword1,keyword2,keyword3">
	<meta http-equiv="description" message="This is my page">
	<%@include file="/WEB-INF/pages/common/common.jsp" %>
	<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
 </head>
 <body>
	<div class="wrap">
		<!-- left页面 -->
		<%@include file="/WEB-INF/pages/common/left.jsp" %>
		<div class="content">
			<%@include file="/WEB-INF/pages/common/header.jsp" %>
			<div class="channel"> 首页 > 消息管理</div>
			<div class="cnt">
			<style>
				h2{text-align: center;font-size:30px;color: white;}
				.container {
					margin: 0 auto;
					padding: 20px;
					background:#666;
				}
				
				.container li {
					margin-top: 18px
				}
				
				.container li label {
					font-size: 14px;
					font-weight: 700;
					color: #999
				}
				
				.container .inp,.container textarea,.container select {
					width: 100%;
					min-width: 240px;
					height: 42px;
					margin-top: 6px;
					outline:none;
					border: 1px solid #c5c5c5;
					font-family: inherit;
					text-indent: 0.5em;
					color: #333;
					border-radius: 4px;
				}
				.inp-upload{background:#ccc;padding:8px 16px;color:#fff;position:absolute;top:32px;right:2px}
				.container input[readonly]{background:#eee}
				.container textarea.inp {height: 160px;padding-top: 6px;;}
				.container input[type='submit']{color:#fff}
				.container :hover input[type='submit']{background:#333}
				.container .button{color:#fff;background:#FF7F50;border-radius:7px;}
				.container .button:hover{background:#AD593A;}
				
		
		.box{height:360px;overflow:auto;background:#28B779;margin-top:20px;border-radius:5px;}
		#userbox{color:#333;}
		#userbox li{height:25px;padding:5px;border-bottom:1px dotted #ccc;}
		#userbox li .num{display:inline-block;max-width:60px;height:25px;text-align:right;padding:0 2px;}
		#userbox li .chk{position:relative;top:2px;}
		#userbox li:hover{background:#333;color:#fff;cursor:pointer;}
		#userbox li.on{background:#333;color:#fff;}
	
				</style>
				
				
	
					<div class="container" style="width:640px;">
					<h2>消息推送</h2>
					<div class="box">
		<!--  		<a href="">全选</a> -->
		<!--  		<a href="">反选</a> -->
					<ul id="userbox"> 
						<c:forEach items="${datas}" var="user" varStatus="uindex"> 
							<li> 
								<span class="num chk"><input type="checkbox" class="check" value="${user.id}"/></span> 
								<span class="num">${uindex.count}:</span> 
								${user.username}【${user.email}】 
							</li> 
						</c:forEach> 
					</ul> 
					
					</div>
					
						<ul>
							<li><textarea  class="inp" name="description" autocomplete="off" placeholder="请输入消息的内容..."  maxlength="1000" /></textarea></li>
							<li>
								<p><input type="button" onclick="save()" class="inp button" value="推送"/></p>
							</li>
						</ul>
				</div>
				
				
			</div>
		</div>
	</div>
	<script type="text/javascript">
	
		function refresh(){ 
			$.ajax({
				type:"post",
				url:adminPath+"/message/user",
				data:{},
				success:function(data){
					var len = data.length;
	 				var html = "";
	 				for(var i=0;i<len;i++){	
	 					html+=("<li> "+
	 							"    <span class='num chk'><input type='checkbox' class='check' value='"+data[i].pushToken+"'/></span> "+
	 							"    <span class='num'>"+i+":</span> "+
	 							"    "+data[i].username+"【"+data[i].phone+"】 "+
	 							"</li>");
	 				}
	 				$("#userbox").html(html);
				}
			});
		}
		window.refresh();	
		
		function save(){		
			var textDom = $(".inp").val();
			var	idData = $("input:checkbox:checked").map(function(index,elem) {
					return $(elem).val();
				}).get().join(',');
			if(isNotEmpty(textDom)){
				clearTimeout(this.timer);
				this.timer = setTimeout(function(){
//					loading("请稍后数据执行中...");
					$.ajax({
						type:"post",
						url:adminPath+"/message/save",
						data:{"text":textDom,"userId":idData},
						success:function(data){
							loading("执行成功...",3);
						}
					});
				},200);
			}else{
				loading("请输入内容...",3);
			}	
		}
	</script>
 </body>
</html>
