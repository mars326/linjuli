package com.linjuli.model.weixin.pojo;
/**
* ����: AccessToken </br>
* ������ com.souvc.weixin.pojo
* ����: ΢��ͨ�ýӿ�ƾ֤  </br>
* ������Ա��souvc </br>
* ����ʱ�䣺  2015-12-1 </br>
* �����汾��V1.0  </br>
 */
public class AccessToken {
	
    // �ӿڷ���ƾ֤
    private String accessToken;
    // ƾ֤��Ч�ڣ���λ����
    private int expiresIn;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }
}