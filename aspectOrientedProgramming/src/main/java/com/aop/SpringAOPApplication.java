package com.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by jaiprakash on 15/2/19
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.*"})
public class SpringAOPApplication {
  public static void main(String args[]) {
    SpringApplication.run(SpringAOPApplication.class);
  }
}
