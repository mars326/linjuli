package com.linjuli.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linjuli.model.weixin.pojo.SNSUserInfo;
import com.linjuli.model.weixin.pojo.SNSUserInfo2;
import com.linjuli.model.weixin.pojo.WeixinOauth2Token;

/**
 * ������Ȩ,��Ȩͨ����,���΢���û���Ϣ
 * @author mars3
 *
 */
public class OauthUtil {
	/**
	 * δ��ע���ں�,��ҳ��Ȩ
	 * @param req
	 * @param res
	 * @return
	 */
	public static SNSUserInfo oauthCheck(HttpServletRequest req,HttpServletResponse res){
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
	/**
	 * �ѹ�ע���ں�,��Ĭ��Ȩ
	 * @param req
	 * @param res
	 * @param accessToken
	 * @return
	 */
	public static SNSUserInfo2 oauthCheck(HttpServletRequest req,HttpServletResponse res,String accessToken){
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
		//String accessToken = weixinOauth2Token.getAccessToken();
		// �û���ʶ
		String openId = weixinOauth2Token.getOpenId();
		// ��ȡ�û���Ϣ
		SNSUserInfo2 snsUserInfo = WeixinUtil.getSNSUserInfo2(accessToken, openId);
		Cookie cookie = new Cookie("openid", openId);
		cookie.setPath("/");
		res.addCookie(cookie);
		return snsUserInfo;
	}
}
