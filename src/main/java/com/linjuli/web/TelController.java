package com.linjuli.web;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linjuli.service.TelService;
import com.linjuli.util.JsonResult;

/**
 * 处理手机短信验证
 * @author mars3
 *
 */
@Controller
@RequestMapping("/tel")
public class TelController {
	@Resource(name="telService")
	private TelService telService;
	
	@RequestMapping("/checkTel.do")
	@ResponseBody
	public JsonResult<Object> checkTel(HttpServletRequest req,HttpServletResponse res){
		String tel = req.getParameter("tel");
		String checkCode = req.getParameter("checkCode");
		//System.out.println(tel+"#"+checkCode);
		int result = 1;
//		if(telService.checkTel(tel,checkCode)){
			result = 0;
			return new JsonResult<Object>(result);
//		}
//		return new JsonResult<Object>(result);
	}
	
	@RequestMapping("/sendTel.do")
	@ResponseBody
	public JsonResult sendTel(HttpServletRequest req,HttpServletResponse res){
		String tel = req.getParameter("tel");
		//System.out.println("tel:"tel);
		int result = telService.sendTel(tel);
		if(result == 1){
			return new JsonResult(result);
		}
		String checkCode = String.valueOf(result);
		
//		//测试
//		String tel = "15757101796";
//		String checkCode = "123456";
//		int result = 0;
		
		
		//System.out.println(tel+"#"+checkCode);
		result = 0;
		return new JsonResult(result);
	}
}
