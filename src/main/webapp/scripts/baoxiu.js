$(function(){
	$('#image').click(wxChooseImage);
})
wx.config({
	debug: false, 
	appId: '${appId}', 
	timestamp: '${timestamp}', 
	nonceStr: '${nonceStr}', 
	signature: '${signature}',
	jsApiList: ['chooseImage', 'uploadImage', 'downloadImage'] 
});
wx.ready(function(){
	//alert("2")
	//wxChooseImage();
    // config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
});
wx.error(function(res){
	alert("${appId},${timestamp},{nonceStr},${signature}");
    // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。

});
//拍照或从手机相册中选图接口  
function wxChooseImage() {  
	wx.chooseImage({  
		count: 3,  
		needResult: 1,  
		sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有  
		sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有  
		success: function (data) {  
			var localIds = data.localIds;  // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片   
			for(i=0;i<localIds.length-1;i++){
				var mediaId = wxuploadImage(localIds[i]);
				$('#image'+i).value = mediaId;
			}
		},  
		fail: function (res) {  
			alterShowMessage("操作提示", JSON.stringify(res), "1", "确定", "", "", "");   
		}  
	});  
} 
//上传图片接口  
function wxuploadImage(e) {  
	wx.uploadImage({  
		localId: e, // 需要上传的图片的本地ID，由chooseImage接口获得  
		isShowProgressTips: 1, // 默认为1，显示进度提示  
		success: function (res) {  
			var mediaId = res.serverId; // 返回图片的服务器端ID
			return mediaId;
		},  
		fail: function (error) {  
			picPath = '';  
			localIds = '';  
			alert(Json.stringify(error));  

		}  
	});  
} 