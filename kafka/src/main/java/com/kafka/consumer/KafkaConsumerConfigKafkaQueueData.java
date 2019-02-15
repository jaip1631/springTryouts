package com.kafka.consumer;

import com.bean.kafka.KafkaQueueData;
import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

/**
 * Created by jaiprakash on 11/2/19
 */

@EnableKafka
@Configuration
public class KafkaConsumerConfigKafkaQueueData {

  @Value("localhost:9092")
  private String kafkaServers;

  @Value("kafkaqueuedatagroupid")
  private String groupId;

  @Bean("kafkaQueueDataConsumerFactory")
  public ConsumerFactory<Long, KafkaQueueData> consumerFactory() {
    Map<String, Object> configProps = new HashMap<>();

    configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaServers);
    configProps.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
    //configProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
    configProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
    configProps.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 1);

    return
        new DefaultKafkaConsumerFactory<>(
            configProps,
            new LongDeserializer(),
            new JsonDeserializer<>(KafkaQueueData.class)
            );
    /*
     DefaultKafkaConsumerFactory<Long, KafkaQueueData> defaultFactory =
        new DefaultKafkaConsumerFactory<>(configProps);

      defaultFactory.setKeyDeserializer(new LongDeserializer());
      defaultFactory.setValueDeserializer(new JsonDeserializer<>(KafkaQueueData.class));

      return defaultFactory;
    */
  }

  @Bean("kafkaQueueDataKafkaListenerContainerFactory")
  public ConcurrentKafkaListenerContainerFactory<Long, KafkaQueueData> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<Long, KafkaQueueData> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());

    return factory;
  }
}
