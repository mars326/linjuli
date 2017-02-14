package com.linjuli.model.web;

import java.io.Serializable;

/**
 * 楼管
 * @author mars3
 *
 */
public class Louguan implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -8474883017137208607L;
	//	id         int(10) unsigned  	主键        
//	cid        int(10) unsigned  	所属小区  
//	username   varchar(40)       	用户名     
//	email      varchar(60)       	用户名     
//	picurl     varchar(140)      	头像        
//	tel        varchar(140)      	电话        
//	openid     varchar(140)      	用户openid  
//	address    varchar(140)      	地址        
//	addtime    int(10) unsigned  	添加时间  
//	content    text              	描述        
//	status     tinyint(4)        	状态        
//	jobnumber  varchar(50)       	
	private int id;
	private int cid;
	private String username;
	private String email;
	private String picurl;
	private String tel;
	private String openid;
	private String address;
	private int addtime;
	private String content;
	private int status;
	private String jobnumber;
	
	public Louguan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Louguan(int id, int cid, String username, String email, String picurl, String tel, String openid,
			String address, int addtime, String content, int status, String jobnumber) {
		super();
		this.id = id;
		this.cid = cid;
		this.username = username;
		this.email = email;
		this.picurl = picurl;
		this.tel = tel;
		this.openid = openid;
		this.address = address;
		this.addtime = addtime;
		this.content = content;
		this.status = status;
		this.jobnumber = jobnumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAddtime() {
		return addtime;
	}

	public void setAddtime(int addtime) {
		this.addtime = addtime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getJobnumber() {
		return jobnumber;
	}

	public void setJobnumber(String jobnumber) {
		this.jobnumber = jobnumber;
	}

	@Override
	public String toString() {
		return "Louguan [id=" + id + ", cid=" + cid + ", username=" + username + ", email=" + email + ", picurl="
				+ picurl + ", tel=" + tel + ", openid=" + openid + ", address=" + address + ", addtime=" + addtime
				+ ", content=" + content + ", status=" + status + ", jobnumber=" + jobnumber + "]";
	}
	
}
