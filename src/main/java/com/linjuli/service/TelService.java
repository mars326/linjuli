package com.linjuli.service;

/**
 * @author mars3
 * ��֤�ֻ�
 */
public interface TelService {

	/**
	 * ��ָ���ֻ��ŷ�����֤��
	 * @param tel �ֻ���
	 * @return ��֤��   1Ϊ����ʧ��
	 */
	int sendTel(String tel);
	
	boolean checkTel(String tel,String checkCode);

}
