package com.linjuli.dao;

import java.util.List;

import com.linjuli.model.web.Baoxiu;

/**
 * �洢,ɾ��������Ϣ,�޸Ĵ������
 * @author mars3
 *
 */
public interface BaoxiuDao {
	void createBaoxiu(Baoxiu baoxiu);
	/**
	 * �޸�isset
	 * 0 δ���� 1 ������ 2 �������
	 * @param baoxiu
	 */
	void updateBaoxiu(Baoxiu baoxiu);
	
	/**
	 * �޸�isdelΪ1
	 * @param baoxiu
	 */
	void deleteBaoxiu(Baoxiu baoxiu);
	List<Baoxiu> findBaoxiuByUid(int uid);
}
