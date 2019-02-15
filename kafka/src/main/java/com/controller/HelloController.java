package com.controller;

import com.bean.kafka.KafkaQueueData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jaiprakash on 8/2/19
 */

@RestController
public class HelloController {

  @RequestMapping("/")
  public String index() {
    return "Hello World!";
  }

  @RequestMapping("/buildKafkaQueueData/id/{id}/name/{name}")
  public String buildKafkaQueueData(@PathVariable(value = "id") long id,
      @PathVariable(value = "name") final String name) {
    return
        KafkaQueueData.builder()
            .id(id)
            .name(name)
            .build()
            .toString();
  }
}
