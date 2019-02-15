package com.kafka.consumer;

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
public class KafkaConsumerManagerString {

  @KafkaListener(topics = "test"/*, containerFactory = "stringKafkaListenerContainerFactory"*/)
  public void consumeKafkaString(@Payload final String message,
      @Header(KafkaHeaders.RECEIVED_PARTITION_ID) final int partitionId,
      @Header(KafkaHeaders.OFFSET) final String offset) {
    log.info("KafkaString received - offset: [{}], partition: [{}], value: [{}]",
        offset, partitionId, message);
  }
}
