package com.linjuli.model.weixin.message.req;

/**
* ����: ImageMessage </br>
* ����: ������Ϣ֮ͼƬ��Ϣ </br>
* ������Ա�� souvc </br>
* ����ʱ�䣺  Sep 29, 2015 </br>
* �����汾��V1.0  </br>
 */
public class ImageMessage extends BaseMessage {
    // ͼƬ����
    private String PicUrl;
    private String MediaId;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}