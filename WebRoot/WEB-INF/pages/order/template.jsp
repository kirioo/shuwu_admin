<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach var="order" varStatus="orderindex" items="${datas}">
	<tr>
		<td>
			${order.id}
			<c:if test="${orderindex.index==0}"><input type="hidden" id="itemCount" value="${itemCount}"/></c:if>
		</td>	
		<td>${order.title}</td>	
		<td>${order.nickname}</td>
		<td>${order.total}</td>	
		<td>${order.number}</td>
		<td>${order.perPrice}</td>		
		<td class="tmui-tips" tip="${tz:formatDate(order.placeOrderTime,'yyyy-MM-dd HH:mm:ss')}">
			${tz:timeFormat(order.placeOrderTime)}
		</td>
		<td class="tmui-tips" tip="${tz:formatDate(order.cancelTime,'yyyy-MM-dd HH:mm:ss')}">
			${tz:timeFormat(order.cancelTime)}
		</td>
		<td class="tmui-tips" tip="${tz:formatDate(order.payTime,'yyyy-MM-dd HH:mm:ss')}">
			${tz:timeFormat(order.payTime)}
		</td>
		<td>${order.detailAddress}</td>	
		<td class="tmui-tips" tip="${tz:formatDate(order.receivingConfirmationTime,'yyyy-MM-dd HH:mm:ss')}">
			${tz:timeFormat(order.receivingConfirmationTime)}
		</td>
		<td class="tmui-tips" tip="${tz:formatDate(order.applicationReturnsTime,'yyyy-MM-dd HH:mm:ss')}">
			${tz:timeFormat(order.applicationReturnsTime)}
		</td>
		<td class="tmui-tips" tip="${tz:formatDate(order.refundTime,'yyyy-MM-dd HH:mm:ss')}">
			${tz:timeFormat(order.refundTime)}
		</td>	
		<td>
			<c:if test="${order.distributionMode==1}">商家配送</c:if>
		</td>
		<td>${order.postage}</td>
		<td>${order.supplement}</td>
		<td>
			<c:if test="${order.state==0}">已删除</c:if>
			<c:if test="${order.state==1}">待付款</c:if>
			<c:if test="${order.state==2}">待发货</c:if>
			<c:if test="${order.state==3}">已发货</c:if>
			<c:if test="${order.state==4}">已收货</c:if>
			<c:if test="${order.state==5}">已申请退款</c:if>
			<c:if test="${order.state==6}">确认退款</c:if>
			<c:if test="${order.state==7}">退款驳回</c:if>
			<c:if test="${order.state==8}">退款完成</c:if>
			<c:if test="${order.state==9}">已取消</c:if>
		</td>
		<td>
			<select id="sel_${order.id}" style="background:#2E363F;" data-opid="${order.id}" onclick="status('${order.id}')">
				<c:if test="${order.state==0}">
					<option value=''>暂无操作</option>
				</c:if>
				<c:if test="${order.state==1}">
					<option value='' >暂无操作</option>
				</c:if>
				<c:if test="${order.state==2}">
					<option  value=''>是否发货</option>
					<option  value='3'>确认发货</option>
				</c:if>
				<c:if test="${order.state==3}">
					<option value='' >暂无操作</option>
				</c:if>
				<c:if test="${order.state==4}">
					<option value='' >暂无操作</option>
				</c:if>
				<c:if test="${order.state==5}">
					<option value=''>是否退款</option>
					<option value='6'>确认退款</option>
					<option value='7'>退款驳回</option>		
				</c:if>
				<c:if test="${order.state==6}">
					<option value=''>退款完成？</option>
					<option value='8'>交易完成</option>
				</c:if>
				<c:if test="${order.state==7}">
					<option value=''>暂无操作</option>
				</c:if>
				<c:if test="${order.state==8}">
					<option value='0'>暂未操作</option>
				</c:if>
				<c:if test="${order.state==9}">	
					<option value='0'>暂无操作</option>
				</c:if>											
			</select>
		</td>
	</tr>
</c:forEach>
<script type="text/javascript">

		function status(id){
			$("#sel_"+id+"").change(function(){
				$.tzConfirm({title:"友情提示",content:"您确定此操作吗?",callback:function(ok){
					if(ok){
						var selval = $("#sel_"+id+"").val();
						clearTimeout(this.timer);
						this.timer = setTimeout(function(){
//							loading("请稍后数据执行中...");
							$.ajax({
								type:"post",
								url:adminPath+"/order/status",
								data:{"id":id,"sel":selval},
								success:function(data){
									loading("执行成功...",3);							
									//window.location.href =window.location.href;
									tzAdmin.loadData(0,10,function(itemCount){
										tzAdmin.initPage(itemCount);//分页加载一次吗
									});
								}
							});
						},200);
					}
				}});
			});
	 	}
</script>