package com.bean.kafka;


import java.time.LocalDateTime;
import org.junit.Test;

/**
 * Created by jaiprakash on 11/2/19
 */


public class KafkaQueueDataTest {

  @Test
  public void TestToStringMethod() {
    KafkaQueueData data = KafkaQueueData.builder()
        .id(1l)
        .name("Jai")
        .build();

    System.out.println(data.toString());
  }

}
