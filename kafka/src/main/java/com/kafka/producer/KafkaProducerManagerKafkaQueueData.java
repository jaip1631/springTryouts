package com.kafka.producer;

import com.bean.kafka.KafkaQueueData;
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
public class KafkaProducerManagerKafkaQueueData {

  @Value("kafkaqueuedata")
  private String topic;

  @Autowired
  @Qualifier(value = "kafkaTempalteKafkaQueueData")
  KafkaTemplate<Long, KafkaQueueData> kafkaTemplate;


  public void send(final KafkaQueueData msg) {
    log.info("sending message='{}' to topic='{}'", msg, topic);

    ListenableFuture<SendResult<Long, KafkaQueueData>> futuer = kafkaTemplate.send(topic, msg.getId(), msg);

    futuer.addCallback(new ListenableFutureCallback<SendResult<Long, KafkaQueueData>>() {
      @Override
      public void onFailure(Throwable throwable) {
        log.error(String.format("Failed to send message [%s] to kafka", msg), throwable);
      }

      @Override
      public void onSuccess(SendResult<Long, KafkaQueueData> stringStringSendResult) {
        log.info("successfully sent message [{}] to kafka. [{}]", msg, stringStringSendResult.getRecordMetadata().toString());
      }
    });
  }
}
