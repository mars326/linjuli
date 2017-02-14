package com.linjuli.model.weixin.pojo;
/**
* 类名: AccessToken </br>
* 包名： com.souvc.weixin.pojo
* 描述: 微信通用接口凭证  </br>
* 开发人员：souvc </br>
* 创建时间：  2015-12-1 </br>
* 发布版本：V1.0  </br>
 */
public class AccessToken {
	
    // 接口访问凭证
    private String accessToken;
    // 凭证有效期，单位：秒
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