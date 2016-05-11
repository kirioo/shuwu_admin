<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach var="message" varStatus="messageindex" items="${datas}">
	<tr>
		<td>
			${message.id}
			<c:if test="${messageindex.index==0}"><input type="hidden" id="itemCount" value="${itemCount}"/></c:if>
		</td>	
		<td>${message.name}</td>	
		<td>${message.userId}</td>	
		<td class="tmui-tips" tip="${tz:formatDate(message.createTime,'yyyy-MM-dd HH:mm:ss')}">
			${tz:timeFormat(message.createTime)}
		</td>	
		<td>${message.isDelete}</td>	
		<td>${message.status}</td>	
		<td><a href="javascript:void(0);">未删除</a></td>
	</tr>
</c:forEach>
