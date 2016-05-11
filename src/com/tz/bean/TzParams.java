/**
 * tzdesk系统平台
 * moonvip_admin
 * com.tz.dao
 * TzParams.java
 * 创建人:xuchengfei 
 * 时间：2015年11月24日-上午12:42:33 
 * 2015潭州教育公司-版权所有
 */
package com.tz.bean;



/**
 * 
 * TzParams 创建人:luochenxi 时间：2015年11月24日-上午12:42:33
 * 
 * @version 1.0.0
 * 
 */
public class TzParams {

	private String id;
	private String username;
	private String account;
	private Integer channelId;
	private String keyword;
	private String password;
	private Integer isDelete;
	private Integer pageNo = 0;
	private Integer pageSize = 10;
	private Integer totalCount = 0;
	private String order ;
	private Integer year;
	private Integer month;
	private Integer day;
	private Integer hour;
	private String date;
	private Integer roleId;
	private Integer mark;
	private Integer state1;
	private String shopId;
	private String idStr;
	private String YearMonth;
	private String email;//
	
	

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//		this.date = format.format(date);
		this.date = date;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getHour() {
		return hour;
	}

	public void setHour(Integer hour) {
		this.hour = hour;
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPageNo() {
		return pageNo;
	}

	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Integer getState() {
		return state1;
	}

	public void setState(Integer state) {
		this.state1 = state;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getIdStr() {
		return idStr;
	}

	public void setIdStr(String idStr) {
		this.idStr = idStr;
	}

	public String getYearMonth() {
		return YearMonth;
	}

	public void setYearMonth(String yearMonth) {
		YearMonth = yearMonth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
		
}
