package com.linjuli.service;

/**
 * @author mars3
 * 验证手机
 */
public interface TelService {

	/**
	 * 向指定手机号发送验证码
	 * @param tel 手机号
	 * @return 验证码   1为发送失败
	 */
	int sendTel(String tel);
	
	boolean checkTel(String tel,String checkCode);

}
