/**
 * 玛丽猫系统平台
 * moonvip
 * com.tz.bean
 * Order.java
 * 创建人:落落 
 * 时间：2016年03月17日 15:52:15
 * 2016Nq公司-版权所有
 */
package com.tz.bean;

import java.util.Date;

/**
 * 订单管理 Order 
 * 创建人:落落
 * 时间：2016年03月17日 15:52:15 
 * qq：96508097 
 * email：96508097@qq.com
 * 
 * @version 1.0.0
 * 
 */
public class Order implements java.io.Serializable {

	private String id;/* 主键 */
	private String userId;// 用户ID
	private String goodId;// 商品ID
	private String addressId;// 收货地址ID
	private Integer distributionMode;// 配送方式（1商家配送）
	private String supplement;// 留言
	private Date placeOrderTime;// 下单时间
	private Date payTime;// 支付时间
	private Date receivingConfirmationTime;// 确认收货时间
	private Date applicationReturnsTime;// 申请退货时间
	private Date cancelTime;// 取消订单时间
	private Date refundTime;// 退款时间
	private Double perPrice;// 单件价格
	private Integer number; // 商品数量
	private Double total; // 总价
	private String priceElement1;// 价格因素1
	private String priceElement2;// 价格因素2
	// 订单状态0已删除且管理平台也不可见；1待付款；2待发货；3已发货；4已收货；5已申请退款；6确认退款；7退款驳回；8退款完成；9已取消同删除
	private Integer state;
	private Double postage; // 邮费
	private String nickname;//买家名称
	private String title;//商品名称
	private String detailAddress;//收货地址
	
	public Order() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public Integer getDistributionMode() {
		return distributionMode;
	}

	public void setDistributionMode(Integer distributionMode) {
		this.distributionMode = distributionMode;
	}

	public String getSupplement() {
		return supplement;
	}

	public void setSupplement(String supplement) {
		this.supplement = supplement;
	}

	public Date getPlaceOrderTime() {
		return placeOrderTime;
	}

	public void setPlaceOrderTime(Date placeOrderTime) {
		this.placeOrderTime = placeOrderTime;
	}

	public Date getPayTime() {
		return payTime;
	}

	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}

	public Date getReceivingConfirmationTime() {
		return receivingConfirmationTime;
	}

	public void setReceivingConfirmationTime(Date receivingConfirmationTime) {
		this.receivingConfirmationTime = receivingConfirmationTime;
	}

	public Date getApplicationReturnsTime() {
		return applicationReturnsTime;
	}

	public void setApplicationReturnsTime(Date applicationReturnsTime) {
		this.applicationReturnsTime = applicationReturnsTime;
	}

	public Date getCancelTime() {
		return cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public Date getRefundTime() {
		return refundTime;
	}

	public void setRefundTime(Date refundTime) {
		this.refundTime = refundTime;
	}

	public Double getPerPrice() {
		return perPrice;
	}

	public void setPerPrice(Double perPrice) {
		this.perPrice = perPrice;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getPriceElement1() {
		return priceElement1;
	}

	public void setPriceElement1(String priceElement1) {
		this.priceElement1 = priceElement1;
	}

	public String getPriceElement2() {
		return priceElement2;
	}

	public void setPriceElement2(String priceElement2) {
		this.priceElement2 = priceElement2;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Double getPostage() {
		return postage;
	}

	public void setPostage(Double postage) {
		this.postage = postage;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
}
