/**
 * 树屋系统平台
 * moonvip
 * com.tz.model
 * Content.java
 * 创建人:Kirio 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.bean;

import java.util.Date;

/**
 * 活动管理
 * Event 
 * 创建人:Kirio
 * 时间：2016年04月29日 16:26:10
 * qq：96508097
 * email：96508097@qq.com
 * @version 1.0.0
 * 
 */
public class Event implements java.io.Serializable {

	private String id;/* 主键 */
	private String autor;//名称
	private Integer autorId;//发布者ID
	private String title;//标题
	private String content;//内容
	private Date createTime;// 创建时间
	private Date updateTime;// 创建时间
	private Integer userId;// 用户ID
	private Integer isDelete;// 0删除1未删除
	private Integer status;// 0未发布1发布
	private String img;//图片
	private String userName;//姓名
	private String phone;//电话
	private Integer male;//性别
	private Integer age;//年龄
	public Event(){
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Integer getMale() {
		return male;
	}

	public void setMale(Integer male) {
		this.male = male;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}
	
}
