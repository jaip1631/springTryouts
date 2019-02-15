package com.aop.service.multiplication.impl;

import com.aop.aspect.annotation.Greet;
import com.aop.enums.GreetingType;
import com.aop.service.multiplication.MultiplicationService;
import org.springframework.stereotype.Service;

/**
 * Created by jaiprakash on 15/2/19
 */

@Service
public class MultiplicationServiceImpl implements MultiplicationService {

  @Override
  @Greet(type = GreetingType.ALL_THE_BEST)
  public Integer multiply(Integer a, Integer b) {
    return a*b;
  }
}
