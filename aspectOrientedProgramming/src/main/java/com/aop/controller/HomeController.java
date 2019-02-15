package com.aop.controller;

import com.aop.service.addition.impl.*;
import com.aop.service.addition.AdditionService;
import com.aop.service.multiplication.MultiplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jaiprakash on 15/2/19
 */

@RestController
@Slf4j
public class HomeController {

  @Autowired
  AdditionService additionService;

  @Autowired
  MultiplicationService multiplicationService;

  @Autowired
  TempService tempService;

  @RequestMapping("/")
  public String helloWorld() {
    additionService.sayHello();
    tempService.sayHello();
    return "HelloWorld";
  }

  @RequestMapping("/addInt/{a}/{b}")
  public Integer addInt(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
    return additionService.add(a, b);
  }

  @RequestMapping("/mulInt/{a}/{b}")
  public Integer mulInt(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
    return multiplicationService.multiply(a, b);
  }
}
