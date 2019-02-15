package com.kafka.producer;

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
 * Created by jaiprakash on 11/2/19
 */

@Service
@Slf4j
public class KafkaProducerManagerString {

  @Value("test")
  private String topic;

  @Autowired
  @Qualifier("kafkaTemplateString")
  private KafkaTemplate<String, String> kafkaTemplate;

  public void send(final String msg) {
    log.info("sending message='{}' to topic='{}'", msg, topic);

    ListenableFuture<SendResult<String, String>> futuer = kafkaTemplate.send(topic, msg);

    futuer.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
      @Override
      public void onFailure(Throwable throwable) {
        log.error(String.format("Failed to send message [%s] to kafka", msg), throwable);
      }

      @Override
      public void onSuccess(SendResult<String, String> stringStringSendResult) {
        log.info("successfully sent message [{}] to kafka. [{}]", msg, stringStringSendResult.getRecordMetadata().toString());
      }
    });
  }
}
