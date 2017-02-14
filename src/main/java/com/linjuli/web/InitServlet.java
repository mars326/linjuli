package com.linjuli.web;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.linjuli.thread.TokenThread;
import com.linjuli.util.CommonUtil;

/**
* 类名: InitServlet </br>
* 描述: 初始化servlet </br>
* 开发人员： souvc </br>
* 创建时间：  Oct 6, 2015 </br>
* 发布版本：V1.0  </br>
 */
public class InitServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static Logger log = LoggerFactory.getLogger(InitServlet.class);

    public void init() throws ServletException {
        TokenThread.appid = CommonUtil.appID;
        TokenThread.appsecret = CommonUtil.appsecret;

        log.info("weixin api appid:{}",  TokenThread.appid);
        log.info("weixin api appsecret:{}", TokenThread.appsecret);

        // 未配置appid、appsecret时给出提示
        if ("".equals(TokenThread.appid) || "".equals(TokenThread.appsecret)) {
            log.error("appid and appsecret configuration error, please check carefully.");
        } else {
            // 启动定时获取access_token的线程
            new Thread(new TokenThread()).start();
        }
    }
}