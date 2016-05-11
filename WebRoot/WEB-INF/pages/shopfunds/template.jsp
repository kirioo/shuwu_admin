<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach var="shopfunds" varStatus="shopfundsindex" items="${datas}">
	<tr>
		<td>
			${shopfunds.id}
			<c:if test="${shopfundsindex.index==0}"><input type="hidden" id="itemCount" value="${itemCount}"/></c:if>
		</td>	
		<td>${shopfunds.name}</td>	
		<td>${shopfunds.userId}</td>	
		<td class="tmui-tips" tip="${tz:formatDate(shopfunds.createTime,'yyyy-MM-dd HH:mm:ss')}">
			${tz:timeFormat(shopfunds.createTime)}
		</td>	
		<td>
			<tz:if test="${shopfunds.isDelete==0}">
				<tz:then><a href="javascript:void(0)" opid="${shopfunds.id}" mark="isDelete" val="1" onclick="tzAdmin.op(this);" class="red">否</a></tz:then>
				<tz:else><a href="javascript:void(0)" opid="${shopfunds.id}" mark="isDelete" val="0" onclick="tzAdmin.op(this);" class="green">是</a></tz:else>
			</tz:if>	
		</td>	
		<td>
			<tz:if test="${shopfunds.status==0}">
				<tz:then><a href="javascript:void(0)" opid="${shopfunds.id}" mark="status" val="1" onclick="tzAdmin.op(this);" class="red">否</a></tz:then>
				<tz:else><a href="javascript:void(0)" opid="${shopfunds.id}" mark="status" val="0" onclick="tzAdmin.op(this);" class="green">是</a></tz:else>
			</tz:if>	
		</td>	
		<td><a href="javascript:void(0);">未删除</a></td>
	</tr>
</c:forEach>
