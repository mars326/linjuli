package com.linjuli.model.web;

import java.io.Serializable;
/**
 * 用户实体类
 * @author mars3
 *
 */
public class User implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = -4415938915475693888L;
//	id          int(10)       ID                     
//	openid      char(55)      openid                 
//	nickname    varchar(60)   微信网名           
//	username    varchar(60)   真实姓名           
//	province    varchar(60)   地区                 
//	city        varchar(50)   城市                 
//	headimgurl  varchar(200)  头像                 
//	address     varchar(120)  地址                 
//	language    varchar(50)   客户端语言        
//	addtime     int(15)       添加日期           
//	uptime      int(15)       更新日期           
//	cid         int(15)       所入住小区        
//	jifen       int(15)       积分                 
//	dakatime    int(15)       最后打卡时间     
//	tel         varchar(50)   手机号              
//	teltime     int(15)       手机验证时间     
//	dong        int(15)       栋                    
//	unit        int(15)       单元                 
//	room        int(15)       房间号              
//	sex         tinyint(4)    性别                 
//	isset       tinyint(4)    是否是授权过的  
//	iscid       tinyint(4)    社区物管,1是      
//	guanzhu     int(11)       
	private int id;
	private String openid;
	private String nickname;
	private String username;
	private String province;
	private String city;
	private String headimgurl;
	private String address;
	private String language;
	private int addtime;
	private int uptime;
	private int cid;
	private int jifen;
	private int dakatime;
	private String tel;
	private int teltime;
	private int dong;
	private int unit;
	private int room;
	private int sex;
	private int isset;
	private int iscid;
	private int guanzhu;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String openid, String nickname, String username, String province, String city,
			String headimgurl, String address, String language, int addtime, int uptime, int cid, int jifen,
			int dakatime, String tel, int teltime, int dong, int room, int unit, int sex, int isset, int iscid,
			int guanzhu) {
		super();
		this.id = id;
		this.openid = openid;
		this.nickname = nickname;
		this.username = username;
		this.province = province;
		this.city = city;
		this.headimgurl = headimgurl;
		this.address = address;
		this.language = language;
		this.addtime = addtime;
		this.uptime = uptime;
		this.cid = cid;
		this.jifen = jifen;
		this.dakatime = dakatime;
		this.tel = tel;
		this.teltime = teltime;
		this.dong = dong;
		this.room = room;
		this.unit = unit;
		this.sex = sex;
		this.isset = isset;
		this.iscid = iscid;
		this.guanzhu = guanzhu;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getAddtime() {
		return addtime;
	}
	public void setAddtime(int addtime) {
		this.addtime = addtime;
	}
	public int getUptime() {
		return uptime;
	}
	public void setUptime(int uptime) {
		this.uptime = uptime;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getJifen() {
		return jifen;
	}
	public void setJifen(int jifen) {
		this.jifen = jifen;
	}
	public int getDakatime() {
		return dakatime;
	}
	public void setDakatime(int dakatime) {
		this.dakatime = dakatime;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getTeltime() {
		return teltime;
	}
	public void setTeltime(int teltime) {
		this.teltime = teltime;
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
	public int getUnit() {
		return unit;
	}
	public void setUnit(int unit) {
		this.unit = unit;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getIsset() {
		return isset;
	}
	public void setIsset(int isset) {
		this.isset = isset;
	}
	public int getIscid() {
		return iscid;
	}
	public void setIscid(int iscid) {
		this.iscid = iscid;
	}
	public int getGuanzhu() {
		return guanzhu;
	}
	public void setGuanzhu(int guanzhu) {
		this.guanzhu = guanzhu;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", openid=" + openid + ", nickname=" + nickname + ", username=" + username
				+ ", province=" + province + ", city=" + city + ", headimgurl=" + headimgurl + ", address=" + address
				+ ", language=" + language + ", addtime=" + addtime + ", uptime=" + uptime + ", cid=" + cid + ", jifen="
				+ jifen + ", dakatime=" + dakatime + ", tel=" + tel + ", teltime=" + teltime + ", dong=" + dong
				+ ", room=" + room + ", unit=" + unit + ", sex=" + sex + ", isset=" + isset + ", iscid=" + iscid
				+ ", guanzhu=" + guanzhu + "]";
	}
	
	

}
