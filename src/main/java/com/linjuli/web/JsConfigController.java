package com.linjuli.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linjuli.util.JsonResult;
import com.linjuli.util.WeixinUtil;

@Controller
public class JsConfigController {
	@RequestMapping("jsConfig.do")
	@ResponseBody
	public JsonResult<Map> jsConfig(HttpServletRequest req,HttpServletResponse res){
		Map<String, Object> jsConfig = WeixinUtil.getWxConfig(req);
		return new JsonResult<Map>(jsConfig);
	}
}
