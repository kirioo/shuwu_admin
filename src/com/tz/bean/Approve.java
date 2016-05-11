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
 * 认证管理
 * Approve 
 * 创建人:Kirio
 * 时间：2016年05月04日 11:42:26
 * qq：96508097
 * email：96508097@qq.com
 * @version 1.0.0
 * 
 */
public class Approve implements java.io.Serializable {

	private String id;/* 主键 */
	private String userName;//名称
	private Integer userId;// 用户ID
	private Integer isDelete;// 0删除1未删除
	private Integer status;// 状态 
	private Integer age;//年龄
	private String birthday;//生日
	private Date createTime;// 创建时间
	private Date updateTime;// 创建时间
	private String city;//城市
	private String phone;//电话
	private Integer sex;//性别
	private String country;//国家
	private String university;//大学
	private Integer approve;//认证状态
	private Integer tuiJian;//推荐 0未推荐 1已推荐
	private String idCard;//证件
	
	public Approve(){
		super();
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
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


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
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


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Integer getSex() {
		return sex;
	}


	public void setSex(Integer sex) {
		this.sex = sex;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getUniversity() {
		return university;
	}


	public void setUniversity(String university) {
		this.university = university;
	}


	public Integer getApprove() {
		return approve;
	}


	public void setApprove(Integer approve) {
		this.approve = approve;
	}


	public Integer getTuiJian() {
		return tuiJian;
	}


	public void setTuiJian(Integer tuiJian) {
		this.tuiJian = tuiJian;
	}


	public String getIdCard() {
		return idCard;
	}


	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}


}
