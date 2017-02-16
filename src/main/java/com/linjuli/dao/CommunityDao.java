package com.linjuli.dao;

/**
 * 查询wechat_community
 * @author mars3
 *
 */
public interface CommunityDao {
	
	/**
	 * 校验用户是否为社区物管
	 * @param openid
	 * @return
	 */
	int findCidByOpenid(String openid); 
}
