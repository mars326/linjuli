package com.linjuli.dao;

/**
 * ��ѯwechat_community
 * @author mars3
 *
 */
public interface CommunityDao {
	
	/**
	 * У���û��Ƿ�Ϊ�������
	 * @param openid
	 * @return
	 */
	int findCidByOpenid(String openid); 
}
