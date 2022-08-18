package com.example.spinrgrest_yonghua.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@AfterThrowing(value = "com.example.spinrgrest_yonghua.aop.PointCuts.inControllerLayer()", throwing = "ex")
	public void logThrownException(JoinPoint joinPoint, Throwable ex){
		logger.error("From LoggingAspect.logThrownException in controller: " + ex.getMessage() + ": " + joinPoint.getSignature());
	}

	@After(value = "com.example.spinrgrest_yonghua.aop.PointCuts.inControllerLayer()")
	public void logControllerInvocation(JoinPoint joinPoint){
		logger.error("From LoggingAspect.logControllerInvocation in controller: " +  joinPoint.getSignature());
	}




}
