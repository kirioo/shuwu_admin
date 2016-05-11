<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach var="funds" varStatus="fundsindex" items="${datas}">
	<tr>
		<td>
			${funds.id}
			<c:if test="${fundsindex.index==0}"><input type="hidden" id="itemCount" value="${itemCount}"/></c:if>
		</td>	
		<td>${funds.name}</td>	
		<td>${funds.userId}</td>
		<td>${funds.income}</td>
		<td>${funds.payOut}</td>
		<td>${funds.gl}</td>	
		<td class="tmui-tips" tip="${tz:formatDate(funds.createTime,'yyyy-MM-dd HH:mm:ss')}">
			${tz:timeFormat(funds.createTime)}
		</td>
			
	</tr>
</c:forEach>
