package com.linjuli.web;

import javax.annotation.Resource;
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
public class TelController {
	@Resource(name="telService")
	private TelService telService;
	
	@RequestMapping("/checkTel.do")
	@ResponseBody
	public JsonResult checkTel(HttpServletRequest req,HttpServletResponse res){
		String tel = req.getParameter("tel");
		String checkCode = req.getParameter("checkCode");
		HttpSession session = req.getSession();
		int result = 1;
		if(tel == session.getAttribute("tel") && checkCode == session.getAttribute("checkCode")){
			result = 0;
			return new JsonResult(result);
		}
		return new JsonResult(result);
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
		HttpSession session = req.getSession();
		session.setAttribute("checkCode", checkCode);
		session.setAttribute("tel", tel);		
		result = 0;
		return new JsonResult(result);
	}
}
