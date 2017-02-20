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
 * 处理异常
 */
@Component
@Aspect
public class ExceptionAspect {
	private static Logger log = LoggerFactory.getLogger(CommonUtil.class);
	@Around("within (com.linjuli.web.*Controller)")
	public Object process(ProceedingJoinPoint target){
		try{
			//System.out.println("开始");
			//System.out.println(target.getTarget());
			Object obj = target.proceed();
			//System.out.println("结束");
			return obj;
		}catch(Throwable e){
			System.out.println("有异常");
			log.error("异常:",e);
			return new JsonResult(e);
		}
	}
}
