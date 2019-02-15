package com.aop.aspect;

import com.aop.aspect.annotation.Greet;
import java.lang.reflect.Method;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by jaiprakash on 15/2/19
 */

@Aspect
@Component
public class GreetingAspect {

  @After("@annotation(com.aop.aspect.annotation.Greet)")
  public void greetThem(JoinPoint joinPoint) throws Throwable{
    MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
    Method method = joinPoint.getTarget().getClass().getMethod(
        methodSignature.getMethod().getName(),
        methodSignature.getMethod().getParameterTypes());

    Greet greetAnnotation = method.getAnnotation(Greet.class);
    switch (greetAnnotation.type()) {
      case GOOD_BYE:
        System.out.println("Good Bye!!");
        break;

      case ALL_THE_BEST:
        System.out.println("All the Best!!");
        break;

      default:
        System.out.println("DEFAULT GREETING...");
        break;
    }
  }
}
