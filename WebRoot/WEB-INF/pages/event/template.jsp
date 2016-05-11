<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach var="event" varStatus="eventindex" items="${datas}">
	<tr>
		<td>
			${event.id}
			<c:if test="${eventindex.index==0}"><input type="hidden" id="itemCount" value="${itemCount}"/></c:if>
		</td>	
		<td><div  onclick="tzAdmin.child(this);" opid="${event.id}">${event.title}<div></td>	
		<td>${event.autor}</td>	
		<td class="tmui-tips" tip="${tz:formatDate(event.createTime,'yyyy-MM-dd HH:mm:ss')}">
			${tz:timeFormat(event.createTime)}
		</td>	
		<td>
			<tz:if test="${event.isDelete==0}">
				<tz:then><a href="javascript:void(0)" opid="${event.id}" mark="isDelete" val="1" onclick="tzAdmin.op(this);" class="red">否</a></tz:then>
				<tz:else><a href="javascript:void(0)" opid="${event.id}" mark="isDelete" val="0" onclick="tzAdmin.op(this);" class="green">是</a></tz:else>
			</tz:if>	
		</td>	
		<td>
			<tz:if test="${event.status==0}">
				<tz:then><a href="javascript:void(0)" opid="${event.id}" mark="status" val="1" onclick="tzAdmin.op(this);" class="red">否</a></tz:then>
				<tz:else><a href="javascript:void(0)" opid="${event.id}" mark="status" val="0" onclick="tzAdmin.op(this);" class="green">是</a></tz:else>
			</tz:if>	
		</td>	
		<td><a href="javascript:void(0);" data-opid="${event.id}" onclick="tzAdmin.remove(this)">未删除</a></td>
	</tr>	
</c:forEach>

