/**
 * Tm系统平台
 * moonvip
 * com.tz.model
 * Content.java
 * 创建人:xuchengfei 
 * 时间：2015年6月8日-下午1:13:00 
 * 2015Tm公司-版权所有
 */
package com.tz.bean;

import java.util.Date;

/**
 * 
 * Content 创建人:罗晨曦 时间：2015年6月8日-下午1:13:00
 * 
 * @version 1.0.0
 * 
 */
public class Content implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String id;// 主键
	private String cover;// 封面图
	private String startPosition;// 起始地
	private String endPosition; // 终点
	private String shopkeeperId;// 商家ID
	private String title;// 商品标题
	private double originalPrice;// 原件
	private double discountedPrice;// 折扣价
	private double expressPrice;// 快递价格
	private int style; // 风格(1欧式、2韩式、3中式、4个性)
	private String unit;// 计数单位
	private int state;// 状态(0删除，1正常)
	private int goodsType;// 商品类型 1是婚纱摄影，2是蜜月旅行，3是珠宝首饰
	private int isRecommend;// 是否推荐到首页 1代表推荐，0代表不推荐
	private double maxPrice;// 最高价
	private double minPrice;// 最低价
	private String photographyType;// 婚纱摄影类型(婚礼会所)
	private Date createTime;// 创建时间
	private Date editTime;// 更新时间
	private String carousel1;// 轮播图1
	private String carousel2;// 轮播图2
	private String carousel3;// 轮播图3

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getStartPosition() {
		return startPosition;
	}

	public void setStartPosition(String startPosition) {
		this.startPosition = startPosition;
	}

	public String getEndPosition() {
		return endPosition;
	}

	public void setEndPosition(String endPosition) {
		this.endPosition = endPosition;
	}

	public String getShopkeeperId() {
		return shopkeeperId;
	}

	public void setShopkeeperId(String shopkeeperId) {
		this.shopkeeperId = shopkeeperId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(double originalPrice) {
		this.originalPrice = originalPrice;
	}

	public double getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(double discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public double getExpressPrice() {
		return expressPrice;
	}

	public void setExpressPrice(double expressPrice) {
		this.expressPrice = expressPrice;
	}

	public int getStyle() {
		return style;
	}

	public void setStyle(int style) {
		this.style = style;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(int goodsType) {
		this.goodsType = goodsType;
	}

	public int getIsRecommend() {
		return isRecommend;
	}

	public void setIsRecommend(int isRecommend) {
		this.isRecommend = isRecommend;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public String getPhotographyType() {
		return photographyType;
	}

	public void setPhotographyType(String photographyType) {
		this.photographyType = photographyType;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public String getCarousel1() {
		return carousel1;
	}

	public void setCarousel1(String carousel1) {
		this.carousel1 = carousel1;
	}

	public String getCarousel2() {
		return carousel2;
	}

	public void setCarousel2(String carousel2) {
		this.carousel2 = carousel2;
	}

	public String getCarousel3() {
		return carousel3;
	}

	public void setCarousel3(String carousel3) {
		this.carousel3 = carousel3;
	}

}