package com.linjuli.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linjuli.model.weixin.pojo.SNSUserInfo;
import com.linjuli.model.weixin.pojo.SNSUserInfo2;
import com.linjuli.model.weixin.pojo.WeixinOauth2Token;

/**
 * 处理授权,授权通过后,获得微信用户信息
 * @author mars3
 *
 */
public class OauthUtil {
	/**
	 * 未关注公众号,网页授权
	 * @param req
	 * @param res
	 * @return
	 */
	public static SNSUserInfo oauthCheck(HttpServletRequest req,HttpServletResponse res){
		// 用户同意授权后，能获取到code
		String code = req.getParameter("code");
		String state = req.getParameter("state");

		// 用户不同意授权
		if (code == null || code == "") {	
			return null;
		}
		// 获取网页授权access_token
		WeixinOauth2Token weixinOauth2Token = WeixinUtil.getOauth2AccessToken(CommonUtil.appID, CommonUtil.appsecret, code);
		// 网页授权接口访问凭证
		String accessToken = weixinOauth2Token.getAccessToken();
		// 用户标识
		String openId = weixinOauth2Token.getOpenId();
		// 获取用户信息
		SNSUserInfo snsUserInfo = WeixinUtil.getSNSUserInfo(accessToken, openId);
		Cookie cookie = new Cookie("openid", openId);
		cookie.setPath("/");
		res.addCookie(cookie);
		return snsUserInfo;
	}
	/**
	 * 已关注公众号,静默授权
	 * @param req
	 * @param res
	 * @param accessToken
	 * @return
	 */
	public static SNSUserInfo2 oauthCheck(HttpServletRequest req,HttpServletResponse res,String accessToken){
		// 用户同意授权后，能获取到code
		String code = req.getParameter("code");
		String state = req.getParameter("state");

		// 用户不同意授权
		if (code == null || code == "") {	
			return null;
		}
		// 获取网页授权access_token
		WeixinOauth2Token weixinOauth2Token = WeixinUtil.getOauth2AccessToken(CommonUtil.appID, CommonUtil.appsecret, code);
		// 网页授权接口访问凭证
		//String accessToken = weixinOauth2Token.getAccessToken();
		// 用户标识
		String openId = weixinOauth2Token.getOpenId();
		// 获取用户信息
		SNSUserInfo2 snsUserInfo = WeixinUtil.getSNSUserInfo2(accessToken, openId);
		Cookie cookie = new Cookie("openid", openId);
		cookie.setPath("/");
		res.addCookie(cookie);
		return snsUserInfo;
	}
}
