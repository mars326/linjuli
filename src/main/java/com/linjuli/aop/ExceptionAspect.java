package com.linjuli.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.linjuli.util.CommonUtil;
import com.linjuli.util.JsonResult;

/**
 * @author mars3
 * �����쳣
 */
@Component
@Aspect
public class ExceptionAspect {
	private static Logger log = LoggerFactory.getLogger(CommonUtil.class);
	@Around("within (com.linjuli.web.*Controller)")
	public Object process(ProceedingJoinPoint target){
		try{
			//System.out.println("��ʼ");
			//System.out.println(target.getTarget());
			Object obj = target.proceed();
			//System.out.println("����");
			return obj;
		}catch(Throwable e){
			System.out.println("���쳣");
			log.error("�쳣:",e);
			return new JsonResult(e);
		}
	}
}
