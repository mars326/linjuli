package com.linjuli.model.weixin.message.req;

/**
* ����: TextMessage </br>
* ����: ������Ϣ֮�ı���Ϣ </br>
* ������Ա�� souvc </br>
* ����ʱ�䣺  Sep 29, 2015 </br>
* �����汾��V1.0  </br>
 */

public class TextMessage extends BaseMessage {

    // ��Ϣ����
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
