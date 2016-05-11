<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach var="vip" varStatus="vipindex" items="${datas}">
	<tr>
		<td>
			${vip.id}
			<c:if test="${vipindex.index==0}"><input type="hidden" id="itemCount" value="${itemCount}"/></c:if>
		</td>	
		<td>${vip.name}</td>	
		<td>${vip.userId}</td>	
		<td class="tmui-tips" tip="${tz:formatDate(vip.createTime,'yyyy-MM-dd HH:mm:ss')}">
			${tz:timeFormat(vip.createTime)}
		</td>	
		<td>
			<tz:if test="${vip.isDelete==0}">
				<tz:then><a href="javascript:void(0)" opid="${vip.id}" mark="isDelete" val="1" onclick="tzAdmin.op(this);" class="red">否</a></tz:then>
				<tz:else><a href="javascript:void(0)" opid="${vip.id}" mark="isDelete" val="0" onclick="tzAdmin.op(this);" class="green">是</a></tz:else>
			</tz:if>	
		</td>	
		<td>
			<tz:if test="${vip.status==0}">
				<tz:then><a href="javascript:void(0)" opid="${vip.id}" mark="status" val="1" onclick="tzAdmin.op(this);" class="red">否</a></tz:then>
				<tz:else><a href="javascript:void(0)" opid="${vip.id}" mark="status" val="0" onclick="tzAdmin.op(this);" class="green">是</a></tz:else>
			</tz:if>	
		</td>	
		<td><a href="javascript:void(0);"data-opid="${vip.id}" onclick="tzAdmin.remove(this)">未删除</a></td>
	</tr>
</c:forEach>
