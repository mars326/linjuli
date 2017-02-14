package com.linjuli.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linjuli.service.WeixinService;
import com.linjuli.service.impl.WeixinServiceImpl;
import com.linjuli.util.SignUtil;

/**
 * 类名: CoreServlet </br> 
 * 描述: 来接收微信服务器传来信息 </br> 
 * 开发人员： souvc</br> 
 * 创建时间：2015-9-29 </br> 
 * 发布版本：V1.0 </br>
 */
@Controller
public class WeixinController{

    private static final long serialVersionUID = 4323197796926899691L;
    @Resource(name="weixinService")
    private WeixinService weixinService;

    /**
     * 确认请求来自微信服务器
     * @throws IOException 
     */
    @RequestMapping(value="weixin.do",method=RequestMethod.GET)
    @ResponseBody
    public String weixinReqCheck(HttpServletRequest request, HttpServletResponse response){
        
        // 随机字符串
        String echostr = request.getParameter("echostr");

        
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
        if (SignUtil.checkSignature(request)) {
            return echostr;
        }
        return "error";
    }

    /**
     * 处理微信服务器发来的消息
     * @throws IOException 
     */
    @RequestMapping(value="weixin.do",method=RequestMethod.POST)
    @ResponseBody
    public void weixinMessage(HttpServletRequest request, HttpServletResponse response) throws IOException{
        // 消息的接收、处理、响应
        // 将请求、响应的编码均设置为UTF-8（防止中文乱码）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        //只处理微信服务器的消息
        if(SignUtil.checkSignature(request)){
	        // 调用微信业务类接收消息、处理消息
	        String respXml = weixinService.processRequest(request);
	
	        // 响应消息
	        out.print(respXml);
        }
        out.close();
    }

}