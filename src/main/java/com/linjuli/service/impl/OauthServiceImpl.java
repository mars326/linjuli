package com.linjuli.service.impl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.linjuli.model.weixin.pojo.SNSUserInfo;
import com.linjuli.model.weixin.pojo.WeixinOauth2Token;
import com.linjuli.service.OauthService;
import com.linjuli.util.CommonUtil;
import com.linjuli.util.WeixinUtil;
@Service
public class OauthServiceImpl implements OauthService {

	public SNSUserInfo oauthCheck(HttpServletRequest req,HttpServletResponse res){
		// �û�ͬ����Ȩ���ܻ�ȡ��code
		String code = req.getParameter("code");
		String state = req.getParameter("state");

		// �û���ͬ����Ȩ
		if (code == null || code == "") {	
			return null;
		}
		// ��ȡ��ҳ��Ȩaccess_token
		WeixinOauth2Token weixinOauth2Token = WeixinUtil.getOauth2AccessToken(CommonUtil.appID, CommonUtil.appsecret, code);
		// ��ҳ��Ȩ�ӿڷ���ƾ֤
		String accessToken = weixinOauth2Token.getAccessToken();
		// �û���ʶ
		String openId = weixinOauth2Token.getOpenId();
		// ��ȡ�û���Ϣ
		SNSUserInfo snsUserInfo = WeixinUtil.getSNSUserInfo(accessToken, openId);
		Cookie cookie = new Cookie("openid", openId);
		cookie.setPath("/");
		res.addCookie(cookie);
		return snsUserInfo;
	}

}
