package com.bean.kafka;

/**
 * Created by jaiprakash on 12/2/19
 */

public class CatalogCategoryMessage extends KafkaMessage {

  private long id;

  public CatalogCategoryMessage(long id) {
    super();
    this.id = id;
  }

  @Override
  public String toString() {
    return "{" +
        "\"timestamp\":" + timestamp +
        ", \"id\":" + id +
        '}';
  }
}
