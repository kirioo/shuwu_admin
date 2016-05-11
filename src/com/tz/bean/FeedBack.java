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
 * 意见反馈
 * FeedBack 
 * 创建人:Kirio
 * 时间：2016年05月04日 10:24:21
 * qq：96508097
 * email：96508097@qq.com
 * @version 1.0.0
 * 
 */
public class FeedBack implements java.io.Serializable {

	private String id;/* 主键 */
	private String userName;//名称
	private String content;//内容
	private Date createTime;// 创建时间
	private Date updateTime;// 更新时间
	private String userId;// 用户ID
	private Integer isDelete;// 0删除1未删除
	private Integer status;// 0未发布1发布

	
	public FeedBack(){
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
	
}
