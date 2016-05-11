<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>商品页面</title>
	<meta http-equiv="pragma" goods="no-cache">
	<meta http-equiv="cache-control" goods="no-cache">
	<meta http-equiv="expires" goods="0">    
	<meta http-equiv="keywords" goods="keyword1,keyword2,keyword3">
	<meta http-equiv="description" goods="This is my page">
	<%@include file="/WEB-INF/pages/common/common.jsp" %>
	<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
 	<!-- 引用控制层插件样式 -->
	<link rel="stylesheet" href="${basePath}/resources/zyUpload/control/css/zyUpload.css" type="text/css">
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
		<%@include file="/WEB-INF/pages/common/left.jsp" %>
		<div class="content">
			<%@include file="/WEB-INF/pages/common/header.jsp" %>
			<div class="channel"> 首页 > 商品管理</div>
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
				
				</style>
					<div class="container" style="width:640px;">
					<form action="#" id="shopForm">
						<input type="hidden" id="id" name="id" value="${hotel.id}"/>
						<ul>
							<h1>商品添加</h1>
							<li>
								<p><label for="">商品名称：<input type="text" class="inp" value="${hotel.name}" name="name" autocomplete="off" name="name" autocomplete="off" placeholder="请输入店铺的名称..."  maxlength="100" autofocus="autofocus" /></label></p>
							</li>
							<!-- <li>
								<p><label for=""><div id="demo" class="demo"></label></div></p>
							</li> -->

							<h4>封面及轮播图上传(第1张为封面，其余3张为轮播图)：</h4>
							<input type="hidden" value="${hotel.name}" name="cover"/>
							<input type="hidden" value="${hotel.name}" name="carousel1" />
							<input type="hidden" value="${hotel.name}" name="carousel2" />
							<input type="hidden" value="${hotel.name}" name="carousel3" />
							<div id="ossfile">你的浏览器不支持flash,Silverlight或者HTML5！</div>
							
							<br/>
							
							
							<div id="container">
								<a id="selectfiles" href="javascript:void(0);" class='btn'>选择文件</a>
								<a id="postfiles" href="javascript:void(0);" class='btn'>开始上传</a>
							</div>
							
							<pre id="console"></pre>
							
							<script type="text/javascript" src="/malimao_admin/plupload-2.1.2/js/plupload.full.min.js"></script>
							<script type="text/javascript" src="/malimao_admin/upload.js"></script>
							







							<li>
								<p><label for="">商品类型：
									<select name="level">
										<option >---请选择商品类型---</option>							
										<option value="1">婚纱摄影</option>
										<option value="2">蜜月旅游</option>
										<option value="3">珠宝首饰</option>
									</select>
								</label></p>
							</li>		
							<li>
								<p><label for="">商品风格：
									<select name="style">
										<option >---请选择商品风格【选填项】(婚摄摄影必填)---</option>							
										<option value="1">欧式</option>
										<option value="2">韩式</option>
										<option value="3">中式</option>
										<option value="4">个性</option>
									</select>
								</label></p>
							</li>
							<li>
								<p><label for="">婚纱摄影类型备注：<input type="text" class="inp" name="descript" autocomplete="off" value="${hotel.address}" placeholder="请输入婚纱摄影类型描述（选填，婚摄摄影必填）"  maxlength="200" /></label></p>
							</li>
							<li><p><label for="">始发点：<input type="text" class="inp" value="${hotel.name}" name="startAddress" autocomplete="off" name="name" autocomplete="off" placeholder="请输入出发点（蜜月旅游必填-例如北京市东城区）【选填项】"  maxlength="200" autofocus="autofocus" /></label></p></li>
							<li><p><label for="">终点：<input type="text" class="inp" value="${hotel.name}" name="endAddress" autocomplete="off" name="name" autocomplete="off" placeholder="请输入终点（蜜月旅游必填-例如浙江省杭州区）【选填项】"  maxlength="200" autofocus="autofocus" /></label></p></li>
							<li>
								<p><label for="">原价：<input type="text" class="inp" name="oldprice" autocomplete="off" value="${hotel.address}" placeholder="请输入商品价格（例如999.99）" onkeyup="value=value.replace(/[^\-?\d.]/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')"   maxlength="200" /></label></p>
							</li>
							<li>
								<p><label for="">折扣价：<input type="text" class="inp" name="newprice" autocomplete="off" value="${hotel.address}" placeholder="请输入商品折扣价格（例如799.99）" onkeyup="value=value.replace(/[^\-?\d.]/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')"   maxlength="200" /></label></p>
							</li>
							<li>
								<p><label for="">快递费用：<input type="text" class="inp" name="runprice" autocomplete="off" value="${hotel.address}" placeholder="请输入商品快递费（例如15.00）【蜜月旅行不填】" onkeyup="value=value.replace(/[^\-?\d.]/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')"   maxlength="200" /></label></p>
							</li>
							<li>
								<p><label for="">商品计数单位：<input type="text" class="inp" name="unit" autocomplete="off" value="${hotel.address}" placeholder="请输入商品计数单位（例如件/双）【蜜月旅行不填】"   maxlength="200" /></label></p>
							</li>
							<li>
								<p><label for="">商铺地址：<input type="text" class="inp" name="address" autocomplete="off" value="${hotel.address}" placeholder="请输入店铺的详细地址.."  maxlength="200" /></label></p>
							</li>
							<li>
								<p><label for="">联系方式：<input type="text" class="inp" name="telephone" value="${hotel.telephone}" autocomplete="off" placeholder="请输入店铺的电话号码..." onkeyup="value=value.replace(/[^\-?\d.]/g,'')"  maxlength="13" /></label></p>
							</li>
							
							<li>
								<p>
									<label for="">发布状态：
										<label><input type="radio" ${hotel.status==1?'checked="checked"':""}  name="status" value="1"/>发布</label>&nbsp;&nbsp;&nbsp;&nbsp;
										<label><input type="radio" ${hotel.status==0?'checked="checked"':""} name="status" value="2"/>未发布</label>
									</label>
								</p>
							</li>
							<li>
								<p><input type="button" onclick="tzShop.save(this)" class="inp button" value="保存"/></p>
							</li>
						</ul>
					</form>
				</div>
					
					
					<!-- 	
	刚才整理了一下，商品表里所有商品共有的属性有这些：
id	cover	shopkeeper_id	title	original_price	discounted_price	unit	state	goods_type	isRecommend		max_price	min_price	create_time	edit_time	carousel1	carousel2	carousel3

孙晓龙 2016/3/15 17:24:47
蜜月旅游特有的属性是start_position	end_position

孙晓龙 2016/3/15 17:25:16
婚摄摄影特有的属性是style	photography_type

孙晓龙 2016/3/15 17:25:43
珠宝首饰和婚纱摄影共有的属性是express_price -->
					
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		
		var tzShop = {
				save:function(){
					var params = $("#shopForm").serialize();
					var url = basePath+"/admin/goods/saveGoods";
				//	var id = $("#id").val();
				//	if(id)url = basePath+"/goodsSave";
					$.ajax({
						type:"post",
						url:url,
						data:params,
						success:function(data){
							if(data=="success"){
								alert("添加成功。。。")
								window.location.href =window.location.href;
//	 							window.location.href =basePath+"/admin/dianpu.jsp";			
							}else{
								alert("添加失败....");
							}
						}
					});
				}
				
			};
			
			
			tzShop.slider();
			tzShop.initMap();
			
			
			
			/*点击按钮的时候--伪装文件上传*/
			function openBrowse(obj){ 
				//判断浏览器的兼容性问题
				var ie=navigator.appName=="Microsoft Internet Explorer" ? true : false; 
				if(ie){ //如果是ie浏览器
					document.getElementById("file").click(); 
					document.getElementById("filename").value=document.getElementById("file").value;
				}else{
					var a=document.createEvent("MouseEvents");//FF的处理 
					a.initEvent("click", true, true);  
					document.getElementById("file").dispatchEvent(a); 
				} 
			} 
			
			function uploadFile() {
				//获取文件上传的js列表对象
			    var fileObj = document.getElementById("file").files[0]; // js 获取文件对象
//	 		    alert(fileObj.type);
//	 		    alert(fileObj.name);
//	 		    alert(fileObj.size);
			    //创建一个FormData 对象
			    var form = new FormData();
			    //设置文件上传的文件对象
			    form.append("doc", fileObj);                           
			    // 创建一个ajax对象
			    var xhr = new XMLHttpRequest();
			    //开始和后台的upload.jsp页面进行交换
			    xhr.open("post", basePath+"/upload", true);
			    //上传成功进入的毁掉函数
			    xhr.onreadystatechange = function(){
					if(xhr.readyState==4 && xhr.status==200){//状态4和200代表和服务器端交互成功
						//获取上传成功的返回数据
						var data = xhr.responseText.trim();
						if(data){
							var jsonArr = JSON.parse(data);
							var json =jsonArr[0];
							$("#preview").attr("src",basePath+"/"+json.url);
							$("#img").val(json.url);
						}
						
					}
				};
				//监听文件上传的进度
			    //xhr.upload.addEventListener("progress", progressFunction, false);
				//发送文件上传的进度
			    xhr.send(form);
			};
			
			//上传进度的回调函数
//	 		function progressFunction(evt) {
//	 		     var percentageDiv = document.getElementById("percentage");
//	 		     var percentDom = document.getElementById("percent");
//	 		     if (evt.lengthComputable) {
//	 		    	// 获取文件上传的数据和文件的总大小计算百分比
//	 		         var p = Math.round(evt.loaded / evt.total * 100) + "%";
//	 		    	// 设定给页面的进度条，显示百分比
//	 		         percentageDiv.innerHTML = p;
//	 		         percentDom.style.width = p;
//	 		     }
//	 		} ; 
	</script>
 </body>
</html>
