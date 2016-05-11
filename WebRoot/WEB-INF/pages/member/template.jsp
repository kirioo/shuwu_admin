<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach var="member" varStatus="memberindex" items="${datas}">
	<tr>
		<td>
			${member.id}
			<c:if test="${memberindex.index==0}"><input type="hidden" id="itemCount" value="${itemCount}"/></c:if>
		</td>	
		<td>${member.userName}</td>	
		<td>${member.age}</td>
		<td>
			<tz:if test="${member.sex==0}">
				<tz:then><a href="javascript:void(0)"  class="red">男</a></tz:then>
				<tz:else><a href="javascript:void(0)"  class="green">女</a></tz:else>
			</tz:if>	
		</td>	
		<td>${member.phone}</td>	
		<td>
			<c:if test="${member.status==1}">还飘着的</c:if>
			<c:if test="${member.status==2}">回家了的</c:if>
			<c:if test="${member.status==3}">出国待定</c:if>
		</td>
		<td>${member.country}</td>
		<td>${member.university}</td>	
		<td>${member.city}</td>	
		<td class="tmui-tips" tip="${tz:formatDate(member.createTime,'yyyy-MM-dd HH:mm:ss')}">
			${tz:timeFormat(member.createTime)}
		</td>
		<td>
			<tz:if test="${member.forbiden==0}">
				<tz:then><a href="javascript:void(0)" opid="${member.id}" mark="forbiden" val="1" onclick="tzAdmin.op(this);" class="red">否</a></tz:then>
				<tz:else><a href="javascript:void(0)" opid="${member.id}" mark="forbiden" val="0" onclick="tzAdmin.op(this);" class="green">是</a></tz:else>
			</tz:if>	
		</td>	
		<td><a href="javascript:void(0);"data-opid="${member.id}" onclick="tzAdmin.remove(this)">未删除</a></td>
	</tr>
</c:forEach>