<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>活动添加</title>
	<meta http-equiv="pragma" goods="no-cache">
	<meta http-equiv="cache-control" goods="no-cache">
	<meta http-equiv="expires" goods="0">    
	<meta http-equiv="keywords" goods="keyword1,keyword2,keyword3">
	<meta http-equiv="description" goods="This is my page">
	<%@include file="/WEB-INF/pages/common/common.jsp" %>
	<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
	
 </head>
 <body>
	<div class="wrap">
		<!-- left页面 -->
		<%@include file="/WEB-INF/pages/common/left.jsp" %>
		<div class="content">
			<%@include file="/WEB-INF/pages/common/header.jsp" %>
			<div class="channel"> 首页 > 活动管理</div>
			<div class="cnt">
				<div class="tabwrap">
				<style>
				h1{text-align:center;font-size:28px;font-weight:bold;color:#FF7F50;}
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
				</style>
					<div class="container" style="width:640px;">
					<form action="#" id="shopForm">
						<ul>
							<h1>活动添加</h1>
							<li>
								<p><label for="">活动标题：<input type="text" id="name" class="inp" value=""  autocomplete="off" name="name" autocomplete="off" placeholder="请输入活动的名称..."  maxlength="100" autofocus="autofocus" /></label></p>
							</li>
							<li>
								<p><label for="">活动描述：<textarea  class="inp" id="description" name="description" autocomplete="off" placeholder="请输入活动的内容..."  maxlength="1000" /></textarea></label></p>
							</li>
														
							<h4>封面图上传：</h4>
							<input type="hidden" value="${hotel.name}" name="cover"/>
							<div id="ossfile">你的浏览器不支持flash,Silverlight或者HTML5！</div>
							
							<br/>
							
							
							<div id="container">
								<a id="selectfiles" href="javascript:void(0);" class='btn'>选择文件</a>
								<a id="postfiles" href="javascript:void(0);" class='btn'>开始上传</a>
							</div>
							
							<pre id="console"></pre>
							
							<script type="text/javascript" src="${basePath}/plupload-2.1.2/js/plupload.full.min.js"></script>
							<script type="text/javascript" src="${basePath}/upload.js"></script>
							
							
							<li>		
								<p><input type="button" onclick="tzShop.save(this)" class="inp button" value="发布"/></p>
							</li>
						</ul>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		
		var tzShop = {
				save:function(){
					var name = $("#name").val();
					if(isEmpty(name)){
						loading("请输入昵称!",3);
						$("#name").focus();
						return;
					};
					var description = $("#description").val();
					if(isEmpty(description)){
						loading("请输入活动内容!",3);
						$("#description").focus();
						return;
					};
					var params = $("#shopForm").serialize();
					var url = basePath+"/admin/event/sava";
						$.ajax({
							type:"post",
							url:url,
							data:params,
							success:function(data){
								if(data=="success"){
									loading("添加成功....",3);
									window.location.href =window.location.href;
	//	 							window.location.href =basePath+"/admin/dianpu.jsp";			
								}else{
									loading("添加失败....",3);
								}
							}
						});
					}	
			
				
			};
		
		

			
		
			
	</script>
 </body>
</html>
