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
 * ����: CoreServlet </br> 
 * ����: ������΢�ŷ�����������Ϣ </br> 
 * ������Ա�� souvc</br> 
 * ����ʱ�䣺2015-9-29 </br> 
 * �����汾��V1.0 </br>
 */
@Controller
public class WeixinController{

    private static final long serialVersionUID = 4323197796926899691L;
    @Resource(name="weixinService")
    private WeixinService weixinService;

    /**
     * ȷ����������΢�ŷ�����
     * @throws IOException 
     */
    @RequestMapping(value="weixin.do",method=RequestMethod.GET)
    @ResponseBody
    public String weixinReqCheck(HttpServletRequest request, HttpServletResponse response){
        
        // ����ַ���
        String echostr = request.getParameter("echostr");

        
        // ͨ������signature���������У�飬��У��ɹ���ԭ������echostr����ʾ����ɹ����������ʧ��
        if (SignUtil.checkSignature(request)) {
            return echostr;
        }
        return "error";
    }

    /**
     * ����΢�ŷ�������������Ϣ
     * @throws IOException 
     */
    @RequestMapping(value="weixin.do",method=RequestMethod.POST)
    @ResponseBody
    public void weixinMessage(HttpServletRequest request, HttpServletResponse response) throws IOException{
        // ��Ϣ�Ľ��ա�������Ӧ
        // ��������Ӧ�ı��������ΪUTF-8����ֹ�������룩
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        //ֻ����΢�ŷ���������Ϣ
        if(SignUtil.checkSignature(request)){
	        // ����΢��ҵ���������Ϣ��������Ϣ
	        String respXml = weixinService.processRequest(request);
	
	        // ��Ӧ��Ϣ
	        out.print(respXml);
        }
        out.close();
    }

}