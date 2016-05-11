<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<c:forEach var="content" varStatus="contentindex" items="${datas}">
	<tr>
		<td>
			${content.id}
			<c:if test="${contentindex.index==0}"><input type="hidden" id="itemCount" value="${itemCount}"/></c:if>
		</td>	
		<td class="keys">${content.title}</td>	
		<td class="tmui-tips">
			<c:if test="${content.goodsType==1}">婚纱摄影</c:if>
			<c:if test="${content.goodsType==2}">蜜月旅行</c:if>
			<c:if test="${content.goodsType==3}">珠宝首饰</c:if>
		</td>	
		<td>${content.photographyType}</td>
		<td class="tmui-tips">
			<c:if test="${content.style==1}">欧式</c:if>
			<c:if test="${content.style==2}">韩式</c:if>
			<c:if test="${content.style==3}">中式</c:if>
			<c:if test="${content.style==4}">个性</c:if>
		</td>
		<td>${content.originalPrice}</td>
		<td>${content.discountedPrice}</td>
		<td>${content.expressPrice}</td>
		<td>${content.maxPrice}</td>
		<td>${content.minPrice}</td>	
		<td class="tmui-tips" tip="${tz:formatDate(content.createTime,'yyyy-MM-dd HH:mm:ss')}">
			${tz:timeFormat(content.createTime)}
		</td>	
		<td>
			<tz:if test="${content.state==0}">
				<tz:then><a href="javascript:void(0)" opid="${content.id}" mark="isDelete" val="1" onclick="tzAdmin.op(this);" class="red">否</a></tz:then>
				<tz:else><a href="javascript:void(0)" opid="${content.id}" mark="isDelete" val="0" onclick="tzAdmin.op(this);" class="green">是</a></tz:else>
			</tz:if>	
		</td>	
		<td class="tmui-tips">
			<a href="detail/${content.id}" data-opid="${content.id}">管理价格</a>
			<a href="javascript:void(0);" data-opid="${content.id}" onclick="tzAdmin.remove(this)">删除</a>
		</td>
	</tr>
</c:forEach>