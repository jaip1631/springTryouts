package com.bean.kafka;

import java.io.Serializable;
import lombok.Builder;
import lombok.Data;

/**
 * Created by jaiprakash on 11/2/19
 */

@Builder
@Data
public class KafkaQueueData implements Serializable {
  private Long id;

  private String name;

  public static KafkaQueueData buildKafkaQueueData(final Long id, final String name) {
    return
        KafkaQueueData.builder()
            .id(id)
            .name(name)
            .build();
  }
}
