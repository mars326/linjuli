var countdown=60; 
$(function(){
	$('#sendTel').click(sendTel);
})
function settime(obj) { 
    if (countdown == 0) { 
        obj.removeAttribute("disabled");    
        obj.value="免费获取验证码"; 
        countdown = 60; 
        return;
    } else { 
        obj.setAttribute("disabled", true); 
        obj.value="重新发送(" + countdown + ")"; 
        countdown--; 
    } 
setTimeout(function() { 
    settime(obj); 
    },1000) 
}

function submitAll(){
	if(checkTel()!=SUCCESS){
		alert("验证码错误");
		return;
	}
	alert("success");
}

//发送验证码
function sendTel(){
	settime(this);
	url="sendTel.do";
	data={
			"tel":$('#tel').val()
	}
	$.getJSON(url, data, function(result) {
		if (result.state == SUCCESS) {
			console.log("短信发送成功");
		}else{
			console.log("短信发送失败");
		}
	});
}

//校验验证码
function checkTel(){
	url="checkTel.do";
	data={
			
			"tel":$('#tel').val(),
			"checkCode":$('#checkCode').val()
	}
	$.getJSON(url, data, function(result) {
		if (result.state == SUCCESS) {
			return SUCCESS;
		}else{
			alert(result.message);
		}
	});
}