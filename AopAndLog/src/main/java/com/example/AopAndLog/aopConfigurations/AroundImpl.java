package com.example.AopAndLog.aopConfigurations;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AroundImpl {

	Logger logger = LoggerFactory.getLogger("Aspect Around ..");

	@Pointcut("execution(String com.example.AopAndLog.controller.HelloController.sayHey(..))")
	public void exce() {

	}

	@Around("exce()") // it before + AfterReturning = Around
	public String impl(ProceedingJoinPoint proceedingJoinPoint) {
		try {
			String arg = proceedingJoinPoint.getArgs()[0].toString();
			logger.error("args = " + arg);

			Object result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
			logger.error("result = " + result);
			return result.toString();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;

	}

}
