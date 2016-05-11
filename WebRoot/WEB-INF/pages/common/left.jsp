<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="slider">
<div class="logo">
	<a href="${basePath}/admin/index"><img src="${basePath}/resources/images/logo.png"/></a>
	</div>
	<div class="nav">
		<c:if test="${session_user_role.name=='超级管理员'}">
			<ul>
			<tz:if test="${tz:indexOf(pageContext.request.requestURI,'adminuser')!=-1}">
				<tz:then>
					<li class="items active"><a href="javascript:void(0);"><i class="fa fa-home "></i>管理员账户</a>
					<ul style="display:block">
						 <tz:if test="${tz:indexOf(pageContext.request.requestURI,'/adminuser/list')!=-1}">
						 	<tz:then><li class="citems active"><a href="javascript:void(0);"><i class="fa fa-area-chart"></i>用户列表</a></li></tz:then>
						 	<tz:else><li class="citems"><a href="${adminPath}/adminuser/list"><i class="fa fa-area-chart"></i>用户列表</a></li></tz:else>
						 </tz:if>
						  <tz:if test="${tz:indexOf(pageContext.request.requestURI,'adminuser/addlist')!=-1}">
						 	<tz:then><li class="citems active"><a href="javascript:void(0);"><i class="fa fa-bar-chart"></i>密码修改</a></li></tz:then>
						 	<tz:else><li class="citems"><a href="${adminPath}/adminuser/addlist"><i class="fa fa-bar-chart"></i>密码修改</a></li></tz:else>
						 </tz:if>
						   <tz:if test="${tz:indexOf(pageContext.request.requestURI,'adminuser/adduser')!=-1}">
						 	<tz:then><li class="citems active"><a href="javascript:void(0);"><i class="fa fa-bar-chart"></i>添加管理</a></li></tz:then>
						 	<tz:else><li class="citems"><a href="${adminPath}/adminuser/adduser"><i class="fa fa-bar-chart"></i>添加管理</a></li></tz:else>
						 </tz:if>
					</ul>
				</li></tz:then>
				<tz:else>
					<li class="items"><a href="${adminPath}/adminuser/list"><i class="fa fa-home "></i>管理员账户</a></li>
				</tz:else>
			 </tz:if>
			 <tz:if test="${tz:indexOf(pageContext.request.requestURI,'role/list')!=-1}">
				<tz:then><li class="items active"><a href="javascript:void(0);"><i class="fa fa-home"></i>角色管理</a></li></tz:then>
				<tz:else><li class="items"><a href="${adminPath}/role/list"><i class="fa fa-home"></i>角色管理</a></li></tz:else>
			 </tz:if>
			 <tz:if test="${tz:indexOf(pageContext.request.requestURI,'recommend/list')!=-1}">
				<tz:then><li class="items active"><a href="javascript:void(0);"><i class="fa fa-home"></i>推荐管理</a></li></tz:then>
				<tz:else><li class="items"><a href="${adminPath}/recommend/list"><i class="fa fa-home"></i>推荐管理</a></li></tz:else>
			 </tz:if>
			 <tz:if test="${tz:indexOf(pageContext.request.requestURI,'event')!=-1}">
				<tz:then>
					<li class="items active"><a href="javascript:void(0);"><i class="fa fa-home "></i>活动管理</a>
					<ul style="display:block">
						 <tz:if test="${tz:indexOf(pageContext.request.requestURI,'/event/list')!=-1}">
						 	<tz:then><li class="citems active"><a href="javascript:void(0);"><i class="fa fa-area-chart"></i>活动列表</a></li></tz:then>
						 	<tz:else><li class="citems"><a href="${adminPath}/event/list"><i class="fa fa-area-chart"></i>活动列表</a></li></tz:else>
						 </tz:if>
						  <tz:if test="${tz:indexOf(pageContext.request.requestURI,'event/addlist')!=-1}">
						 	<tz:then><li class="citems active"><a href="javascript:void(0);"><i class="fa fa-bar-chart"></i>活动发布</a></li></tz:then>
						 	<tz:else><li class="citems"><a href="${adminPath}/event/addlist"><i class="fa fa-bar-chart"></i>活动发布</a></li></tz:else>
						 </tz:if>	 
					</ul>
				</li></tz:then>
				<tz:else>
					<li class="items"><a href="${adminPath}/event/list"><i class="fa fa-home "></i>活动管理</a></li>
				</tz:else>
			 </tz:if>
			  <tz:if test="${tz:indexOf(pageContext.request.requestURI,'approve/list')!=-1}">
				<tz:then><li class="items active"><a href="javascript:void(0);"><i class="fa fa-home"></i>认证管理</a></li></tz:then>
				<tz:else><li class="items"><a href="${adminPath}/approve/list"><i class="fa fa-home"></i>认证管理</a></li></tz:else>
			 </tz:if>  
			<li class="items"><a href="${adminPath}/vip/list" target="_blank"><i class="fa fa-home"></i>聊天管理</a></li>
			 <tz:if test="${tz:indexOf(pageContext.request.requestURI,'member/list')!=-1}">
				<tz:then><li class="items active"><a href="javascript:void(0);"><i class="fa fa-home"></i>会员管理</a></li></tz:then>
				<tz:else><li class="items"><a href="${adminPath}/member/list"><i class="fa fa-home"></i>会员管理</a></li></tz:else>
			 </tz:if>
			 <tz:if test="${tz:indexOf(pageContext.request.requestURI,'feedback/list')!=-1}">
				<tz:then><li class="items active"><a href="javascript:void(0);"><i class="fa fa-home"></i>意见反馈</a></li></tz:then>
				<tz:else><li class="items"><a href="${adminPath}/feedback/list"><i class="fa fa-home"></i>意见反馈</a></li></tz:else>
			 </tz:if>
			 <tz:if test="${tz:indexOf(pageContext.request.requestURI,'message/list')!=-1}">
				<tz:then><li class="items active"><a href="javascript:void(0);"><i class="fa fa-home"></i>推送管理</a></li></tz:then>
				<tz:else><li class="items"><a href="${adminPath}/message/list"><i class="fa fa-home"></i>推送管理</a></li></tz:else>
			 </tz:if>
		</ul>
	</c:if>
	
	<c:if test="${session_user_role.name=='一般管理员'}">
			<ul>
			<tz:if test="${tz:indexOf(pageContext.request.requestURI,'adminuser')!=-1}">
				<tz:then>
					<li class="items active"><a href="javascript:void(0);"><i class="fa fa-home "></i>管理员账户</a>
					<ul style="display:block">
						 <tz:if test="${tz:indexOf(pageContext.request.requestURI,'/adminuser/list')!=-1}">
						 	<tz:then><li class="citems active"><a href="javascript:void(0);"><i class="fa fa-area-chart"></i>用户列表</a></li></tz:then>
						 	<tz:else><li class="citems"><a href="${adminPath}/adminuser/list"><i class="fa fa-area-chart"></i>用户列表</a></li></tz:else>
						 </tz:if>
						  <tz:if test="${tz:indexOf(pageContext.request.requestURI,'adminuser/addlist')!=-1}">
						 	<tz:then><li class="citems active"><a href="javascript:void(0);"><i class="fa fa-bar-chart"></i>密码修改</a></li></tz:then>
						 	<tz:else><li class="citems"><a href="${adminPath}/adminuser/addlist"><i class="fa fa-bar-chart"></i>密码修改</a></li></tz:else>
						 </tz:if>
					</ul>
				</li></tz:then>
				<tz:else>
					<li class="items"><a href="${adminPath}/adminuser/list"><i class="fa fa-home "></i>管理员账户</a></li>
				</tz:else>
			 </tz:if>
			 <tz:if test="${tz:indexOf(pageContext.request.requestURI,'recommend/list')!=-1}">
				<tz:then><li class="items active"><a href="javascript:void(0);"><i class="fa fa-home"></i>推荐管理</a></li></tz:then>
				<tz:else><li class="items"><a href="${adminPath}/recommend/list"><i class="fa fa-home"></i>推荐管理</a></li></tz:else>
			 </tz:if>
			 <tz:if test="${tz:indexOf(pageContext.request.requestURI,'event')!=-1}">
				<tz:then>
					<li class="items active"><a href="javascript:void(0);"><i class="fa fa-home "></i>活动管理</a>
					<ul style="display:block">
						 <tz:if test="${tz:indexOf(pageContext.request.requestURI,'/event/list')!=-1}">
						 	<tz:then><li class="citems active"><a href="javascript:void(0);"><i class="fa fa-area-chart"></i>活动列表</a></li></tz:then>
						 	<tz:else><li class="citems"><a href="${adminPath}/event/list"><i class="fa fa-area-chart"></i>活动列表</a></li></tz:else>
						 </tz:if>
						  <tz:if test="${tz:indexOf(pageContext.request.requestURI,'event/addlist')!=-1}">
						 	<tz:then><li class="citems active"><a href="javascript:void(0);"><i class="fa fa-bar-chart"></i>活动发布</a></li></tz:then>
						 	<tz:else><li class="citems"><a href="${adminPath}/event/addlist"><i class="fa fa-bar-chart"></i>活动发布</a></li></tz:else>
						 </tz:if>	 
					</ul>
				</li></tz:then>
				<tz:else>
					<li class="items"><a href="${adminPath}/event/list"><i class="fa fa-home "></i>活动管理</a></li>
				</tz:else>
			 </tz:if>
			  <tz:if test="${tz:indexOf(pageContext.request.requestURI,'approve/list')!=-1}">
				<tz:then><li class="items active"><a href="javascript:void(0);"><i class="fa fa-home"></i>认证管理</a></li></tz:then>
				<tz:else><li class="items"><a href="${adminPath}/approve/list"><i class="fa fa-home"></i>认证管理</a></li></tz:else>
			 </tz:if>  
			<li class="items"><a href="${adminPath}/vip/list" target="_blank"><i class="fa fa-home"></i>聊天管理</a></li>
			 <tz:if test="${tz:indexOf(pageContext.request.requestURI,'member/list')!=-1}">
				<tz:then><li class="items active"><a href="javascript:void(0);"><i class="fa fa-home"></i>会员管理</a></li></tz:then>
				<tz:else><li class="items"><a href="${adminPath}/member/list"><i class="fa fa-home"></i>会员管理</a></li></tz:else>
			 </tz:if>
			 <tz:if test="${tz:indexOf(pageContext.request.requestURI,'feedback/list')!=-1}">
				<tz:then><li class="items active"><a href="javascript:void(0);"><i class="fa fa-home"></i>意见反馈</a></li></tz:then>
				<tz:else><li class="items"><a href="${adminPath}/feedback/list"><i class="fa fa-home"></i>意见反馈</a></li></tz:else>
			 </tz:if>
			 <tz:if test="${tz:indexOf(pageContext.request.requestURI,'message/list')!=-1}">
				<tz:then><li class="items active"><a href="javascript:void(0);"><i class="fa fa-home"></i>推送管理</a></li></tz:then>
				<tz:else><li class="items"><a href="${adminPath}/message/list"><i class="fa fa-home"></i>推送管理</a></li></tz:else>
			 </tz:if>
		</ul>
	</c:if>
	
	</div>
</div>