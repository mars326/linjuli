package com.linjuli.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linjuli.model.web.Baoxiu;
import com.linjuli.model.web.User;
import com.linjuli.service.BaoxiuService;
import com.linjuli.service.UserService;
import com.linjuli.util.CommonUtil;
import com.linjuli.util.JsonResult;

@Controller
public class TestController {
	@Resource(name="baoxiuService")
	private BaoxiuService baoxiuService;
	@Resource(name="userService")
	private UserService userService;
	@RequestMapping("test.do")
	@ResponseBody
	public JsonResult<List<Baoxiu>> getImageSrc(HttpServletRequest req,HttpServletResponse res){
		String openid = CommonUtil.getCookieOpenid(req);
		if(openid == null || openid == ""){
			return new JsonResult<List<Baoxiu>>("获取cookie失败");
		}
		User user = userService.findUserByOpenid(openid);
		if(user == null){
			return new JsonResult<List<Baoxiu>>("获取user失败");
		}
		List<Baoxiu> baoxiuInfo = baoxiuService.findBaoxiuByUid(user.getId());
		return new JsonResult<List<Baoxiu>>(baoxiuInfo);
	}
}
