package com.linjuli.service.impl;

import com.linjuli.dao.TelDao;
import com.linjuli.model.web.TelCache;
import com.linjuli.service.TelService;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import org.dom4j.Document;   
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;   
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.linjuli.util.CommonUtil;
import com.linjuli.util.StringUtil;

import java.io.IOException;

import javax.annotation.Resource;

@Service("telService")
public class TelServiceImpl implements TelService {
	private static String Url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
	private static Logger log = LoggerFactory.getLogger(TelServiceImpl.class);

	@Resource(name="telDao")
	private TelDao telDao;
	public int sendTel(String tel) {
		//�鿴����
		String checkCodeCache = telDao.findCheckCodeByTel(tel);


		HttpClient client = new HttpClient(); 
		PostMethod method = new PostMethod(Url);

		client.getParams().setContentCharset("GBK");
		method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");

		int checkCode = (int)((Math.random()*9+1)*100000);

		String content = new String("������֤���ǣ�" + checkCode + "���벻Ҫ����֤��й¶�������ˡ�");

		NameValuePair[] data = {//�ύ����
				new NameValuePair("account", "C83361563"), //�鿴�û������¼�û�����->��֤�롢֪ͨ����->�ʻ���ǩ������->APIID
				new NameValuePair("password", "40385c350cb9c714713392bbdd9f876f"),  //�鿴�������¼�û�����->��֤�롢֪ͨ����->�ʻ���ǩ������->APIKEY
				//new NameValuePair("password", util.StringUtil.MD5Encode("����")),
				new NameValuePair("mobile", tel), 
				new NameValuePair("content", content),
		};
		method.setRequestBody(data);

		try {
			client.executeMethod(method);

			String SubmitResult =method.getResponseBodyAsString();

			//System.out.println(SubmitResult);

			Document doc = DocumentHelper.parseText(SubmitResult);
			Element root = doc.getRootElement();

			String code = root.elementText("code");
			String msg = root.elementText("msg");
			String smsid = root.elementText("smsid");

			//			System.out.println(code);
			//			System.out.println(msg);
			//			System.out.println(smsid);

			if("2".equals(code)){
				TelCache telCache = telCache = new TelCache(tel, String.valueOf(checkCode), (int)(System.currentTimeMillis()/1000+600));
				log.info("�����ύ�ɹ�");
				if(checkCodeCache!=null){
					telDao.updateTime(telCache);
					return checkCode;
				}
				telDao.save(telCache);
				return checkCode;
			}

		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("�����ύʧ��");
		return 1;
	}
	public boolean checkTel(String tel, String checkCode) {
		String checkCodeCache = telDao.findCheckCodeByTel(tel);
		if(checkCodeCache != null){
			if(checkCode != checkCodeCache ){
				return false;
			}
			int endTime = telDao.findTimeByTel(tel);
			if(endTime>(int)(System.currentTimeMillis()/1000)){
				return true;
			}
		}
		return false;
	}

}
