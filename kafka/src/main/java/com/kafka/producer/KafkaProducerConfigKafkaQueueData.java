package com.kafka.producer;

import com.bean.kafka.KafkaQueueData;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

/**
 * Created by jaiprakash on 11/2/19
 */

@Configuration
public class KafkaProducerConfigKafkaQueueData {

  @Value("localhost:9092")
  private String kafkaServerAddress;

  @Bean("KafkaQueueDataProducerFactory")
  public ProducerFactory<Long, KafkaQueueData> producerFactory() {
    Map<String, Object> configProps = new HashMap<>();

    /*kafka server address commaSeparated like 172.26.133.199:9092,172.26.132.72:9092*/
    configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServerAddress);

    /*kafka acknowledge after all leaders and followers have commited the data.
    Slowest but most durable*/
    configProps.put(ProducerConfig.ACKS_CONFIG, "all");

    //acts as key which decides partition after hashing
    configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class);

    configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

    /*Enabling retries also opens up the possibility of duplicates*/
    configProps.put(ProducerConfig.RETRIES_CONFIG, 5);

    /*wait up to that number of milliseconds before sending a request in hope that more records
    will arrive to fill up the same batch*/
    configProps.put(ProducerConfig.LINGER_MS_CONFIG, 1000);

    /*The maximum amount of data that can be sent in a single request. If batch.size is (32*1024)
    that means 32 KB can be sent out in a single request.*/
    configProps.put(ProducerConfig.BATCH_SIZE_CONFIG, 100);

    /* if Kafka Producer is not able to send messages(batches) to Kafka broker (Say broker is down).
     It starts accumulating the message batches in the buffer memory (default 32 MB).
     Once the buffer is full, It will wait for "max.block.ms" (default 60,000ms) so that buffer can
     be cleared out. Then it's throw exception.*/
    configProps.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 50000);

    return new DefaultKafkaProducerFactory<>(configProps);
  }

  @Bean(name = "kafkaTempalteKafkaQueueData")
  public KafkaTemplate<Long, KafkaQueueData> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }

}
