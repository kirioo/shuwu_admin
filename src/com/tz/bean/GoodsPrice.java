package com.tz.bean;

import java.math.BigDecimal;

public class GoodsPrice {
	private int id;
	private String goodsId;//商品ID
	private int element1;// 尺寸
	private String size;
	private int element2;// 颜色
	private String color;
	private int element3;// 待定的价格元素
	private BigDecimal price;// 价格
	private int state;// 状态
	private int stock;// 库存

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(String goodsId) {
		this.goodsId = goodsId;
	}

	public int getElement1() {
		return element1;
	}

	public void setElement1(int element1) {
		this.element1 = element1;
	}

	public int getElement2() {
		return element2;
	}

	public void setElement2(int element2) {
		this.element2 = element2;
	}

	public int getElement3() {
		return element3;
	}

	public void setElement3(int element3) {
		this.element3 = element3;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	
}
