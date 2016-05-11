<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>日统计</title>
	<meta http-equiv="pragma" adminstat="no-cache">
	<meta http-equiv="cache-control" adminstat="no-cache">
	<meta http-equiv="expires" adminstat="0">    
	<meta http-equiv="keywords" adminstat="keyword1,keyword2,keyword3">
	<meta http-equiv="description" adminstat="This is my page">
	<%@include file="/WEB-INF/pages/common/common.jsp" %>
	<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
<!-- 	 <script src="${basePath}/resources/js/echart/echarts-all.js"></script> -->
	<script type="text/javascript" src="${basePath}/resources/js/echart/echarts.js"></script>
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
					<input type="text"  id="date" onFocus="WdatePicker({onpicking:changeDate})" class="Wdate"/>	
				</div>
				<div class="tabwrap" id="main" style="height: 300px;">
					
				</div>	
				
			</div>
		</div>
	</div>
	<script>
	
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
			
			var d = new Date().format('yyyy-MM-dd');
			loadData(d);
			$("#date").val(d);
		});
		
		function loadData(date){
			tzAjax.request({
				path:adminPath,
				model:"funds",
				method:"groupFunds",
				success:function(data){	
//					收入
					for(var i = 0;i<data.length;i++){
						var num = data[i].income					
					};
					
//					支出
					for(var i = 0;i<data.length;i++){
						var numpay = data[i].payOut						

					};
		
					
//					总账
					var sumJob= {};
					for(var i = 0;i<data.length;i++){
						var sum = data[i].gl						
					};

	
						
					
					var json = {
						title:date+"玛丽猫网站日资金详情",	
						IComeDates:num,
						payDates:numpay,
						sumDates:sum,
						timeLines:getTimeLine()
					};
					initChart("main",json);
				}
			},{"date":date});
		};
		
		// 点击日期的回调函数
		function changeDate(dp){
			var date = dp.cal.getNewDateStr();
			loadData(date);
		}
		
		
		//时间轴准备
		function getTimeLine(){
			var arr = [];
			for(var i=0;i<=23;i++){
				arr.push((i<10?"0"+i:i)+":00");
			}
			return arr;
		};

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
					'echarts/chart/pie',
					'echarts/chart/line'
	            ],
	           function (ec) {
	                var myChart = ec.init(document.getElementById(targetId));
	                var option = {
	                	    tooltip: {
	                	        trigger: 'item',
	                	        formatter: "{a} <br/>{b}: {c} ({d}%)"
	                	    },
	                	    legend: {
	                	        orient: 'vertical',
	                	        x: 'left',
	                	        data:['总账','支出','收入']
	                	    },
	                	    series: [
	                	        {
	                	            name:'资金来源',
	                	            type:'pie',
	                	            radius: ['50%', '70%'],
	                	            avoidLabelOverlap: false,
	                	            label: {
	                	                normal: {
	                	                    show: false,
	                	                    position: 'center'
	                	                },
	                	                emphasis: {
	                	                    show: true,
	                	                    textStyle: {
	                	                        fontSize: '30',
	                	                        fontWeight: 'bold'
	                	                    }
	                	                }
	                	            },
	                	            labelLine: {
	                	                normal: {
	                	                    show: false
	                	                }
	                	            },
	                	            data:[
	                	                {value:json.IComeDates, name:'总账'},
	                	                {value:json.payDates, name:'支出'},
	                	                {value:json.sumDates, name:'收入'}
	                	            ]
	                	        }
	                	    ]
	                	};
	               
	                	                    
					myChart.setOption(option);
					var ecConfig = require('echarts/config');
					myChart.on(ecConfig.EVENT.CLICK, eConsole);
	            }
	        );
	}
		
	
	function eConsole(param) {
	};
	
// 	 var option = {
//         	    title : {
//         	    	x:"center",
//         	        text: json.title,
//         	        subtext: '时间/金额'
//         	    },
//         	    tooltip : {
//         	        trigger: 'axis'
//         	    },
//          	    legend: {
//          	        data:['意向','预购','成交']
//          	    },
//         	    toolbox: {
//         	        show : true,
//         	        feature : {
//         	            mark : {show: true},
//         	            dataView : {show: true, readOnly: false},
//         	            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
//         	            restore : {show: true},
//         	            saveAsImage : {show: true}
//         	        }
//         	    },
//         	    calculable : true,
//         	    xAxis : [
//         	        {	
//         	        	name:"时间段",
//         	            type : 'category',
//         	            data :json.timeLines
//         	        }
//         	    ],
//         	    yAxis : [
//         	        {
//         	        	name:"金额",	
//         	            type : 'value'
//         	        }
//         	    ],
//         	    series : [
//         	        {
//         	            name:'收入',
//         	            type:'line',
//         	            smooth:true,
//         	            itemStyle: {normal: {areaStyle: {type: 'default'}}},
//         	        	markPoint : {
// 			                data : [
// 			                    {type : 'max', name: '最大值'},
// 			                    {type : 'min', name: '最小值'}
// 			                ]
// 			            },
// 			            markLine : {
// 			                data : [
// 			                    {type : 'average', name: '平均值'}
// 			                ]
// 			            },
//         	            data:json.IComeDates
//         	        },
//         	    	{
//         	            name:'支出',
//         	            type:'line',
//         	            smooth:true,
//         	            itemStyle: {normal: {areaStyle: {type: 'default'}}},
//         	        	markPoint : {
// 			                data : [
// 			                    {type : 'max', name: '最大值'},
// 			                    {type : 'min', name: '最小值'}
// 			                ]
// 			            },
// 			            markLine : {
// 			                data : [
// 			                    {type : 'average', name: '平均值'}
// 			                ]
// 			            },
//         	            data:json.payDates
//         	        },
//         	     	{
//      	            name:'总账',
//      	            type:'line',
//      	            smooth:true,
//      	            itemStyle: {normal: {areaStyle: {type: 'default'}}},
//      	        	markPoint : {
// 			                data : [
// 			                    {type : 'max', name: '最大值'},
// 			                    {type : 'min', name: '最小值'}
// 			                ]
// 			            },
// 			            markLine : {
// 			                data : [
// 			                    {type : 'average', name: '平均值'}
// 			                ]
// 			            },
//      	            data:json.sumDates
//      	        }
//         	    ]
//         	};
	
 </script>
 </body>
</html>
