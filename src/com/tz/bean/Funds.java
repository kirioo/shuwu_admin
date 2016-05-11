/**
 * 玛丽猫系统平台
 * moonvip
 * com.tz.model
 * Content.java
 * 创建人:落落 
 * 时间：2015年6月8日-下午1:13:00 
 * 2016Nq公司-版权所有
 */
package com.tz.bean;

import java.util.Date;

/**
 * 资金管理
 * Funds 
 * 创建人:落落
 * 时间：2016年03月28日 16:12:55
 * qq：96508097
 * email：96508097@qq.com
 * @version 1.0.0
 * 
 */
public class Funds implements java.io.Serializable {

	private Integer id;/* 主键 */
	private String name;//名称
	private Date createTime;// 创建时间
	private Date updateTime;// 创建时间
	private String userId;// 用户ID
	private Integer isDelete;// 0删除1未删除
	private Integer status;// 0未发布1发布
	private double income;//收入
	private double payOut;//支出
	private double gl;//总账
	
	public Funds(){
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getPayOut() {
		return payOut;
	}

	public void setPayOut(double payOut) {
		this.payOut = payOut;
	}

	public double getGl() {
		return gl;
	}

	public void setGl(double gl) {
		this.gl = gl;
	}
}
