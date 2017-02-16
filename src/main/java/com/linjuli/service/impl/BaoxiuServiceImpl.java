package com.linjuli.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.linjuli.dao.CommunityDao;
import com.linjuli.dao.LouguanDao;
import com.linjuli.dao.UserDao;
import com.linjuli.model.web.Baoxiu;
import com.linjuli.model.web.User;
import com.linjuli.service.BaoxiuService;
import com.linjuli.service.exception.BaoxiuArgumentException;
import com.linjuli.util.CommonUtil;
@Service("baoxiuService")
public class BaoxiuServiceImpl implements BaoxiuService{
	@Resource(name="userDao")
	private UserDao userDao;
	@Resource(name="louguanDao")
	private LouguanDao louguanDao;
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
		int uid = user.getId();
		int id = 0;
		
		int cid=checkInt(req, "cid");
		int dong=checkInt(req, "dong");
		int unit=checkInt(req, "unit");
		int lid = louguanDao.findLidByCidDongUnit(cid, dong, unit);
		int isset = 0;
		String tel = check(req, "tel");
		int level=0;
		String content = check(req, "content");
		String relcontent = null;
		String picurl = "";
		String media_id = "";
		int addtime = (int)(System.currentTimeMillis()/1000);
		int chuli_time = 0;
		int jieshu_time = 0;
		int istype = checkInt(req, "istyper");
		int isdel = 0;
		return new Baoxiu(id, cid, uid, lid, isset, tel, level, content, relcontent, picurl, media_id, addtime, chuli_time, jieshu_time, istype, isdel);
	}


	public void updateBaoxiu(String openid) {
		// TODO Auto-generated method stub
		
	}

	public void deleteBaodiu(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 检查非空
	 * @param req
	 * @param paramName
	 * @return
	 */
	private String check(HttpServletRequest req,String paramName){
		String param = req.getParameter(paramName);
		if(param == null || param == ""){
			throw new BaoxiuArgumentException();
		}
		return param;
	}
	private int checkInt(HttpServletRequest req, String paramName) {
		return Integer.valueOf(this.check(req, paramName));
	}
}
