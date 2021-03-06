<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>首页- 后台管理界面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<%@include file="/WEB-INF/pages/common/common.jsp" %>
	<style>

		.numicon{color:#fff;padding:1px 8px;font-weight:700}
		.c1{background:green;}
		.c2{background:red;}
		.c3{background:pink;}
		.c4{background:orange;}
		.c5{background:#111;}
		.c6{background:gray;}	
		/*css代码*/
		.wrap{color:#939da8}
		/*侧边栏*/
		.wrap .slider{width:220px;background:#2E363F;position:fixed;top:0px;left:0;height:100%;}
		.wrap .slider .logo{height:72px;background:#1F262D;line-height:72px;text-align:center;}
		
		.wrap .nav li.items{
			
			border-top: 1px solid #37414b;
			border-bottom: 1px solid #1f262d;
			font-size:12px;
			position:relative;
		}
		.wrap .nav li.items a{padding:8px 110px 8px 21px;display:inline-block;}
		/*silder bar li的样式*/
		.wrap .nav li.items:hover,.wrap .nav li.active{background:#27A9E3}
		.wrap .nav li.items:hover a,.wrap .nav li.active a{color:#fff;}
		.wrap .nav li.items .numicon{float:right;position:absolute;top:8px;right:20px;}
		.wrap .nav li.active:after{
			content:"";
			display:inline-block;
			border-top:8px solid transparent;
			border-right:8px solid #eee;
			border-bottom:8px solid transparent;
			border-left:8px solid transparent;
			float:right;
			position:absolute;
			top:16px;
			right:0px;
		}
		.wrap .nav li .fa{padding-right:10px;font-size:14px;}
		/*silder bar li的样式 里子元素的样式*/
		.wrap .nav li.items ul {background:#111;display:none;}
		.wrap .nav li.items ul li{padding-left:10px;}
		.wrap .content .header{height:36px;background:#1F262D;border-left:1px solid #000}
		/*内容区域*/
		.wrap .content{background:#f8f8f8;margin-left:220px}
		input[placeholder]{color:#e5e5e5;font-size:12px;padding-left:5px;}
		.wrap	.content .header .titems{float:left;border-right:1px solid #999;padding:0px 10px;height:36px;line-height:36px;font-size:12px;}
		.wrap	.content .header .titems a{color:#eaeaea}
		.wrap	.content .header .titems .fa{padding-right:10px;color:#fff}
		.wrap	.content .sbtn{margin-right:20px;}	
		.wrap	.content .sbtn input{height:26px;margin-top:5px;border:0;background:#666}
		.wrap	.content .sbtn a{height:26px;width:46px;display:inline-block;background:#28B779;color:#fff;margin-top:5px;text-align:center;
				font-size:16px;}
		
		.wrap .content .channel{height:36px;line-height:36px;padding-left:10px;}
		.wrap .content .cnt{background:#EEEEEE;}
		.tabwrap{padding:5px;}
		.tztab{width:100%;border-collapse:collapse;border:1px solid #ccc;}
		.tztab th,td{border-bottom:1px solid #fff;text-align:left;padding:4px 6px;font-size:12px;}
		.tztab th{padding:10px;}
		.tztab thead th{background:#2E363F;color:#f9f9f9}
		
		/*单双行渐变*/
		.tztab tbody tr:nth-child(odd){background:#eaeaea}
		.tztab tbody tr:nth-child(even){background:#f8f8f8}
		/*hover改变行的样式*/
		.tztab tbody tr:hover{background:#333;color:#fff}
		.tztab tbody tr:hover a{color:#fff}
		.tztab tbody tr:hover td:hover{background:#28B779}

		.tztab caption{background:#2E363F;color:#fff;padding:5px;font-size:18px;font-weight:700;
			caption-side:top;
			text-align:center;
		}

		.up{
			display:inline-block;
			overflow:hidden;
			border-top:4px solid transparent;
			border-right:4px solid transparent;
			border-bottom:4px solid #fff;
			border-left:4px solid transparent;
		}
		.down{
			display:inline-block;
			overflow:hidden;
			position:relative;
			top:4px;
			border-top:4px solid #fff;
			border-right:4px solid transparent;
			border-bottom:4px solid transparent;
			border-left:4px solid transparent;
		}	
		.bg{background:url("${basePath}/resources/images/bgg.jpg");
				background-size: cover;
				width: 83%;
				height: 88%;
				position: fixed;
				top:72px;
				left:220px;
 				z-index :-10;
			}
		.bg .title{width:100%;height:100%;margin-top: 135px;margin-left: 48px;}
  </style>
 </head>
 <body>
	<div class="wrap">
		<%@include file="/WEB-INF/pages/common/left.jsp" %>
		<div class="content">
			<%@include file="/WEB-INF/pages/common/header.jsp" %>
			<div class="channel"> 后台管理 &gt; 首页</div>
			<div class="cnt">			
				<div class="bgbox">	
 					<div  class="bg"/>
						<div class="title"></div>
 					</div>
 				</div>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		$(function(){
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
			
			//标题颜色
			function dawn(){			
				$(".title").append("<marquee direction ='left' scrollamount='5' style ='height:30px;width:1000px;text-aglin'><font face='楷体'size='6' color='"+randColor()+"'>欢迎【${session_user.username}】，身份：【${session_user_role.name}】来到树屋后台管理系统</font ></marquee>");
				//随机颜色
				function randColor(){
					var r = Math.floor(Math.random() *256);
					var g = Math.floor(Math.random() *256);
					var b = Math.floor(Math.random() *256);
					return "rgb("+r+","+g+","+b+")";
				}
			}	
			dawn();
		});
	</script>
 </body>
</html>