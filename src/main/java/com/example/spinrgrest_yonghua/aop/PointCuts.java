package com.example.spinrgrest_yonghua.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointCuts {
	@Pointcut("within(com.example.spinrgrest_yonghua.controller.*)")
	public void inControllerLayer(){}
}
