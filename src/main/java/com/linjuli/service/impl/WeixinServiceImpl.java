package com.linjuli.service.impl;
import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.linjuli.dao.UserDao;
import com.linjuli.model.web.User;
import com.linjuli.model.weixin.message.res.TextMessage;
import com.linjuli.service.UserService;
import com.linjuli.service.WeixinService;
import com.linjuli.util.MessageUtil;

/**
* ����: CoreService </br>
* ����: ���ķ����� </br>
* ������Ա�� souvc </br>
* ����ʱ�䣺  2015-9-30 </br>
* �����汾��V1.0  </br>
 */
@Service("weixinService")
public class WeixinServiceImpl implements WeixinService{
	@Resource
	private UserDao userDao;
	@Resource
	private UserService userService;
    /**
     * ����΢�ŷ���������
     * @param request
     * @return xml
     */
    public String processRequest(HttpServletRequest request) {
        // xml��ʽ����Ϣ����
        String respXml = null;
        // Ĭ�Ϸ��ص��ı���Ϣ����
        String respContent = "δ֪����Ϣ���ͣ�";
        try {
            // ����parseXml��������������Ϣ
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            // ���ͷ��ʺ�
            String fromUserName = requestMap.get("FromUserName");
            // ������΢�ź�
            String toUserName = requestMap.get("ToUserName");
            // ��Ϣ����
            String msgType = requestMap.get("MsgType");

            // �ظ��ı���Ϣ
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

            // �ı���Ϣ
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                respContent = "�����͵����ı���Ϣ��";
            }
            // ͼƬ��Ϣ
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "�����͵���ͼƬ��Ϣ��";
            }
            // ������Ϣ
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "�����͵���������Ϣ��";
            }
            // ��Ƶ��Ϣ
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)) {
                respContent = "�����͵�����Ƶ��Ϣ��";
            }
            // ��Ƶ��Ϣ
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_SHORTVIDEO)) {
                respContent = "�����͵���С��Ƶ��Ϣ��";
            }
            // ����λ����Ϣ
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "�����͵��ǵ���λ����Ϣ��";
            }
            // ������Ϣ
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "�����͵���������Ϣ��";
            }
            // �¼�����
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // �¼�����
                String eventType = requestMap.get("Event");
                // ��ע
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    subscribeDo(fromUserName);
                	respContent = "лл���Ĺ�ע��";
                }
                // ȡ����ע
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    // TODO ȡ�����ĺ��û��������յ������˺ŷ��͵���Ϣ����˲���Ҫ�ظ�
                	unSubscribeDo(fromUserName);
                }
                // ɨ���������ά��
                else if (eventType.equals(MessageUtil.EVENT_TYPE_SCAN)) {
                    // TODO ����ɨ���������ά���¼�
                }
                // �ϱ�����λ��
                else if (eventType.equals(MessageUtil.EVENT_TYPE_LOCATION)) {
                    // TODO �����ϱ�����λ���¼�
                }
                // �Զ���˵�
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    // TODO ����˵�����¼�
                	menuDo(fromUserName);
                }
            }
            // �����ı���Ϣ������
            textMessage.setContent(respContent);
            // ���ı���Ϣ����ת����xml
            respXml = MessageUtil.messageToXml(textMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respXml;
    }


	private void menuDo(String fromUserName) {
		
		
	}


	/**
	 * ��עʱ
	 * �����û���Ϣ
	 * @param fromUserName
	 */
	private void subscribeDo(String fromUserName) {
		User user = userDao.findUserByOpenId(fromUserName);
		String guanzhu = "1";
		if(user == null){
			userService.createUser(fromUserName,guanzhu);
		}else{
			user.setGuanzhu(Integer.valueOf(guanzhu));
			userDao.updateUser(user);
		}
	}
	/**
	 * ȡ����עʱ
	 * �޸����ݿ��е�user���е�guanzhuΪ0
	 * @param fromUserName
	 */
	private void unSubscribeDo(String fromUserName) {
		User user = userDao.findUserByOpenId(fromUserName);
		if(user != null){
			user.setGuanzhu(0);
			userDao.updateUser(user);
		}
	}
}