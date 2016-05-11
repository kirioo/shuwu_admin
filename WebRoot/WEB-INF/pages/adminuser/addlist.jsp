<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>密码修改 - 树屋后台管理系统</title>
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
			<div class="channel"> 首页 > 密码修改</div>
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
							<h1>管理员密码修改</h1>
							<li>
								<p><label for="">登录邮箱：
									<input type="text" class="inp" value="" id="email" name="email" autocomplete="off" name="name" autocomplete="off" placeholder="请输入邮箱..."  maxlength="100" autofocus="autofocus" />
								</label></p>
							</li>
							<li>
								<p><label for="">登录密码：
									<input type="password" class="inp" id="pw1"  value="" name="password" autocomplete="off" name="name" autocomplete="off" placeholder="请输入密码..."  maxlength="16" autofocus="autofocus" />
								</label></p>
							</li>
							<li>
								<p><label for="">确认登录密码：
									<input type="password" class="inp" id="pw2" value="" name="eque" autocomplete="off" name="name" autocomplete="off" placeholder="请再次输入密码..."  maxlength="16" autofocus="autofocus" />
								</label></p>
							</li>						
							<li>		
								<p><input type="button" onclick="tzShop.save(this)" class="inp button" value="保存"/></p>
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
					var email = $("#email").val();
					if(isEmpty(email)){
						loading("请输入邮箱!",3);
						$("#email").focus();
						return;
					};
					var password = $("#pw1").val();
					if(isEmpty(password)){
						loading("请输入密码!",3);
						$("#pw1").focus();
						return;
					};			
					var pw1 = $("#pw1").val();
					var pw2 = $("#pw2").val();
					if(pw1 != pw2){
						loading("密码不一致请重新输入!",3);
						$("#pw1").select();
					}else{
						var params = $("#shopForm").serialize();
						var url = basePath+"/admin/adminuser/updatePassword";
						$.ajax({
							type:"post",
							url:url,
							data:params,
							success:function(data){
								if(data=="success"){
									loading("修改成功....",3);
								//	window.location.href =window.location.href;
		 							window.location.href =basePath+"/login";			
								}else{
									loading("修改失败....",3);
								}
							}
						});
					}	
				}
				
			};
	</script>
 </body>
</html>
