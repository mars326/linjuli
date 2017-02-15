package com.linjuli.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author mars3
 * 处理微信发来的信息
 */
public interface WeixinService {
	String processRequest(HttpServletRequest request);
}
