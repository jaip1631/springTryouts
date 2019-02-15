package com.kafka.consumer;

import com.bean.kafka.KafkaQueueData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * Created by jaiprakash on 11/2/19
 */

@Service
@Slf4j
public class KafkaConsumerManagerKafkaQueueData {

  @KafkaListener(topics = "kafkaqueuedata", containerFactory = "kafkaQueueDataKafkaListenerContainerFactory")
  public void consumeKafkaString(@Payload final KafkaQueueData message,
      @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) final Long messageKey,
      @Header(KafkaHeaders.RECEIVED_PARTITION_ID) final int partitionId,
      @Header(KafkaHeaders.OFFSET) final String offset) {
    log.info("KafkaString received - key: [{}] offset: [{}], partition: [{}], value: [{}]",
        messageKey, offset, partitionId, message);
  }
}
