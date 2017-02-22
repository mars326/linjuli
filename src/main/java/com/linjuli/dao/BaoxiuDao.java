package com.linjuli.dao;

import java.util.List;

import com.linjuli.model.web.Baoxiu;

/**
 * 存储,删除报修信息,修改处理进度
 * @author mars3
 *
 */
public interface BaoxiuDao {
	void createBaoxiu(Baoxiu baoxiu);
	/**
	 * 修改isset
	 * 0 未处理 1 处理中 2 处理完成
	 * @param baoxiu
	 */
	void updateBaoxiu(Baoxiu baoxiu);
	
	/**
	 * 修改isdel为1
	 * @param baoxiu
	 */
	void deleteBaoxiu(Baoxiu baoxiu);
	List<Baoxiu> findBaoxiuByUid(int uid);
}
