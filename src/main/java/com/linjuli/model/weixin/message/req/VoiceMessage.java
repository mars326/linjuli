package com.linjuli.model.weixin.message.req;

/**
* ����: VoiceMessage </br>
* ����: ������Ϣ֮������Ϣ </br>
* ������Ա�� souvc </br>
* ����ʱ�䣺  Sep 29, 2015 </br>
* �����汾��V1.0  </br>
 */
public class VoiceMessage extends BaseMessage {

    // ý��ID
    private String MediaId;
    // ������ʽ
    private String Format;

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getFormat() {
        return Format;
    }

    public void setFormat(String format) {
        Format = format;
    }
}
