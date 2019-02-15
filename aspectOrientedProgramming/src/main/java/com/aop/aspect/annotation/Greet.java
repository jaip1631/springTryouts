package com.aop.aspect.annotation;

import com.aop.enums.GreetingType;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by jaiprakash on 15/2/19
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Greet {
  GreetingType type() default GreetingType.GOOD_BYE;
}
