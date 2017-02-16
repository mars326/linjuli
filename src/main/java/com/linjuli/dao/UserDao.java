package com.linjuli.dao;

import com.linjuli.model.web.User;

/**
 * @author mars3
 * �������ݿ⴦���û���Ϣ
 */
public interface UserDao {
	void createUser(User user);
	void updateUser(User user);
	User findUserByOpenId(String openid);
}
