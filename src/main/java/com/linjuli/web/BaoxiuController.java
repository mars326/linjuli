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
 * ����������
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
	 * ����û��Ƿ���ע��
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
		//��ҳ��Ȩ�û�
		if("0".equals(guanzhu)){
			SNSUserInfo snsUserInfo = OauthUtil.oauthCheck(req,res);
			openid = snsUserInfo.getOpenId();
			user = userService.createUser(openid,guanzhu);
		}else{
		//�ѹ�ע�û�
			SNSUserInfo2 snsUserInfo = OauthUtil.oauthCheck(req,res,TokenThread.accessToken.getAccessToken());
			openid = snsUserInfo.getOpenId();
			user = userService.createUser(openid);
		}
		//δ��С��
		if(user.getIsset()==0){
			req.getRequestDispatcher("/WEB-INF/html/register.html").forward(req, res);
			return;
		}
		req.getRequestDispatcher("/WEB-INF/html/baoxiu.jsp").forward(req, res);
	}
	
	/**
	 * ����������Ϣ
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
	 * ���±�����Ϣ
	 * @param req
	 * @param res
	 */
	@RequestMapping("/update.do")
	public void update(HttpServletRequest req,HttpServletResponse res){
		
	}
}
