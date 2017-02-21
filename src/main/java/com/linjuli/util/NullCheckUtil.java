package com.linjuli.util;

import javax.servlet.http.HttpServletRequest;

import com.linjuli.service.exception.ArgumentIsNullException;

public class NullCheckUtil {
	/**
	 * ���ǿ�
	 * @param req
	 * @param paramName
	 * @return
	 */
	public static String check(HttpServletRequest req,String paramName){
		String param = req.getParameter(paramName);
		if(param == null || param == ""){
			throw new ArgumentIsNullException(paramName);
		}
		return param;
	}
	public static Integer checkInt(HttpServletRequest req, String paramName) {
		return Integer.valueOf(NullCheckUtil.check(req, paramName));
	}
}
