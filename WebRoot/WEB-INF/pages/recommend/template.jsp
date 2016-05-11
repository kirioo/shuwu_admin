<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach var="recommend" varStatus="recommendindex" items="${datas}">
	<tr>
		<td>
			${recommend.id}
			<c:if test="${recommendindex.index==0}"><input type="hidden" id="itemCount" value="${itemCount}"/></c:if>
		</td>	
		<td>${recommend.userName}</td>	
		<td>${recommend.age}</td>
		<td>
			<tz:if test="${recommend.sex==0}">
				<tz:then><a href="javascript:void(0)"  class="red">男</a></tz:then>
				<tz:else><a href="javascript:void(0)"  class="green">女</a></tz:else>
			</tz:if>	
		</td>	
		<td>${recommend.phone}</td>	
		<td>
			<c:if test="${recommend.status==1}">还飘着的</c:if>
			<c:if test="${recommend.status==2}">回家了的</c:if>
			<c:if test="${recommend.status==3}">出国待定</c:if>
		</td>
		<td>${recommend.country}</td>
		<td>${recommend.university}</td>	
		<td>${recommend.city}</td>	
		<td class="tmui-tips" tip="${tz:formatDate(recommend.createTime,'yyyy-MM-dd HH:mm:ss')}">
			${tz:timeFormat(recommend.createTime)}
		</td>
		<td>
			<tz:if test="${recommend.approve==0}">
				<tz:then><a href="javascript:void(0)" val="0" class="green">未认证</a></tz:then>
				<tz:else><a href="javascript:void(0)" val="1" class="red">已认证</a></tz:else>
			</tz:if>	
		</td>	
		<td>
			<tz:if test="${recommend.tuiJian==0}">
				<tz:then><a href="javascript:void(0)" opid="${recommend.id}" mark="tuiJian" val="1" onclick="tzAdmin.op(this);" class="red">否</a></tz:then>
				<tz:else><a href="javascript:void(0)" opid="${recommend.id}" mark="tuiJian" val="0" onclick="tzAdmin.op(this);" class="green">是</a></tz:else>
			</tz:if>	
		</td>	
		<td><a href="javascript:void(0);"data-opid="${recommend.id}" onclick="tzAdmin.remove(this)">未推荐</a></td>
	</tr>
</c:forEach>
