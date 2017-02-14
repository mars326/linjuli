package com.linjuli.model.web;

import java.io.Serializable;

/**
 * С��
 * @author mars3
 *
 */
public class Community implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 8408375313261667202L;
	//	id           int(10) unsigned	����                      
//	wid          int(10) unsigned	������ҵ                
//	title        varchar(40)     	��ҵ����                
//	picurl       varchar(180)    	�绰                      
//	address      varchar(140)    	��ַ                      
//	addtime      int(10) unsigned	����ʱ��                
//	description  text            	����                      
//	username     varchar(40)     	 �û���                   
//	password     varchar(40)     	����                      
//	verify       varchar(40)     	 �����                   
//	support      varchar(40)     	��ҵ������             
//	tel          varchar(140)    	�绰                      
//	status       tinyint(4)      	�û�״̬,1��ֹ��½  
//	openid       varchar(80)     	
	private int id;
	private int wid;
	private String title;
	private String address;
	private int addtime;
	private String description;
	private String username;
	private String password;
	private String verify;
	private String support;
	private String tel;
	private int status;
	private String openid;
	public Community() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Community(int id, int wid, String title, String address, int addtime, String description, String username,
			String password, String verify, String support, String tel, int status, String openid) {
		super();
		this.id = id;
		this.wid = wid;
		this.title = title;
		this.address = address;
		this.addtime = addtime;
		this.description = description;
		this.username = username;
		this.password = password;
		this.verify = verify;
		this.support = support;
		this.tel = tel;
		this.status = status;
		this.openid = openid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getVerify() {
		return verify;
	}
	public void setVerify(String verify) {
		this.verify = verify;
	}
	public String getSupport() {
		return support;
	}
	public void setSupport(String support) {
		this.support = support;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	@Override
	public String toString() {
		return "Community [id=" + id + ", wid=" + wid + ", title=" + title + ", address=" + address + ", addtime="
				+ addtime + ", description=" + description + ", username=" + username + ", password=" + password
				+ ", verify=" + verify + ", support=" + support + ", tel=" + tel + ", status=" + status + ", openid="
				+ openid + "]";
	}
	
	
}
