<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@include file="/WEB-INF/pages/common/taglib.jsp"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>模板页面</title>
	<meta http-equiv="pragma" funds="no-cache">
	<meta http-equiv="cache-control" funds="no-cache">
	<meta http-equiv="expires" funds="0">    
	<meta http-equiv="keywords" funds="keyword1,keyword2,keyword3">
	<meta http-equiv="description" funds="This is my page">
	<%@include file="/WEB-INF/pages/common/common.jsp" %>
	<script type="text/javascript" src="${basePath}/resources/sg/tz_page.js"></script>
	
		<!--sdk-->
	<script src="${basePath}/resources/static/sdk/strophe.js"></script>
	<script src="${basePath}/resources/static/sdk/easemob.im-1.1.js"></script>
	<script src="${basePath}/resources/static/sdk/easemob.im-1.1.shim.js"></script><!--兼容老版本sdk需引入此文件-->
	
	<!--config-->
	<script src="${basePath}/resources/static/js/easemob.im.config.js"></script>
	
	<!--demo-->
	<script src="${basePath}/resources/static/js/jquery-1.11.1.js"></script>
	<script src="${basePath}/resources/static/js/bootstrap.js"></script>
	<link rel="stylesheet" href="${basePath}/resources/static/css/bootstrap.css" />
	<link rel="stylesheet" href="${basePath}/resources/static/css/webim.css" />
	
 </head>
 <body>
	 <div id="loginmodal" class="modal hide in" role="dialog"
        aria-hidden="true" data-backdrop="static">
        <div class="modal-header">
            <h3>用户登录</h3>
        </div>
        <div class="modal-body">
            <table>
                <tr>
                    <td width="65%">
                        <label for="username">用户名:</label>
                        <input type="text" name="username" value="" id="username" tabindex="1"/>
                        <label for="password">密码:</label>
                        <input type="password" name="password" value="" id="password" tabindex="2" />
                        <label for="token">令牌:</label>
                        <input type="text" name="token" value="" id="token" disabled="disabled" tabindex="3" />
                    </td>
                </tr>
            </table>
            <label class="checkbox">
                <input type="checkbox" name="usetoken" id="usetoken" tabindex="4" />使用令牌登录
            </label>    
        </div>
        <div class="modal-footer">
            <button class="flatbtn-blu" onclick="login()" tabindex="3">登录</button>
            <button class="flatbtn-blu" onclick="showRegist()" tabindex="4">注册</button>
        </div>
    </div>

    <!-- 注册操作界面 -->
    <div id="regist-div-modal" class="alert modal hide" role="dialog"
        aria-hidden="true" data-backdrop="static">
        <div class="modal-header">
            <h3>用户注册</h3>
        </div>
        <div class="modal-body">
            <div id="regist_div" style="overflow-y: auto">
                <table>
                    <tr>
                        <td width="65%"><label>用户名:</label> <input type="text"
                            value="" id="regist_username" tabindex="1" /> <label>密码:</label>
                            <input type="password" value="" id="regist_password" tabindex="2" />
                            <label>昵称:</label> <input type="text" value=""
                            id="regist_nickname" tabindex="3" /></td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="modal-footer">
            <button id="confirm-regist-confirmButton" class="btn btn-primary"
                onclick="regist()">完成</button>
            <button id="confirm-regist-cancelButton" class="btn"
                onclick="showlogin()">返回</button>
        </div>
    </div>

    <div id="waitLoginmodal" class="modal hide" data-backdrop="static">
        <img src="static/img/waitting.gif">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;正在努力加载中...</img>
    </div>
    <div class="content" id="content" style="display: none">
        <div class="leftcontact" id="leftcontact">
            <div id="headerimg" class="leftheader">
                <span> <img src="static/img/head/header2.jpg" alt="logo"
                    class="img-circle" width="60px" height="60px"
                    style="margin-top: -40px; margin-left: 20px" /></span> <span
                    id="login_user" class="login_user_title"> <a
                    class="leftheader-font" href="#"></a>
                </span> <span>
                    <div class="btn-group" style="margin-left: 5px;">
                        <button class="btn btn-inverse dropdown-toggle" data-toggle="dropdown">
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="javascript:;" onclick="showAddFriend()">添加好友</a></li>
                            <li><a href="javascript:;" onclick="showDelFriend()">删除好友</a></li>
                            <li class="divider"></li>
                            <li><a href="javascript:;" onclick="logout();return false;">退出</a></li>
                        </ul>
                    </div>
                </span>
            </div>
            <div id="leftmiddle">
                <!--
                <input style="width: 120px; color: #999999; margin-top: 8px;"
                    type="text" id="searchfriend" value="搜索"
                    onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                    onBlur="if(!value){value=defaultValue;this.style.color='#999'}" />
                <button id="searchFriend" style="background: #cccccc">查询</button>
            -->
            </div>
            <div id="contractlist11"
                style="height: 492px; overflow-y: auto; overflow-x: auto;">
                <div class="accordion" id="accordionDiv">
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a id="accordion1" class="accordion-toggle" data-toggle="collapse" data-parent="#accordionDiv" href="#collapseOne">我的好友 </a>
                        </div>
                        <div id="collapseOne" class="accordion-body collapse in">
                            <div class="accordion-inner" id="contractlist">
                                <ul id="contactlistUL" class="chat03_content_ul"></ul>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a id="accordion2" class="accordion-toggle collapsed"
                                data-toggle="collapse" data-parent="#accordionDiv"
                                href="#collapseTwo">我的群组</a>
                        </div>
                        <div id="collapseTwo" class="accordion-body collapse">
                            <div class="accordion-inner" id="contracgrouplist">
                                <ul id="contracgrouplistUL" class="chat03_content_ul"></ul>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-group">
                        <div class="accordion-heading">
                            <a id="accordion3" class="accordion-toggle collapsed"
                                data-toggle="collapse" data-parent="#accordionDiv"
                                href="#collapseThree">陌生人</a>
                        </div>
                        <div id="collapseThree" class="accordion-body collapse">
                            <div class="accordion-inner" id="momogrouplist">
                                <ul id="momogrouplistUL" class="chat03_content_ul"></ul>
                            </div>
                        </div>
                    </div>
					<div id='em-cr' class="accordion-group">
                        <div class="accordion-heading">
                            <a id="accordion4" class="accordion-toggle collapsed"
                                data-toggle="collapse" data-parent="#accordionDiv"
                                href="#collapseFour">聊天室</a>
                        </div>
                        <div id="collapseFour" class="accordion-body collapse">
                            <div class="accordion-inner" id="chatRoomList">
                                <ul id="chatRoomListUL" class="chat03_content_ul"></ul>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <div id="rightTop" style="height: 78px;"></div>
        <!-- 聊天页面 -->
        <div class="chatRight">
            <div id="chat01">
                <div class="chat01_title">
                    <ul class="talkTo">
                        <li id="talkTo"><a href="#"></a></li>
                        <li id="recycle" style="float: right;"><img
                            src="static/img/recycle.png" onclick="clearCurrentChat();"
                            style="margin-right: 15px; cursor: hand; width: 18px;" title="清屏" /></li>
                        <li id="roomInfo" style="float: right;"><img
                            id="roomMemberImg"
                            src="static/img/head/find_more_friend_addfriend_icon.png"
                            onclick="showRoomMember();"
                            style="margin-right: 15px; cursor: hand; width: 18px; display: none"
                            title="成员" /></li>
                    </ul>
                </div>
                <div id="null-nouser" class="chat01_content"></div>
            </div>

            <div class="chat02">
                <div class="chat02_title">
                    <a class="chat02_title_btn ctb01" onclick="showEmotionDialog()" title="选择表情"></a>
					<input id='sendPicInput' style='display:none'/>
					<a class="chat02_title_btn ctb03" title="选择图片" onclick="send()" type='img' href="#"></a>
					<input id='sendAudioInput' style='display:none'/>
					<a class="chat02_title_btn ctb02" title="选择语音" onclick="send()" href="#" type='audio'></a>
					<!--<input id='sendFileInput' class='emim-hide'/>
					<a class="chat02_title_btn ctb04" title="选择文件" onclick="send()" href="#"></a>-->
					<label id="chat02_title_t"></label>
                    <div id="wl_faces_box" class="wl_faces_box">
                        <div class="wl_faces_content">
                            <div class="title">
                                <ul>
                                    <li class="title_name">常用表情</li>
                                    <li class="wl_faces_close"><span
                                        onclick='turnoffFaces_box()'>&nbsp;</span></li>
                                </ul>
                            </div>
                            <div id="wl_faces_main" class="wl_faces_main">
                                <ul id="emotionUL">
                                </ul>
                            </div>
                        </div>
                        <div class="wlf_icon"></div>
                    </div>
                </div>
                <div id="input_content" class="chat02_content">
                    <textarea id="talkInputId" style="resize: none;"></textarea>
                </div>
                <div class="chat02_bar">
                    <ul>
                        <li style="right: 5px; top: 5px;"><img src="static/img/send_btn.jpg"
                            onclick="sendText()" /></li>
                    </ul>
                </div>

                <div style="clear: both;"></div>
            </div>
        </div>

        <div id="addFridentModal" class="modal hide" role="dialog"
            aria-hidden="true" data-backdrop="static">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                    aria-hidden="true">&times;</button>
                <h3>添加好友</h3>
            </div>
            <div class="modal-body">
                <input id="addfridentId" onfocus='clearInputValue("addfridentId")' />
                <div id="add-frident-warning"></div>
            </div>
            <div class="modal-footer">
                <button id="addFridend" class="btn btn-primary"
                    onclick="startAddFriend()">添加</button>
                <button id="cancelAddFridend" class="btn" data-dismiss="modal">取消</button>
            </div>
        </div>

        <div id="delFridentModal" class="modal hide" role="dialog"
            aria-hidden="true" data-backdrop="static">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                    aria-hidden="true">&times;</button>
                <h3>删除好友</h3>
            </div>
            <div class="modal-body">
                <input id="delfridentId" onfocus='clearInputValue("delfridentId")' />
                <div id="del-frident-warning"></div>
            </div>
            <div class="modal-footer">
                <button id="delFridend" class="btn btn-primary"
                    onclick="directDelFriend()">删除</button>
                <button id="canceldelFridend" class="btn" data-dismiss="modal">取消</button>
            </div>
        </div>

        <!-- 一般消息通知 -->
        <div id="notice-block-div" class="modal hide">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <div class="modal-body">
                <h4>Warning!</h4>
                <div id="notice-block-body"></div>
            </div>
        </div>

        <!-- 确认消息通知 -->
        <div id="confirm-block-div-modal" class="modal hide"
            role="dialog" aria-hidden="true" data-backdrop="static">
            <div class="modal-header">
                <h3>订阅通知</h3>
            </div>
            <div class="modal-body">
                <div id="confirm-block-footer-body"></div>
            </div>
            <div class="modal-footer">
                <button id="confirm-block-footer-confirmButton"
                    class="btn btn-primary">同意</button>
                <button id="confirm-block-footer-cancelButton" class="btn"
                    data-dismiss="modal">拒绝</button>
            </div>
        </div>

        <!-- 群组成员操作界面 -->
        <div id="option-room-div-modal" class="alert modal hide"
            role="dialog" aria-hidden="true" data-backdrop="static">
            <button type="button" class="close" data-dismiss="modal"
                aria-hidden="true">&times;</button>
            <div class="modal-header">
                <h3>成员</h3>
            </div>
            <div class="modal-body">
                <div id="room-member-list" style="height: 100px; overflow-y: auto"></div>
            </div>
        </div>
    </div>
	<input type='file' id="fileInput" style='display:none;'/>
	<div id='alert' class='em-alert' style='display:none;'><span></span><button>好的</button></div>
	<script src="static/js/webim.js"></script>
 </body>
</html>
