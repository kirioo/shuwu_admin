package com.tz.bean;

public class ImBean {
	private int code;
	private String value;
	public ImBean(int code, String value){
		this.code = code;
		this.value = value;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "ImBean [code=" + code + ", value=" + value + "]";
	}
	
}
