package com.linjuli.service.impl;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.linjuli.dao.BaoxiuDao;
import com.linjuli.dao.LouguanDao;
import com.linjuli.dao.UserDao;
import com.linjuli.model.web.Baoxiu;
import com.linjuli.model.web.User;
import com.linjuli.service.BaoxiuService;
import com.linjuli.service.exception.ArgumentIsNullException;
import com.linjuli.thread.TokenThread;
import com.linjuli.util.CommonUtil;
import com.linjuli.util.HttpDownloadUtil;
import com.linjuli.util.NullCheckUtil;
@Service("baoxiuService")
public class BaoxiuServiceImpl implements BaoxiuService{
	@Resource(name="userDao")
	private UserDao userDao;
	@Resource(name="louguanDao")
	private LouguanDao louguanDao;
	@Resource(name="baoxiuDao")
	private BaoxiuDao baoxiuDao;
	//	id           int(10) unsigned 主键                                               
	//	cid          int(10) unsigned 所属小区                                         
	//	uid          int(10) unsigned 普通用户id                                       
	//	lid          int(10) unsigned 对应物业的楼管                                
	//	isset        int(10) unsigned 处理状态 0 未处理 1 处理中 2 处理完成  
	//	tel          varchar(180)     电话                                               
	//	level        tinyint(4)       星级                                               
	//	content      text             报修内容                                         
	//	relcontent   text             反馈内容                                         
	//	picurl       text             相片                                               
	//	media_id     text             media_id                                             
	//	addtime      int(10) unsigned 报修时间                                         
	//	chuli_time   int(10) unsigned 处理时间                                         
	//	jieshu_time  int(10) unsigned 结束时间                                         
	//	istype       tinyint(4)       报修类别                                        
	//	isdel        tinyint(4)       状态 1删除    
	public Baoxiu createBaoxiu(HttpServletRequest req) {
		String openid = CommonUtil.getCookieOpenid(req);
		User user = userDao.findUserByOpenId(openid);
		if(user == null){
			throw new ArgumentIsNullException("用户信息获取失败或不存在");
		}
		int uid = user.getId();
		int id = 0;

		int cid=NullCheckUtil.checkInt(req, "cid");
		int dong=NullCheckUtil.checkInt(req, "dong");
		int unit=NullCheckUtil.checkInt(req, "unit");
		int lid = 0;//louguanDao.findLidByCidDongUnit(cid, dong, unit);//数据表未修改
		int isset = 0;
		String tel = NullCheckUtil.check(req, "tel");
		int level=0;
		String content = NullCheckUtil.check(req, "content");
		String relcontent = null;
		String media_id = req.getParameter("imageTxt0");
		System.out.println("media_id:"+media_id);
		String picurl = getPicurl(media_id);

		int addtime = (int)(System.currentTimeMillis()/1000);
		int chuli_time = 0;
		int jieshu_time = 0;
		int istype = NullCheckUtil.checkInt(req, "istype");
		int isdel = 0;

		//保存到数据库
		Baoxiu baoxiuInfo = new Baoxiu(id, cid, uid, lid, isset, tel, level, content, relcontent, picurl, media_id, addtime, chuli_time, jieshu_time, istype, isdel);
		baoxiuDao.createBaoxiu(baoxiuInfo);
		return baoxiuInfo;
	}


	private String getPicurl(String media_id) {
		String picurl = null;
		String[] mediaIds = null;
		if(media_id!=null){
			mediaIds = media_id.split("#");
		}
		if(mediaIds == null){
			return picurl;
		}
		//获取下载地址,并下载到uploads文件夹中
		for(String mediaId:mediaIds){
			if(mediaId == null || mediaId == "" || mediaId.length()<5){
				continue;
			}
			String url="http://file.api.weixin.qq.com/cgi-bin/media/get?access_token="+TokenThread.accessToken.getAccessToken()+"&media_id="+mediaId;
			String fileName = System.currentTimeMillis()+".jpg";
			String savePath = "uploads/";
			//保存图片路径到数据库
			if(picurl==null){
				picurl=savePath + fileName;
			}else{
				picurl = picurl+"#"+ savePath + fileName;
			}
			try {
				HttpDownloadUtil.downLoadFromUrl(url, fileName, savePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return picurl;
	}


	public void updateBaoxiu(String openid) {
		// TODO Auto-generated method stub

	}

	public void deleteBaodiu(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}


	public List<Baoxiu> findBaoxiuByUid(int uid) {
		List<Baoxiu> baoxiuInfo = baoxiuDao.findBaoxiuByUid(uid);
		return baoxiuInfo;
	}


}
