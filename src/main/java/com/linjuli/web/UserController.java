package com.linjuli.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linjuli.model.web.User;
import com.linjuli.service.TelService;
import com.linjuli.service.UserService;
import com.linjuli.util.CommonUtil;
import com.linjuli.util.JsonResult;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="telService")
	private TelService telService;
	
	@RequestMapping("/create.do")
	@ResponseBody
	public JsonResult<User> createUser(HttpServletRequest req,HttpServletResponse res) throws IOException{
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
//		//校验验证码
//        String tel = req.getParameter("tel");
//        String checkCode = req.getParameter("checkCode");
//        boolean result = telService.checkTel(tel, checkCode);
        
        //获取opeid
        String openid = CommonUtil.getCookieOpenid(req);
        
        if(openid==null || openid.equals("")){
        	return new JsonResult<User>("获取用户信息失败,请返回微信重新进入本页面");
        }
		if(true){
			User user = userService.createUser(openid);
			user = userService.updateUser(req);
			String tel = user.getTel();
			if(tel != null){
				res.sendRedirect("/baoxiu/check.do");
				return new JsonResult<User>(JsonResult.SUCCESS);
			}
			return new JsonResult<User>("创建失败,请稍后重试");
		}
		return new JsonResult("验证码错误");
	}
}
