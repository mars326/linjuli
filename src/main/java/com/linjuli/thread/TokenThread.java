package com.linjuli.thread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.linjuli.model.weixin.pojo.AccessToken;
import com.linjuli.util.CommonUtil;

/**
* 类名: TokenThread </br>
* 描述: 定时获取微信access_token的线程 </br>
* 开发人员： souvc </br>
* 创建时间：  Oct 6, 2015 </br>
* 发布版本：V1.0  </br>
 */
public class TokenThread implements Runnable {
    private static Logger log = LoggerFactory.getLogger(TokenThread.class);
    // 第三方用户唯一凭证
    public static String appid = "";
    // 第三方用户唯一凭证密钥
    public static String appsecret = "";
    public static AccessToken accessToken = null;
    public static String jsapi_ticket = null;

    public void run() {
        while (true) {
            try {
                accessToken = CommonUtil.getAccessToken(appid, appsecret);
                if (null != accessToken) {
                	//其他类通过TokenThread.accessToken.getAccessToken()获取token
                    log.info("获取access_token成功，有效时长{}秒 token:{}", accessToken.getExpiresIn(), accessToken.getAccessToken());
                    
                    //微信js接口调用凭证
                    jsapi_ticket = CommonUtil.getJsapi_ticket(accessToken.getAccessToken());
                    log.info("获取jsapi_ticket成功,{}",jsapi_ticket);
                    // 休眠7000秒
                    Thread.sleep((accessToken.getExpiresIn() - 200)*1000);
                } else {
                    // 如果access_token为null，60秒后再获取
                    Thread.sleep(60 * 1000);
                }
            } catch (InterruptedException e) {
                try {
                    Thread.sleep(60 * 1000);
                } catch (InterruptedException e1) {
                    log.error("{}", e1);
                }
                log.error("{}", e);
            }
        }
    }
}