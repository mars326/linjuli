package com.linjuli.service;

import javax.servlet.http.HttpServletRequest;

import com.linjuli.model.web.User;

/**
 * @author mars3
 * 处理用户的增删改查
 */
public interface UserService {
	User findUserByOpenid(String openid);
	User createUser(HttpServletRequest req);
}
