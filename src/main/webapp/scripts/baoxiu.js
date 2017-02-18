$(function(){
	$('#image').click(wxChooseImage);
	var url =ROOTURL+"jsConfig.do";
	var data = null;
	$.getJSON(url,data,function(result){
		if(result.state==SUCCESS){
			var config = result.data 
			//微信信息的以及调用的配置
			wx.config({
				debug: false, 
				appId: config.appid, 
				timestamp: config.timestamp, 
				nonceStr: config.nonceStr, 
				signature: config.signature,
				jsApiList: ['chooseImage', 'uploadImage', 'downloadImage'] 
			});
		}else {  
			alert(result.message);  
		} 

	});
})

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