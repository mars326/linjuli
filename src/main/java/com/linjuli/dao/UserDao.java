package com.linjuli.dao;

import com.linjuli.model.web.User;

/**
 * @author mars3
 * 连接数据库处理用户信息
 */
public interface UserDao {
	void createUser(User user);
	void updateUser(User user);
	User findUserByOpenId(String openid);
}
