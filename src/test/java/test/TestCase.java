package test;

import java.util.Date;

import org.junit.Test;

import com.linjuli.util.CommonUtil;


public class TestCase {
	
	/**
	 * ��Ȩurl�Ƿ���ȷ
	 */
	@Test
	public void url(){
  	  String REDIRECT_URI = CommonUtil.urlEncodeUTF8("https://linjuli.applinzi.com/OAuth.do");
  	  System.out.println("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+CommonUtil.appID+"&redirect_uri="+REDIRECT_URI+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
  	  
	}
	
	/**
	 * ���ݿ�ʱ���ʽΪlongֵȥ�������λ
	 */
	@Test
	public void intTime(){
		System.out.println(new Date(1448269592000L));
	}
	
}
