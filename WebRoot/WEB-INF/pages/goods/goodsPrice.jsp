<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<title>商品详情页面</title>
<meta http-equiv="pragma" goods="no-cache">
<meta http-equiv="cache-control" goods="no-cache">
<meta http-equiv="expires" goods="0">
<meta http-equiv="keywords" goods="keyword1,keyword2,keyword3">
<meta http-equiv="description" goods="This is my page">
<%@include file="/WEB-INF/pages/common/common.jsp"%>
<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
<!-- 引用控制层插件样式 -->
<link rel="stylesheet"
	href="${basePath}/resources/zyUpload/control/css/zyUpload.css"
	type="text/css">
<script src="http://www.lanrenzhijia.com/ajaxjs/jquery.min.js"></script>
<!-- 引用核心层插件 -->
<script src="${basePath}/resources/zyUpload/core/zyFile.js"></script>
<!-- 引用控制层插件 -->
<script src="${basePath}/resources/zyUpload/control/js/zyUpload.js"></script>
<!-- 引用初始化JS -->
<script src="${basePath}/resources/zyUpload/core/lanrenzhijia.js"></script>
</head>
<body>
	<div class="wrap">
		<!-- left页面 -->
		<%@include file="/WEB-INF/pages/common/left.jsp"%>
		<div class="content">
			<%@include file="/WEB-INF/pages/common/header.jsp"%>
			<div class="channel">首页 > 商品价格管理</div>
			<div class="cnt">
				<div class="tabwrap">
					<style>
h1 {
	text-align: center;
	font-size: 28px;
	font-weight: bold;
	color: #FF7F50;
}

.container {
	margin: 0 auto;
	padding: 20px;
	background: #666;
}

.container li {
	margin-top: 18px
}

.container li label {
	font-size: 14px;
	font-weight: 700;
	color: #999
}

.container .inp, .container textarea, .container select {
	width: 100%;
	min-width: 240px;
	height: 42px;
	margin-top: 6px;
	outline: none;
	border: 1px solid #c5c5c5;
	font-family: inherit;
	text-indent: 0.5em;
	color: #333;
	border-radius: 4px;
}

.inp-upload {
	background: #ccc;
	padding: 8px 16px;
	color: #fff;
	position: absolute;
	top: 32px;
	right: 2px
}

.container input[readonly] {
	background: #eee
}

.container textarea.inp {
	height: 160px;
	padding-top: 6px;;
}

.container input[type='submit'] {
	color: #fff
}

.container :hover input[type='submit'] {
	background: #333
}

.container .button {
	color: #fff;
	background: #FF7F50;
	border-radius: 7px;
}
</style>
					<div class="container" style="width: 640px;">
						<form action="#" id="shopForm">
							<input type="hidden" id="id" name="id" value="${hotel.id}" />
							<ul>
								<h1>商品价格修改</h1>
								<li><input id="addPrice" type="button" value="添加价格" /></li>
								<table>
									<tr>
										<td>商品ID</td>
										<td>尺寸</td>
										<td>颜色</td>
										<td>价钱</td>
										<td>库存</td>
									</tr>
									<c:forEach var="goodPrice" varStatus="contentindex"
										items="${prices}">
										<tr>
											<td>${goodPrice.goodsId }</td>
											<td>${goodPrice.size }</td>
											<td>${goodPrice.color }</td>
											<td>${goodPrice.price }</td>
											<td>${goodPrice.stock }</td>
											<td class="edit" value="${goodPrice.id}">修改</td>
										</tr>
									</c:forEach>
								</table>
							</ul>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
// 			<!-- 添加商品价格-->
			$("#addPrice").click(function(){
				var sizeHTML = "<select><c:forEach var="size" varStatus="contentindex" items="${sizeList}"><option value='${size.id }'>${size.name }</option></c:forEach></select>"
				var colorHTML = "<select><c:forEach var="color" varStatus="contentindex" items="${colorList}"><option value='${color.id }'>${color.name}</option></c:forEach></select>"
				$("#shopForm").children("ul").children("table").append("<tr><td></td><td>"+sizeHTML+"</td><td>"+colorHTML+"</td><td><input type='text' onkeyup=\"this.value=/^\\d+\.?\\d{0,2}$/.test(this.value) ? this.value : ''\" /></td><td><input type='number' /></td><td class='add'>保存</td></tr>")
			})
			$("body").on("click",'.add',function(){
				var operate = $(this);
				var id = operate.attr("value");
				var stock = $(this).prev();//库存
				var price = $(this).prev().prev();//价格
				var color = $(this).prev().prev().prev();//颜色
				var size = $(this).prev().prev().prev().prev();//尺寸
				var goodsId = $(this).prev().prev().prev().prev().prev();//ID
				$.ajax({
					url:adminPath+'/goods/addGoodPrice',
					data:{'stock':stock.children("input").val(),
						'price':price.children("input").val(),
						'color':color.children("select").val(),
						'size':size.children("select").val()},
					type:'post',
					dataType: 'json',
					success:function(data){
						window.location.reload();
					}
				})
			})
// 			<!-- 修改商品价格 -->
			$("body").on("click",".edit",function() {
				if($(this).text() == "修改"){
					var operate = $(this);
					var id = operate.attr("value");
					var stock = $(this).prev();//库存
					var price = $(this).prev().prev();//价格
					var color = $(this).prev().prev().prev();//颜色
					var size = $(this).prev().prev().prev().prev();//尺寸
					var goodsId = $(this).prev().prev().prev().prev().prev();//ID
					var sizeHTML = "<select><c:forEach var="size" varStatus="contentindex" items="${sizeList}"><option value='${size.id }'>${size.name }</option></c:forEach></select>"
					var colorHTML = "<select><c:forEach var="color" varStatus="contentindex" items="${colorList}"><option value='${color.id }'>${color.name}</option></c:forEach></select>"
					size.html(sizeHTML);
					color.html(colorHTML);
					price.html("<input value='"+price.text()+"' type='text' onkeyup=\"this.value=/^\\d+\.?\\d{0,2}$/.test(this.value) ? this.value : ''\" />")
					stock.html("<input type='number' value='"+stock.text()+"' />");
					operate.text("提交");
				}else{
					var operate = $(this);
					var id = operate.attr("value");
					var stock = $(this).prev();//库存
					var price = $(this).prev().prev();//价格
					var color = $(this).prev().prev().prev();//颜色
					var size = $(this).prev().prev().prev().prev();//尺寸
					var goodsId = $(this).prev().prev().prev().prev().prev();//ID
					$.ajax({
						url:adminPath+'/goods/updateGoodPrice',
						data:{'stock':stock.children("input").val(),
							'id':id,
							'price':price.children("input").val(),
							'color':color.children("select").val(),
							'size':size.children("select").val()},
						type:'post',
						success:function(data){
							size.html(size.children("select").children(":selected").text());
							color.html(color.children("select").children(":selected").text());
							price.html(price.children("input").val());
							stock.html(stock.children("input").val());
							operate.text("修改");
						}
					})
				}
			});
		})
	</script>
</body>
</html>
