package com.linjuli.model.web;

public class TelCache {
	private String tel;
	private String checkCode;
	private int endTime;
	public TelCache() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TelCache(String tel, String checkCode, int endTime) {
		super();
		this.tel = tel;
		this.checkCode = checkCode;
		this.endTime = endTime;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getCheckCode() {
		return checkCode;
	}
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "TelCache [tel=" + tel + ", checkCode=" + checkCode + ", endTime=" + endTime + "]";
	}
	
	
}
