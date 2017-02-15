package test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.linjuli.dao.UserDao;
import com.linjuli.model.web.User;
import com.linjuli.util.CommonUtil;


public class TestCase {
	ApplicationContext ctx;

	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("spring-mybatis.xml", "spring-service.xml", "spring-web.xml");
	}
	/**
	 * ��Ȩurl�Ƿ���ȷ
	 */
	@Test
	public void url(){
	   	  String REDIRECT_URI = CommonUtil.urlEncodeUTF8("https://linjuli.applinzi.com/OAuth.do");
    	  System.out.println("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+CommonUtil.appID+"&redirect_uri="+REDIRECT_URI+"&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
	}
	
	/**
	 * ���ݿ�ʱ���ʽΪlongֵȥ�������λ
	 */
	@Test
	public void intTime(){
		System.out.println(new Date(1487149879000L));
		System.out.println((int)(System.currentTimeMillis()/1000));
		System.out.println(new Date(System.currentTimeMillis()));
	}
	
	/**
	 * ����UserDao createUser����
	 */
	@Test
	public void createUserTest(){
		UserDao  dao = ctx.getBean("userDao",UserDao.class);
		User user = new User(1, "a", "a", "a", "a", "a", "a", "a", "a", 0, 0, 0, 0, 0, "a", 0, 0, 0, 0, 0, 0, 0, 0);
		dao.createUser(user);
		System.out.println(user.getId());
	}
}
