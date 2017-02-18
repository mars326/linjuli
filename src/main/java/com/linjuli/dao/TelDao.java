package com.linjuli.dao;

import com.linjuli.model.web.TelCache;

/**
 * �����ֻ���֤��
 * @author mars3
 *
 */
public interface TelDao {
	/**
	 * @param tel �ֻ���
	 * @return ��֤����Ч��
	 */
	Integer findTimeByTel(String tel);
	
	/**
	 * ��ȡ��֤��,�����ʱ���ظ�����
	 * @param tel
	 * @return ��֤��
	 */
	String findCheckCodeByTel(String tel);
	void save(TelCache telCache);
	
	void updateTime(TelCache telCache);
}
