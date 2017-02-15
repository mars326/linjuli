package com.linjuli.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.linjuli.dao.UserDao;
import com.linjuli.model.web.User;
import com.linjuli.service.UserService;

public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	
	public User findUserByOpenid(String openid) {
		// TODO Auto-generated method stub
		return null;
	}

	public User createUser(HttpServletRequest req) {
		String openid = req.getParameter("");
		String nickname = req.getParameter("");
		String username = req.getParameter("");
		String province = req.getParameter("");
		String city = req.getParameter("");
		String headimgurl = req.getParameter("");
		String address = req.getParameter("");
		String language = req.getParameter("");
		int addtime = (int)(System.currentTimeMillis()/1000);
		int uptime = (int)(System.currentTimeMillis()/1000);
		int cid = Integer.valueOf(req.getParameter(""));
		int jifen = Integer.valueOf(req.getParameter(""));
		int dakatime = 0;
		String tel = req.getParameter("");
		int teltime = (int)(System.currentTimeMillis()/1000);
		int dong = Integer.valueOf(req.getParameter(""));
		int unit = Integer.valueOf(req.getParameter(""));
		int room = Integer.valueOf(req.getParameter(""));
		int sex = Integer.valueOf(req.getParameter(""));
		int isset = Integer.valueOf(req.getParameter(""));
		int iscid = Integer.valueOf(req.getParameter(""));
		int guanzhu = Integer.valueOf(req.getParameter(""));
		
		/**
		 * 
		 * 
		 * 
		 * ²ÎÊý¼ì²é
		 */
		
		User user = new User();
		user.setOpenid(openid);
		user.setNickname(nickname);
		user.setUsername(username);
		user.setProvince(province);
		user.setCity(city);
		user.setHeadimgurl(headimgurl);
		user.setAddress(address);
		user.setLanguage(language);
		user.setAddtime(addtime);
		user.setUptime(uptime);
		user.setCid(cid);
		user.setJifen(jifen);
		user.setDakatime(dakatime);
		user.setTel(tel);
		user.setTeltime(teltime);
		user.setDong(dong);
		user.setUnit(unit);
		user.setRoom(room);
		user.setSex(sex);
		user.setIsset(isset);
		user.setIscid(iscid);
		user.setGuanzhu(guanzhu);
		
		userDao.createUser(user);
		return user;
	}

}
