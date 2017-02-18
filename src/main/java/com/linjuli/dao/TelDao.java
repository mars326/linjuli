package com.linjuli.dao;

import com.linjuli.model.web.TelCache;

/**
 * 缓存手机验证码
 * @author mars3
 *
 */
public interface TelDao {
	/**
	 * @param tel 手机号
	 * @return 验证码有效期
	 */
	Integer findTimeByTel(String tel);
	
	/**
	 * 获取验证码,避免短时间重复发送
	 * @param tel
	 * @return 验证码
	 */
	String findCheckCodeByTel(String tel);
	void save(TelCache telCache);
	
	void updateTime(TelCache telCache);
}
