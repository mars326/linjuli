package com.linjuli.web;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linjuli.model.weixin.menu.Button;
import com.linjuli.model.weixin.menu.CommonButton;
import com.linjuli.model.weixin.menu.ComplexButton;
import com.linjuli.model.weixin.menu.Menu;
import com.linjuli.thread.TokenThread;
import com.linjuli.util.CommonUtil;
import com.linjuli.util.JsonResult;
import com.linjuli.util.WeixinUtil;

/**
* ����: MenuManager </br>
* ������ com.souvc.weixin.main
* ����:�˵��������� </br>
* ������Ա�� liuhf </br>
* ����ʱ�䣺  2015-12-1 </br>
* �����汾��V1.0  </br>
 */
@Controller
public class MenuController {
    private static Logger log = LoggerFactory.getLogger(MenuController.class);
    
    @RequestMapping("/updateMenu.do")
    public JsonResult updateMenu(){

        // ���ýӿڻ�ȡaccess_token
        String token = TokenThread.accessToken.getAccessToken();

        if (null != token) {
            // ���ýӿڴ����˵�
            int result = WeixinUtil.createMenu(getMenu(), token);

            // �жϲ˵��������
            if (0 == result){
                log.info("�˵������ɹ���");
                return new JsonResult("�˵������ɹ���");
            }else{
                log.info("�˵�����ʧ�ܣ������룺" + result);
                return new JsonResult("�˵�����ʧ�ܣ������룺" + result);
            }
        }
		return null;
    }

    /**
     * ��װ�˵�����
     * 
     * @return
     */
    private static Menu getMenu() {
//        CommonButton btn11 = new CommonButton();
//        btn11.setName("����Ԥ��");
//        btn11.setType("click");
//        btn11.setKey("11");
//
//        CommonButton btn12 = new CommonButton();
//        btn12.setName("������ѯ");
//        btn12.setType("click");
//        btn12.setKey("12");
//
//        CommonButton btn13 = new CommonButton();
//        btn13.setName("�ܱ�����");
//        btn13.setType("click");
//        btn13.setKey("13");
//
//        CommonButton btn14 = new CommonButton();
//        btn14.setName("��ʷ�ϵĽ���");
//        btn14.setType("click");
//        btn14.setKey("14");

    	  CommonButton btn11 = new CommonButton();
    	  btn11.setName("����");
    	  btn11.setType("view");
    	  //��ת����
    	  String REDIRECT_URI = CommonUtil.urlEncodeUTF8("http://www.linjuli.xyz/baoxiu/check.do");
    	  //scope=snsapi_base��Ĭ��Ȩ snsapi_userinfo��ҳ��Ȩ
    	  btn11.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+CommonUtil.appID+"&redirect_uri="+REDIRECT_URI+"&response_type=code&scope=snsapi_base&state=1#wechat_redirect");
    	  
		  CommonButton btn00 = new CommonButton();
		  btn00.setName("TEST0222");
		  btn00.setType("click");
		  btn00.setKey("00");
		  
		  CommonButton btn33 = new CommonButton();
		  btn33.setName("updateMenu");
		  btn33.setType("view");
		  btn33.setUrl("http://www.linjuli.xyz/updateMenu.do");
    	 /**
         * ΢�ţ�  mainBtn1,mainBtn2,mainBtn3�ײ�������һ���˵���
         */
//        
//        ComplexButton mainBtn1 = new ComplexButton();
//        mainBtn1.setName("��������");
//        //һ������4���Ӳ˵�
//        mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13, btn14 });
    	  ComplexButton mainBtn1 = new ComplexButton();
    	  mainBtn1.setName("��ҵ");
    	  mainBtn1.setSub_button(new CommonButton[]{btn11});
    	  ComplexButton mainBtn2 = new ComplexButton();
    	  mainBtn2.setName("����");
    	  mainBtn2.setSub_button(new CommonButton[]{btn00});
    	  ComplexButton mainBtn3 = new ComplexButton();
    	  mainBtn3.setName("����");
    	  mainBtn3.setSub_button(new CommonButton[]{btn33});
   
        /**
         * ��װ�����˵�
         */
//        Menu menu = new Menu();
//        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });
    	  Menu menu = new Menu();
    	  menu.setButton(new Button[]{mainBtn1,mainBtn2, mainBtn3});

        return menu;
    }
}
