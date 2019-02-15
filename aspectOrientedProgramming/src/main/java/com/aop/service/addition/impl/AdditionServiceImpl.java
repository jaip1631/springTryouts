package com.aop.service.addition.impl;

import com.aop.aspect.annotation.Greet;
import com.aop.service.addition.AdditionService;
import org.springframework.stereotype.Service;

/**
 * Created by jaiprakash on 15/2/19
 */

@Service
public class AdditionServiceImpl implements AdditionService {

  @Override
  @Greet
  public Integer add(Integer a, Integer b) {
    return a+b;
  }

  @Override
  public void sayHello() {
    System.out.println("Saying Hello!");
  }
}
