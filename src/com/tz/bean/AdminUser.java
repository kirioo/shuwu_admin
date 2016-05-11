/**
 * Project Name:tzupload
 * File Name:User.java
 * Package Name:bean
 * Date:2015年11月6日下午9:04:29
 * Copyright (c) 2015, chenzhou1025@126.com All Rights Reserved.
 *
 */

package com.tz.bean;

import java.util.Date;

/**
 * ClassName:User <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason: TODO ADD REASON. <br/>
 * Date: 2015年11月6日 下午9:04:29 <br/>
 * 
 * @author Administrator
 * @version
 * @since JDK 1.6
 * @see
 */
public class AdminUser implements java.io.Serializable {

	// 主键
	private String id;
	// 用户名称
	private String username;
	// 密码
	private String password;
	// 邮箱
	private String email;
	// 年龄
	private Integer age;
	// 1男0女2保密
	private Integer male;
	// 地址
	private String address;
	// 手机
	private String phone;
	// 0未删除1删除
	private Integer isDelete;
	// 创建时间
	private Date createTime;
	// 更新时间
	private Date updateTime;
	// 生日
	private String birthday;
	// 0不允许登陆1允许登陆
	private Integer forbiden;
	//位置
	private String position;
	//邮编
	private String districtCode;	
	//推送Id
	private String pushToken;
	
	public AdminUser(){
		super();
	}
	
	/**
	 * 
	 * 创建一个新的实例 AdminUser.
	 * @param id
	 * @param username
	 * @param password
	 * @param email
	 * @param age
	 * @param male
	 * @param address
	 * @param phone
	 * @param state
	 * @param createTime
	 * @param updateTime
	 * @param birthday
	 * @param forbiden
	 * @param position
	 * @param districtCode
	 */
	public AdminUser(String id, String username, String password, String email,
			Integer age, Integer male, String address, String phone,
			Integer state, Date createTime, Date updateTime, String birthday,
			Integer forbiden, String position, String districtCode) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.age = age;
		this.male = male;
		this.address = address;
		this.phone = phone;
		this.isDelete = isDelete;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.birthday = birthday;
		this.forbiden = forbiden;
		this.position = position;
		this.districtCode = districtCode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getMale() {
		return male;
	}

	public void setMale(Integer male) {
		this.male = male;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String string) {
		this.birthday = string;
	}

	public Integer getForbiden() {
		return forbiden;
	}

	public void setForbiden(Integer forbiden) {
		this.forbiden = forbiden;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getPushToken() {
		return pushToken;
	}

	public void setPushToken(String pushToken) {
		this.pushToken = pushToken;
	}
	
	
}
