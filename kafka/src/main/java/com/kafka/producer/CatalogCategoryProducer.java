package com.kafka.producer;

import com.bean.kafka.CatalogCategoryMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * Created by jaiprakash on 12/2/19
 */

@Service
@Slf4j
public class CatalogCategoryProducer {

  @Value("catalog_category")
  private String topic;

  @Autowired
  @Qualifier("kafkaTemplateString")
  private KafkaTemplate<String, String> kafkaTemplate;

  public void send(CatalogCategoryMessage msg) {
    log.info("Sending message=[{}] to topic=[{}]", msg, topic);

    ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, msg.toString());

    future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
      @Override
      public void onFailure(Throwable throwable) {
        log.error(String.format("Failed to send message [%s] to kafka topic [%s]", msg, topic), throwable);
      }

      @Override
      public void onSuccess(SendResult<String, String> sendResult) {
        log.info("Successfully sent message [{}] to kafka topic [{}]", msg, topic);
      }
    });
  }
}
