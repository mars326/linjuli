package com.linjuli.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.linjuli.model.web.Baoxiu;

/**
 * �洢,ɾ��������Ϣ,�޸Ĵ������
 * @author mars3
 *
 */
public interface BaoxiuService {
	Baoxiu createBaoxiu(HttpServletRequest req);
	void updateBaoxiu(String openid);
	void deleteBaodiu(HttpServletRequest req);
	List<Baoxiu> findBaoxiuByUid(int uid);
}
