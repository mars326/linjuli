package com.linjuli.web;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linjuli.model.web.User;
import com.linjuli.service.UserService;
import com.linjuli.util.JsonResult;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping("/create.do")
	public JsonResult<User> createUser(HttpServletRequest req,HttpServletResponse res){
		//ªÒ»°opeid
		Cookie[] cookies = req.getCookies();
		String openid = null;
		for(Cookie cookie:cookies){
			if("openid".equals(cookie.getName())){
				openid = cookie.getValue(); 
			}
		}
		User user = userService.createUser(openid);
		userService.updateUser(req);
		return new JsonResult<User>(user);
	}
}
