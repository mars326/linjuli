<%@ page language="java"  contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<%@page import="com.linjuli.model.weixin.pojo.JsConfig"%>
<%@page language="java" import="com.linjuli.util.WeixinUtil" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>报修</title>
<%
        JsConfig  jsConfig = WeixinUtil.getWxConfig(request);
        request.setAttribute("appId", jsConfig.getAppId());
        request.setAttribute("timestamp", jsConfig.getTimestamp());
        request.setAttribute("nonceStr", jsConfig.getNonceStr());
        request.setAttribute("signature", jsConfig.getSignature());
        %>
<script type="text/javascript" src="../../scripts/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../../scripts/jweixin-1.0.0.js"></script>
<script type="text/javascript" src="../../scripts/const.js"></script>
<script type="text/javascript" src="../../scripts/submit.js"></script>
<script type="text/javascript" src="../../scripts/baoxiu.js"></script>
</head>
<body>
	<form action="http://linjuli.applinzi.com/baoxiu/create.do" method="post" onsubmit="return checkTel()">
		姓名<input type="text" name="username" id="username"/><br/>
		省<select id="province" name="province">
			<option>安徽<option/>
		</select><br/>
		市<select id="city" name="city">
			<option>芜湖<option/>
		</select><br/>
		小区<select id="cid" name="cid">
			<option><option/>
		</select><br/>
		栋<select id="dong" name="dong">
			<option><option/>
		</select><br/>
		单元<select id="unit" name="unit">
			<option><option/>
		</select><br/>
		房间号<input type="text" name="room" id="room"/><br/>
		<input type="button" name="image" id="image" value="上传图片">
		<input type="button" name="image0" id="image0" style="display:none;">
		<input type="button" name="image1" id="image1" style="display:none;">
		<input type="button" name="image2" id="image2" style="display:none;">
		手机号<input type="tel" name="tel" id="tel"/><input type="button" value="免费获取验证码" id="sendTel"/><br/>
		验证码<input type="text" name="checkCode" id="checkCode"><br/>
		<input type="submit" value="提交">
	</form>
</body>
</html>