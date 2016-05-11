<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>资金管理</title>
	<meta http-equiv="pragma" adminstat="no-cache">
	<meta http-equiv="cache-control" adminstat="no-cache">
	<meta http-equiv="expires" adminstat="0">    
	<meta http-equiv="keywords" adminstat="keyword1,keyword2,keyword3">
	<meta http-equiv="description" adminstat="This is my page">
	<%@include file="/WEB-INF/pages/common/common.jsp" %>
	<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
<!-- 	 <script src="${basePath}/resources/js/echart/echarts-all.js"></script> -->
	 <script src="${basePath}/resources/js/echart/echarts.js"></script>
	 <script type="text/javascript" src="${basePath}/resources/js/date/WdatePicker.js"></script>
 </head>
 <body>
	<div class="wrap">
		<!-- left页面 -->
		<%@include file="/WEB-INF/pages/common/left.jsp" %>
		<div class="content">
			<%@include file="/WEB-INF/pages/common/header.jsp" %>
			<div class="channel"> 首页  &gt; 资金管理</div>
			<div class="cnt">
				<div style="padding:10px;">
					<input type="text"  id="date" onFocus="WdatePicker({onpicking:changeDate,dateFmt:'yyyy'})" class="Wdate"/>	
				</div>
				<div class="tabwrap" id="main" style="height: 400px;">
				</div>	
			</div>
			
		</div>
		
	</div>
	<script>
	
		$(function(){
			loadData(new Date().getFullYear());
		});
		
		// 点击日期的回调函数
		function changeDate(dp){
			var date = dp.cal.getNewDateStr();
			loadData(date);
		}
		
		//数据加载，初始化统计报表
		function loadData(year){
			$.ajax({
				type:"post",
				url:"http://localhost/malimao_admin/admin/shopfunds/groupMonths",
				data:{year:year},
				success:function(data){
					
					//收入
					var jsonICome = {};
					for(var i = 0;i<data.length;i++){
						var num = data[i].income
						var m = data[i].m
						jsonICome["s"+parseInt(m)] = num; 
					};
					var arr = [];
					for(var i=1;i<=12;i++){
						arr.push(jsonICome["s"+i]||0);
					}
					console.log(arr);
					
					//支出
					var payOut= {};
					for(var i = 0;i<data.length;i++){
						var num = data[i].payOut
						var m = data[i].m						
						payOut["s"+parseInt(m)] = num; 
					};
					var payarr = [];
					for(var i=1;i<=12;i++){
						payarr.push(payOut["s"+i]||0);
					}
		
					
					//总账
					var sumJob= {};
					for(var i = 0;i<data.length;i++){
						var num = data[i].gl
						var m = data[i].m						
						sumJob["s"+parseInt(m)] = num; 
					};
					var sumarr = [];
					for(var i=1;i<=12;i++){
						sumarr.push(sumJob["s"+i]||0);
					}
					
					
					var json = {
						title:year+"年度玛丽猫网网站周资金详情",	
						IComeDates:arr,
						payDates:payarr,
						sumDates:sumarr
					};
					initChart("main",json);//初始化统计报表
				}
			});
		};

	
		//统计报表的初始化
		function initChart(targetId,json){
			require.config({
	            paths: {
	                echarts: basePath+'/resources/js/echart'
	            }
	        });
	        require(
	            [
	                'echarts',
	                'echarts/chart/bar',
					'echarts/chart/pie'
	            ],
	           function (ec) {
	                var myChart = ec.init(document.getElementById(targetId));
	                var option  = {
						    title : {
						    	x: "center",
						        text: json.title,
						        subtext: "星期/总数"
						    },
						    tooltip : {
						        trigger: 'axis'
						    },
						   
						    toolbox: {
						        show : true,
						        feature : {
						            mark : {show: true},
						            dataView : {show: true, readOnly: false},
						            magicType : {show: true, type: ['line', 'bar']},
						            restore : {show: true},
						            saveAsImage : {show: true}
						        }
						    },
						    
						    calculable : true,
						    xAxis : [
						        {
						            type : 'category',
						            data : ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月']
						        }
						    ],
						    yAxis : [
						        {
						            type : 'value'
						        }
						    ],
						    series : [
						        {
						            name:'总账',
						            type:'bar',
						            data:json.IComeDates,
						            markPoint : {
						                data : [
						                    {type : 'max', name: '最大值'},
						                    {type : 'min', name: '最小值'}
						                ]
						            },
						            markLine : {
						                data : [
						                    {type : 'average', name: '平均值'}
						                ]
						            }
						        },
						        {
						            name:'支出',
						            type:'bar',
						            data:json.payDates,
						            markPoint : {
						                data : [
						                    {type : 'max', name: '最大值'},
						                    {type : 'min', name: '最小值'}
						                ]
						            },
						            markLine : {
						                data : [
						                    {type : 'average', name: '平均值'}
						                ]
						            }
						        },
						        {
						            name:'收入',
						            type:'bar',
						            data:json.sumDates,
						            markPoint : {
						                data : [
						                    {type : 'max', name: '最大值'},
						                    {type : 'min', name: '最小值'}
						                ]
						            },
						            markLine : {
						                data : [
						                    {type : 'average', name: '平均值'}
						                ]
						            }
						        }
						    ]
						};
	                //添加报表数据给echart
					myChart.setOption(option);
	                //初始化echart的config对象
					var ecConfig = require('echarts/config');
	                //执行config的回调函数
					myChart.on(ecConfig.EVENT.CLICK, eConsole);
	            }
	        );
		};
			
		//点击柱形图回调事件
// 		var timer = null;
// 		function eConsole(d) {
// 			//获取用户点击的数据
// 			var month = parseInt(d.name);
// 			//参数
// 	 		var params ={
//  				month:month,
//  				order:"create_time desc",
//  				pageNo:0,
//  				pageSize:30
// 	 		};
// 			loading2($("#tbody"),4);
// 			//执行业务
// 			clearTimeout(timer);
// 	 		timer = setTimeout(function(){
// 	 			$.ajax({
// 		 			type:"post",
// 		 			url:adminPath+"/adminstat/groupcontent",
// 		 			data:params,
// 		 			success:function(data){
// 		 				var len = data.length;
// 		 				var html = "";
// 		 				for(var i=0;i<len;i++){
// 		 					html+="<tr>"+
// 		 					"	<td>"+data[i].id+"</td>"+
// 		 					"	<td>"+data[i].title+"</td>"+
// 		 					"	<td>"+data[i].time+"</td>"+
// 		 					"	<td>操作</td>"+
// 		 					"</tr>";
// 		 				}
// 		 				$("#tbody").html(html);
// 		 			}
// 		 		});
// 	 		},200);
// 		};
		
		
		
		
// 		function initChart(targetId,json){
//			var myChart = echarts.init(document.getElementById(targetId));
//			var option  = {
//				    title : {
//				    	x: "center",
//				        text: json.title,
//				        subtext: "月份/总数"
//				    },
//				    tooltip : {
//				        trigger: 'axis'
//				    },
			   
//				    toolbox: {
//				        show : true,
//				        feature : {
//				            mark : {show: true},
//				            dataView : {show: true, readOnly: false},
//				            magicType : {show: true, type: ['line', 'bar']},
//				            restore : {show: true},
//				            saveAsImage : {show: true}
//				        }
//				    },
			    
//				    calculable : true,
//				    xAxis : [
//				        {
//				            type : 'category',
//				            data : ['1月','2月','3月','4月','5月','6月','7月','8月','9月','10月','11月','12月']
//				        }
//				    ],
//				    yAxis : [
//				        {
//				            type : 'value'
//				        }
//				    ],
//				    series : [
//				        {
//				            name:'访问人数',
//				            type:'bar',
//				            data:json.datas,
//				            markPoint : {
//				                data : [
//				                    {type : 'max', name: '最大值'},
//				                    {type : 'min', name: '最小值'}
//				                ]
//				            },
//				            markLine : {
//				                data : [
//				                    {type : 'average', name: '平均值'}
//				                ]
//				            }
//				        }
//				    ]
//				};
//			myChart.setOption(option);
//			myChart.on(ecConfig.EVENT.CLICK, eConsole);
//			myChart.on(ecConfig.EVENT.DBLCLICK, eConsole);
//			myChart.on(ecConfig.EVENT.HOVER, eConsole);
//			myChart.on(ecConfig.EVENT.DATA_ZOOM, eConsole);
//			myChart.on(ecConfig.EVENT.LEGEND_SELECTED, eConsole);
//			myChart.on(ecConfig.EVENT.MAGIC_TYPE_CHANGED, eConsole);
//			myChart.on(ecConfig.EVENT.DATA_VIEW_CHANGED, eConsole);
//		}
    </script>
 </body>
</html>
