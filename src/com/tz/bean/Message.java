/**
 * 玛丽猫系统平台
 * moonvip
 * com.tz.bean
 * Message.java
 * 创建人:落落 
 * 时间：2016年03月21日 14:07:49
 * 2016Nq公司-版权所有
 */
package com.tz.bean;

import java.util.Date;

/**
 * 消息管理
 * Message 
 * 创建人:落落
 * 时间：2016年03月21日 14:07:49
 * qq：96508097
 * email：96508097@qq.com
 * @version 1.0.0
 * 
 */
public class Message implements java.io.Serializable {

	private String id;/* 主键 */
	private String avatar;//头像
	private Date publishTime;// 创建时间
	private String nickname;// 创建时间
	private String content;// 内容
	private Integer state;// 0删除 1发布 2未发布
	private String userName;//姓名
	private String phone;//电话
	private String jqId;//极光ID 
	
	public Message(){
		super();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getAvatar() {
		return avatar;
	}


	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}


	public Date getPublishTime() {
		return publishTime;
	}


	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}


	public String getNickname() {
		return nickname;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Integer getState() {
		return state;
	}


	public void setState(Integer state) {
		this.state = state;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getJqId() {
		return jqId;
	}


	public void setJqId(String jqId) {
		this.jqId = jqId;
	}
}
