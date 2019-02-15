package com.aop.service.addition;

import com.aop.aspect.annotation.Greet;

/**
 * Created by jaiprakash on 15/2/19
 */

public interface AdditionService {

  public Integer add(Integer a, Integer b);

  public void sayHello();
}
