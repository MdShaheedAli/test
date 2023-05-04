package com.example.AopAndLog.aopConfigurations;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AfterReturningAndThrowing {
	
	Logger logger= LoggerFactory.getLogger(" Aspect . . ");

	@AfterReturning(
			pointcut = "execution(String com.example.AopAndLog.controller.HelloController.sayHello(..))",
			returning = "name")
	public void afterReturning(JoinPoint jp,String name) {
		
		System.out.println("passing values : "+jp.getArgs()[0].toString());
		System.out.println("return value = "+name);
		
	}
	
	@AfterThrowing(
			pointcut = "execution(String com.example.AopAndLog.controller.HelloController.sayHi(..))",
			throwing = "e")
	public void afterThrowing(JoinPoint jp,String e) {
		
		logger.error("After throwing ");
		System.out.println("passing values : "+jp.getArgs()[0].toString());
		System.out.println("exception message = "+e);
		
	}
	
}
