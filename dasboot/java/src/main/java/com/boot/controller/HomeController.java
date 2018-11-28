package com.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jaiprakash on 21/11/18
 */

@RestController
public class HomeController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String home() {
    return "Das Boot, reporting for duty!";
  }
}
