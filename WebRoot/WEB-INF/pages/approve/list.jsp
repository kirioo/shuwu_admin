<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>认证管理 - 树屋后台管理界面</title>
	<meta http-equiv="pragma" approve="no-cache">
	<meta http-equiv="cache-control" approve="no-cache">
	<meta http-equiv="expires" approve="0">    
	<meta http-equiv="keywords" approve="keyword1,keyword2,keyword3">
	<meta http-equiv="description" approve="This is my page">
	<%@include file="/WEB-INF/pages/common/common.jsp" %>
	<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
	<style type="text/css">

			.show{width:600px;height:350px;border:12px solid #000;box-shadow:0px 0px 30px 2px #000;border-radius:10px;position:absolute;z-index:2;display:none;}
			
			/* filter:alpha(opacity=60)  解决IE6的兼容性问题*/
			.yy{width:100%;height:100%;background:#000;position:absolute;left:0px;top:0px;filter:alpha(opacity=60);opacity:0.6;z-index:1;display:none;}
		</style>
 </head>
 <body>
	<div class="wrap">
		<!-- left页面 -->
		<%@include file="/WEB-INF/pages/common/left.jsp" %>
		<div class="content">
			<%@include file="/WEB-INF/pages/common/header.jsp" %>
			<div class="channel"> 首页 > 认证管理</div>
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
								<th>证件审核</th>	
								<th>认证状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<!--身体部-->
						<tbody id="tbody" data-model="approve">
							<tr>
								<td id="loading" colspan="50"></td>
							</tr>
						</tbody>
						
						<div class="show">
							<img src="http://treehouse.oss-cn-shanghai.aliyuncs.com/TreeHouse/2016_04_28_06_48_14_112_img_4381907.png"  width="600" height="350" >
						</div>
					</table>
					<div class="cpage"></div>
					
					
				</div>
			</div>
		</div>
		
	
		<div class="yy"></div>
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
			
			// 获取距离浏览器左侧的距离
			var _left = ($(window).width() - 600) / 2;
			// 获取距离浏览器顶部的距离
			var _top = ($(window).height() - 350) / 2+50;

			// 点击按钮弹出层
			$(".btn").click(function(){
				alert(1111111);
				$(".show").show().addClass("animated rollIn").css({left:_left,top:_top});
				$(".yy").css("opacity","0.2").show();
			});
			
			// 点击阴影层
			$(".yy").click(function(){
				$(this).hide();
				$(".show").show().animate({
					width:"-600px",
					height:"-350px",
					left:"-"+_left+"px",
					top:"-"+_top+"px"
				},1000,function(){
					$(this).css({width:600,height:350}).hide();
				});
			});
		});
	</script>
 </body>
</html>
