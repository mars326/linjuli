package com.linjuli.model.web;

import java.io.Serializable;
/**
 * 单元
 * @author mars3
 *
 */
public class Room implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -4552161053611802595L;
	//	id       int(10) unsigned  主键        
//	cid      int(10) unsigned  所属小区  
//	dong     int(10) unsigned  所属楼栋  
//	room     int(10) unsigned  所属单元  
//	openid   varchar(140)      用户openid  
//	addtime  int(10) unsigned  添加时间  
//	content  text              描述      
	private int id;
	private int cid;
	private int dong;
	private int room;
	private String openid;
	private int addtime;
	private String content;
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Room(int id, int cid, int dong, int room, String openid, int addtime, String content) {
		super();
		this.id = id;
		this.cid = cid;
		this.dong = dong;
		this.room = room;
		this.openid = openid;
		this.addtime = addtime;
		this.content = content;
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
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
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
	@Override
	public String toString() {
		return "Room [id=" + id + ", cid=" + cid + ", dong=" + dong + ", room=" + room + ", openid=" + openid
				+ ", addtime=" + addtime + ", content=" + content + "]";
	}
	
}
