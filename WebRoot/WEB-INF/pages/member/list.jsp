<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>用户会员管理 - 树屋后台管理界面</title>
	<meta http-equiv="pragma" member="no-cache">
	<meta http-equiv="cache-control" member="no-cache">
	<meta http-equiv="expires" member="0">    
	<meta http-equiv="keywords" member="keyword1,keyword2,keyword3">
	<meta http-equiv="description" member="This is my page">
	<%@include file="/WEB-INF/pages/common/common.jsp" %>
	<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
 </head>
 <body>
	<div class="wrap">
		<!-- left页面 -->
		<%@include file="/WEB-INF/pages/common/left.jsp" %>
		<div class="content">
			<%@include file="/WEB-INF/pages/common/header.jsp" %>
			<div class="channel"> 首页 > 用户会员管理</div>
			<div class="cnt">
				<div class="tabwrap">
					<!--表格-->
					<table class="tztab">
						<caption>
							<div class="fr sbtn">
								<input type="text" id="keywords" class="fl" placeholder="搜索的关键字..."/><a href="javascript:void(0);" onclick="tzAdmin.search(this);" class="fl"><i class="fa fa-search "></i></a>
							</div>
						</caption>
						<thead>
							<tr>
								<th>主键</th>
								<th>昵称 <span class="up"></span> <span class="down"></span></th>	
								<th>年龄</th>	
								<th>性别</th>		
								<th>电话</th>
								<th>当前状态</th>
								<th>国家</th>	
								<th>大学</th>		
								<th>当前城市</th>		
								<th>创建时间</th>
								<th>禁止状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<!--身体部-->
						<tbody id="tbody" data-model="member">
							<tr>
								<td id="loading" colspan="50"></td>
							</tr>
						</tbody>
					</table>
					<div class="cpage"></div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	
		$(function(){
			tzAdmin.loadData(0,10,function(itemCount){
				tzAdmin.initPage(itemCount);//分页加载一次吗
			});
			
			$(".nav").find("li.items").find("a").click(function(){
				var len = $(this).next().length;
				if(len>0){
					$(this).next().stop(true,true).slideToggle()
					.end().parents("li")
					.addClass("active")
					.siblings().removeClass("active")
					.find("ul").slideUp("slow");
				}
			});
		});
	</script>
 </body>
</html>
