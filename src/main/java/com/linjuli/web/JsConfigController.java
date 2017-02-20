package com.linjuli.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linjuli.model.weixin.pojo.JsConfig;
import com.linjuli.util.JsonResult;
import com.linjuli.util.WeixinUtil;

@Controller
public class JsConfigController {
	@RequestMapping("/jsConfig.do")
	@ResponseBody
	public JsonResult<JsConfig> getJsConfig(HttpServletRequest req,HttpServletResponse res){
		JsConfig jsConfig = WeixinUtil.getWxConfig(req);
		return new JsonResult<JsConfig>(jsConfig);
	}
	
}
