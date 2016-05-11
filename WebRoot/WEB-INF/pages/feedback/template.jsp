<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach var="feedback" varStatus="feedbackindex" items="${datas}">
	<tr>
		<td>
			${feedback.id}
			<c:if test="${feedbackindex.index==0}"><input type="hidden" id="itemCount" value="${itemCount}"/></c:if>
		</td>	
		<td>${feedback.userName}</td>	
		<td>${feedback.content}</td>	
		<td class="tmui-tips" tip="${tz:formatDate(feedback.createTime,'yyyy-MM-dd HH:mm:ss')}">
			${tz:timeFormat(feedback.createTime)}
		</td>	
		<td>
			<tz:if test="${feedback.isDelete==0}">
				<tz:then><a href="javascript:void(0)" opid="${feedback.id}" mark="isDelete" val="1" onclick="tzAdmin.op(this);" class="red">否</a></tz:then>
				<tz:else><a href="javascript:void(0)" opid="${feedback.id}" mark="isDelete" val="0" onclick="tzAdmin.op(this);" class="green">是</a></tz:else>
			</tz:if>	
		</td>	
		<td>
			<tz:if test="${feedback.status==0}">
				<tz:then><a href="javascript:void(0)" opid="${feedback.id}" mark="status" val="1" onclick="tzAdmin.op(this);" class="red">否</a></tz:then>
				<tz:else><a href="javascript:void(0)" opid="${feedback.id}" mark="status" val="0" onclick="tzAdmin.op(this);" class="green">是</a></tz:else>
			</tz:if>	
		</td>	
		<td><a href="javascript:void(0);" data-opid="${feedback.id}" onclick="tzAdmin.remove(this)">未删除</a></td>
	</tr>
</c:forEach>
