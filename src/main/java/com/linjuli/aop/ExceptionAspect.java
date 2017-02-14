package com.linjuli.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.linjuli.util.JsonResult;

@Component
@Aspect
public class ExceptionAspect {
	@Around("within (com.linjuli.web.*Controller)")
	public Object process(ProceedingJoinPoint target){
		try{
			//System.out.println("��ʼ");
			//System.out.println(target.getTarget());
			Object obj = target.proceed();
			//System.out.println("����");
			return obj;
		}catch(Throwable e){
			//System.out.println("���쳣");
			e.printStackTrace();
			return new JsonResult(e);
		}
	}
}
