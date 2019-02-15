package com.bean.kafka;


public class KafkaMessage {

    protected long timestamp;

    public KafkaMessage(){
        timestamp = System.currentTimeMillis();
    }


}
