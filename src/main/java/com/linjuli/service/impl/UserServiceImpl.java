package com.linjuli.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.linjuli.dao.CommunityDao;
import com.linjuli.dao.UserDao;
import com.linjuli.model.web.User;
import com.linjuli.model.weixin.pojo.SNSUserInfo;
import com.linjuli.service.UserService;
import com.linjuli.thread.TokenThread;
import com.linjuli.util.WeixinUtil;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource(name="userDao")
	private UserDao userDao;
	@Resource(name="communityDao")
	private CommunityDao communityDao;

	public User findUserByOpenid(String openid) {
		// TODO Auto-generated method stub
		return null;
	}

	public User createUser(String openid) {
		User user = this.createUser(openid, 0);
		return user;
	}
	
	/**
	 * 创建用户,通过微信信息
	 */
	public User createUser(String openid, int guanzhu) {

		User user = userDao.findUserByOpenId(openid);
		if(user == null){
			//获取微信用户信息
			SNSUserInfo userInfo = WeixinUtil.getSNSUserInfo(TokenThread.accessToken.getAccessToken(), openid);
			String nickname = userInfo.getNickname();
			String headimgurl = userInfo.getHeadImgUrl();
			String language = userInfo.getLanguage();
			String province = userInfo.getProvince();
			String city = userInfo.getCity();
			int sex = userInfo.getSex();
			int addtime = (int)(System.currentTimeMillis()/1000);


			int id = 0;
			user = new User(id, openid, nickname, null, province, city, headimgurl, null, language, addtime, 0, 0, 0, 0, null, 0, 0, 0, 0, sex, 0, 0,guanzhu);
			//		
			//		User user = new User();
			//		user.setOpenid(openid);
			//		user.setNickname(nickname);
			//		user.setUsername(username);
			//		user.setProvince(province);
			//		user.setCity(city);
			//		user.setHeadimgurl(headimgurl);
			//		user.setAddress(address);
			//		user.setLanguage(language);
			//		user.setAddtime(addtime);
			//		user.setUptime(uptime); 
			//		user.setCid(cid);
			//		user.setJifen(jifen);
			//		user.setDakatime(dakatime);
			//		user.setTel(tel);
			//		user.setTeltime(teltime);
			//		user.setDong(dong);
			//		user.setUnit(unit);
			//		user.setRoom(room);
			//		user.setSex(sex);
			//		user.setIsset(isset);
			//		user.setIscid(iscid);
			//		user.setGuanzhu(guanzhu);

			userDao.createUser(user);
			return user;
		}
		return user;
	}
	
	/**
	 * 更新用户信息
	 * 绑定小区等
	 */
	public User updateUser(HttpServletRequest req) {
		//获取opeid
		Cookie[] cookies = req.getCookies();
		String openid = null;
		for(Cookie cookie:cookies){
			if("openid".equals(cookie.getName())){
				openid = cookie.getValue(); 
			}
		}
		User user = userDao.findUserByOpenId(openid);
		String username = req.getParameter("username");
		String address = req.getParameter("address");
		String tel = req.getParameter("tel");
		int cid = Integer.valueOf(req.getParameter("cid"));
		int jifen = 0;
		int dong = Integer.valueOf(req.getParameter("dong"));
		int unit = Integer.valueOf(req.getParameter("unit"));
		int room = Integer.valueOf(req.getParameter("room"));
		int isset = 1;
		int iscid = 0;
		if(communityDao.findCidByOpenid(openid) != 0){
			iscid =1 ;
		}
		int uptime = (int)(System.currentTimeMillis()/1000);
		int teltime = (int)(System.currentTimeMillis()/1000);
		int dakatime = 0;
		return user;
	}

}
