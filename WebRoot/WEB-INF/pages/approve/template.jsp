<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach var="approve" varStatus="approveindex" items="${datas}">
	<tr>
		<td>
			${approve.id}
			<c:if test="${approveindex.index==0}"><input type="hidden" id="itemCount" value="${itemCount}"/></c:if>
		</td>	
		<td>${approve.userName}</td>	
		<td>${approve.age}</td>
		<td>
			<tz:if test="${approve.sex==0}">
				<tz:then><a href="javascript:void(0)"  class="red">男</a></tz:then>
				<tz:else><a href="javascript:void(0)"  class="green">女</a></tz:else>
			</tz:if>	
		</td>	
		<td>${approve.phone}</td>	
		<td>
			<c:if test="${approve.status==1}">还飘着的</c:if>
			<c:if test="${approve.status==2}">回家了的</c:if>
			<c:if test="${approve.status==3}">出国待定</c:if>
		</td>
		<td>${approve.country}</td>
		<td>${approve.university}</td>	
		<td>${approve.city}</td>	
		<td class="tmui-tips" tip="${tz:formatDate(approve.createTime,'yyyy-MM-dd HH:mm:ss')}">
			${tz:timeFormat(approve.createTime)}
		</td>
 		<td><img src="${approve.idCard}" width=60px height=60px; class="btn"></td>	
		<td>
			<tz:if test="${approve.approve==0}">
				<tz:then><a href="javascript:void(0)" opid="${approve.id}" mark="approve" val="1" onclick="tzAdmin.op(this);" class="red">否</a></tz:then>
				<tz:else><a href="javascript:void(0)" opid="${approve.id}" mark="approve" val="0" onclick="tzAdmin.op(this);" class="green">是</a></tz:else>
			</tz:if>	
		</td>	
		<td><a href="javascript:void(0);"data-opid="${approve.id}" onclick="tzAdmin.remove(this)">未认证</a></td>
	</tr>
</c:forEach>
