package com.linjuli.model.weixin.message.req;

/**
* ����: VideoMessage </br>
* ����: ������Ϣ֮��Ƶ��Ϣ </br>
* ������Ա�� souvc </br>
* ����ʱ�䣺  Sep 29, 2015 </br>
* �����汾��V1.0  </br>
 */
public class VideoMessage  extends BaseMessage{

    // ý��ID
    private String MediaId;
    // ������ʽ
    private String ThumbMediaId;

    public String getMediaId() {
        return MediaId;
    }
    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
    public String getThumbMediaId() {
        return ThumbMediaId;
    }
    public void setThumbMediaId(String thumbMediaId) {
        ThumbMediaId = thumbMediaId;
    }
    
    
    
}
