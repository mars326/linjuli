package com.linjuli.model.web;

import java.io.Serializable;

/**
 * 报修信息
 * @author mars3
 *
 */
public class Baoxiu implements Serializable{
//	id           int(10) unsigned 主键                                               
//	cid          int(10) unsigned 所属小区                                         
//	uid          int(10) unsigned 普通用户id                                       
//	lid          int(10) unsigned 对应物业的楼管                                
//	isset        int(10) unsigned 处理状态 0 未处理 1 处理中 2 处理完成  
//	tel          varchar(180)     电话                                               
//	level        tinyint(4)       星级                                               
//	content      text             报修内容                                         
//	relcontent   text             反馈内容                                         
//	picurl       text             相片                                               
//	media_id     text             media_id                                             
//	addtime      int(10) unsigned 报修时间                                         
//	chuli_time   int(10) unsigned 处理时间                                         
//	jieshu_time  int(10) unsigned 结束时间                                         
//	istype       tinyint(4)       报修类别                                        
//	isdel        tinyint(4)       状态 1删除                                       
	private int id;
	private int cid;
	private int uid;
	private int lid;
	private int isset;
	private String tel;
	private int level;
	private String content;
	private String relcontent;
	private String picurl;
	private String media_id;
	private int addtime;
	private int chuli_time;
	private int jieshu_time;
	private int istype;
	private int isdel;
	public Baoxiu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Baoxiu(int id, int cid, int uid, int lid, int isset, String tel, int level, String content,
			String relcontent, String picurl, String media_id, int addtime, int chuli_time, int jieshu_time, int istype,
			int isdel) {
		super();
		this.id = id;
		this.cid = cid;
		this.uid = uid;
		this.lid = lid;
		this.isset = isset;
		this.tel = tel;
		this.level = level;
		this.content = content;
		this.relcontent = relcontent;
		this.picurl = picurl;
		this.media_id = media_id;
		this.addtime = addtime;
		this.chuli_time = chuli_time;
		this.jieshu_time = jieshu_time;
		this.istype = istype;
		this.isdel = isdel;
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
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getLid() {
		return lid;
	}
	public void setLid(int lid) {
		this.lid = lid;
	}
	public int getIsset() {
		return isset;
	}
	public void setIsset(int isset) {
		this.isset = isset;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRelcontent() {
		return relcontent;
	}
	public void setRelcontent(String relcontent) {
		this.relcontent = relcontent;
	}
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	public String getMedia_id() {
		return media_id;
	}
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
	public int getAddtime() {
		return addtime;
	}
	public void setAddtime(int addtime) {
		this.addtime = addtime;
	}
	public int getChuli_time() {
		return chuli_time;
	}
	public void setChuli_time(int chuli_time) {
		this.chuli_time = chuli_time;
	}
	public int getJieshu_time() {
		return jieshu_time;
	}
	public void setJieshu_time(int jieshu_time) {
		this.jieshu_time = jieshu_time;
	}
	public int getIstype() {
		return istype;
	}
	public void setIstype(int istype) {
		this.istype = istype;
	}
	public int getIsdel() {
		return isdel;
	}
	public void setIsdel(int isdel) {
		this.isdel = isdel;
	}
	@Override
	public String toString() {
		return "Baoxiu [id=" + id + ", cid=" + cid + ", uid=" + uid + ", lid=" + lid + ", isset=" + isset + ", tel="
				+ tel + ", level=" + level + ", content=" + content + ", relcontent=" + relcontent + ", picurl="
				+ picurl + ", media_id=" + media_id + ", addtime=" + addtime + ", chuli_time=" + chuli_time
				+ ", jieshu_time=" + jieshu_time + ", istype=" + istype + ", isdel=" + isdel + "]";
	}
	
}
