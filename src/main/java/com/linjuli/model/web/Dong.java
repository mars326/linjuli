package com.linjuli.model.web;

import java.io.Serializable;

/**
 * 楼栋
 * @author mars3
 *
 */
public class Dong implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -5454281171548060580L;
	//	id       int(10) unsigned 主键        
//	cid      int(10) unsigned 所属小区  
//	dong     int(10) unsigned 所属楼栋  
//	addtime  int(10) unsigned 添加时间  
//	content  text             描述       
	private int id;
	private int cid;
	private int dong;
	private int addtime;
	private String text;
	public Dong() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Dong(int id, int cid, int dong, int addtime, String text) {
		super();
		this.id = id;
		this.cid = cid;
		this.dong = dong;
		this.addtime = addtime;
		this.text = text;
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
	public int getDong() {
		return dong;
	}
	public void setDong(int dong) {
		this.dong = dong;
	}
	public int getAddtime() {
		return addtime;
	}
	public void setAddtime(int addtime) {
		this.addtime = addtime;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Dong [id=" + id + ", cid=" + cid + ", dong=" + dong + ", addtime=" + addtime + ", text=" + text + "]";
	}
	
}
