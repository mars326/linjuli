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
import com.linjuli.util.WeixinUtil;

/**
* 类名: MenuManager </br>
* 包名： com.souvc.weixin.main
* 描述:菜单管理器类 </br>
* 开发人员： liuhf </br>
* 创建时间：  2015-12-1 </br>
* 发布版本：V1.0  </br>
 */
@Controller
public class MenuController {
    private static Logger log = LoggerFactory.getLogger(MenuController.class);
    
    @RequestMapping("/updateMenu.do")
    public void updateMenu(){

        // 调用接口获取access_token
        String token = TokenThread.accessToken.getAccessToken();

        if (null != token) {
            // 调用接口创建菜单
            int result = WeixinUtil.createMenu(getMenu(), token);

            // 判断菜单创建结果
            if (0 == result)
                log.info("菜单创建成功！");
            else
                log.info("菜单创建失败，错误码：" + result);
        }
    }

    /**
     * 组装菜单数据
     * 
     * @return
     */
    private static Menu getMenu() {
//        CommonButton btn11 = new CommonButton();
//        btn11.setName("天气预报");
//        btn11.setType("click");
//        btn11.setKey("11");
//
//        CommonButton btn12 = new CommonButton();
//        btn12.setName("公交查询");
//        btn12.setType("click");
//        btn12.setKey("12");
//
//        CommonButton btn13 = new CommonButton();
//        btn13.setName("周边搜索");
//        btn13.setType("click");
//        btn13.setKey("13");
//
//        CommonButton btn14 = new CommonButton();
//        btn14.setName("历史上的今天");
//        btn14.setType("click");
//        btn14.setKey("14");

    	  CommonButton btn11 = new CommonButton();
    	  btn11.setName("报修");
    	  btn11.setType("view");
    	  //跳转链接
    	  String REDIRECT_URI = CommonUtil.urlEncodeUTF8("https://linjuli.applinzi.com/OAuth.do");
    	  //System.out.println(REDIRECT_URI);
    	  btn11.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=appid&redirect_uri="+REDIRECT_URI+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
    	  //System.out.println("https://open.weixin.qq.com/connect/oauth2/authorize?appid="+ConnectUtil.appID+"&redirect_uri="+REDIRECT_URI+"&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect");
    	  
		  CommonButton btn00 = new CommonButton();
		  btn00.setName("TEST1");
		  btn00.setType("click");
		  btn00.setKey("00");
    	 /**
         * 微信：  mainBtn1,mainBtn2,mainBtn3底部的三个一级菜单。
         */
//        
//        ComplexButton mainBtn1 = new ComplexButton();
//        mainBtn1.setName("生活助手");
//        //一级下有4个子菜单
//        mainBtn1.setSub_button(new CommonButton[] { btn11, btn12, btn13, btn14 });
    	  ComplexButton mainBtn1 = new ComplexButton();
    	  mainBtn1.setName("物业");
    	  mainBtn1.setSub_button(new CommonButton[]{btn11});
    	  ComplexButton mainBtn2 = new ComplexButton();
    	  mainBtn2.setName("待定");
    	  mainBtn2.setSub_button(new CommonButton[]{btn00});
    	  ComplexButton mainBtn3 = new ComplexButton();
    	  mainBtn3.setName("待定");
    	  mainBtn3.setSub_button(new CommonButton[]{btn00});
   
        /**
         * 封装整个菜单
         */
//        Menu menu = new Menu();
//        menu.setButton(new Button[] { mainBtn1, mainBtn2, mainBtn3 });
    	  Menu menu = new Menu();
    	  menu.setButton(new Button[]{mainBtn1,mainBtn2, mainBtn3});

        return menu;
    }
}
