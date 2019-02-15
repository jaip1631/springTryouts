package com.controller;

import com.bean.kafka.CatalogCategoryMessage;
import com.bean.kafka.KafkaQueueData;
import com.kafka.producer.CatalogCategoryProducer;
import com.kafka.producer.KafkaProducerManagerKafkaQueueData;
import com.kafka.producer.KafkaProducerManagerString;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jaiprakash on 11/2/19
 */

@RestController
public class KafkaController {

  @Autowired
  KafkaProducerManagerString kafkaStringService;

  @Autowired
  KafkaProducerManagerKafkaQueueData kafkaQueueDataService;

  @Autowired
  CatalogCategoryProducer catalogCategoryProducer;

  @RequestMapping(value = "/pushToStringTopic/{message}")
  public String pushToStringTopic(@PathVariable(value = "message") final String message) {
    kafkaStringService.send(message);
    return "Pushed to Kafka";
  }


  @RequestMapping(value = "/pushToKafkaQueuDataTopic/id/{id}/name/{name}")
  public String pushToStringTopic(@NonNull @PathVariable(value = "id") long id,
      @PathVariable(value = "name") final String name) {
    KafkaQueueData data = KafkaQueueData.builder()
        .id(id)
        .name(name)
        .build();
    kafkaQueueDataService.send(data);
    return "Pushed to Kafka";
  }


  @RequestMapping(value = "/pushToCatalogCategoryTopic/id/{id}")
  public String pushToStringTopic(@NonNull @PathVariable(value = "id") long id) {
    CatalogCategoryMessage data = new CatalogCategoryMessage(id);
    catalogCategoryProducer.send(data);
    return "Pushed to Kafka";
  }
}
