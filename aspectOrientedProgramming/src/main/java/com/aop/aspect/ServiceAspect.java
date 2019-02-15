package com.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * Created by jaiprakash on 15/2/19
 */

@Aspect
@Slf4j
@Component
public class ServiceAspect {

  @Pointcut("execution(* com.aop.service.addition..*(..))")
  public void additionServiceMethods(){}

  @Around("additionServiceMethods()")
  public Object profile(ProceedingJoinPoint joinPoint) throws Throwable{
    long startTimeMS = System.currentTimeMillis();
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    Object returnObj = joinPoint.proceed();
    long timeTaken = System.currentTimeMillis() - startTimeMS;

    log.info(String.format("Time Taken to execute : [%s] [%d] ms", signature, timeTaken));

    return returnObj;
  }
}
