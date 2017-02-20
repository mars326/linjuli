package com.linjuli.web;

import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linjuli.model.web.User;
import com.linjuli.model.weixin.pojo.SNSUserInfo;
import com.linjuli.model.weixin.pojo.SNSUserInfo2;
import com.linjuli.service.BaoxiuService;
import com.linjuli.service.UserService;
import com.linjuli.thread.TokenThread;
import com.linjuli.util.OauthUtil;

/**
 * 处理报修请求
 * @author mars3
 *
 */
@Controller
@RequestMapping("/baoxiu")
public class BaoxiuController {
	@Resource(name="userService")
	private UserService userService;
	@Resource(name="baoxiuService")
	private BaoxiuService baoxiuService;
	
	/**
	 * 检查用户是否已注册
	 * @param req
	 * @param res
	 * @throws ServletException
	 * @throws IOException
	 */
	@RequestMapping("/check.do")
	public void check(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		String guanzhu = req.getParameter("guanzhu");
		User user;
		String openid;
		//网页授权用户
		if("0".equals(guanzhu)){
			SNSUserInfo snsUserInfo = OauthUtil.oauthCheck(req,res);
			openid = snsUserInfo.getOpenId();
			user = userService.createUser(openid,guanzhu);
		}else{
		//已关注用户
			SNSUserInfo2 snsUserInfo = OauthUtil.oauthCheck(req,res,TokenThread.accessToken.getAccessToken());
			openid = snsUserInfo.getOpenId();
			user = userService.createUser(openid);
		}
		//未绑定小区
		if(user.getIsset()==0){
			req.getRequestDispatcher("/WEB-INF/html/register.html").forward(req, res);
			return;
		}
		req.getRequestDispatcher("/WEB-INF/html/baoxiu.jsp").forward(req, res);
	}
	
	/**
	 * 创建报修信息
	 * @param req
	 * @param res
	 * @throws IOException 
	 */
	@RequestMapping("/create.do")
	public void create(HttpServletRequest req,HttpServletResponse res) throws IOException{
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
		baoxiuService.createBaoxiu(req);
		res.sendRedirect("/index.html");
	}
	
	/**
	 * 更新报修信息
	 * @param req
	 * @param res
	 */
	@RequestMapping("/update.do")
	public void update(HttpServletRequest req,HttpServletResponse res){
		
	}
}
