package com.example.AopAndLog.aopConfigurations;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BeforeAndAfterImpl {
	
	Logger logger= LoggerFactory.getLogger("  Aspect  ");
	
	//               returnType               pkg              class           method  parameterValue
	@Before("execution(String com.example.AopAndLog.controller.HelloController.sayHello(..))")
	public void before() {
		logger.error("Before Msg From AOP ....");
	}
	

	@After("execution(* com.example.AopAndLog.controller.HelloController.*(..))")
	public void after() {
		logger.error("After Msg From AOP ....");
	}
	
	//@Pointcut("within(com.example.AopAndLog.controller.HelloController.*)")
	
	@Pointcut("execution(String com.example.AopAndLog.controller.HelloController.sayHello(..))")
    public void autheticate() {
		
	}
	
	@Pointcut("execution(String com.example.AopAndLog.controller.HelloController.sayHi(..))")
    public void autheticate2() {
		
	}
	
	@After("autheticate() || autheticate2()")
	public void after2() {
		logger.error("After using Commen Pointcut Msg From AOP ....");
	}
	
	
	
	
	
	
	
	
	
	
//	@Around("execution(* com.example.AopAndLog.controller.HelloController.*(..))")
//	public void around() {
//		logger.error("Arount Msg From AOP ....");
//	}

}
