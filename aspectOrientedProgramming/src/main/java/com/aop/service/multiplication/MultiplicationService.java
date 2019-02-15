package com.aop.service.multiplication;

import com.aop.aspect.annotation.Greet;
import com.aop.enums.GreetingType;

/**
 * Created by jaiprakash on 15/2/19
 */
public interface MultiplicationService {

  public Integer multiply(Integer a, Integer b);
}
