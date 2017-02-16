package com.linjuli.service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linjuli.model.weixin.pojo.SNSUserInfo;

public interface OauthService {
	SNSUserInfo oauthCheck(HttpServletRequest req,HttpServletResponse res);
}
