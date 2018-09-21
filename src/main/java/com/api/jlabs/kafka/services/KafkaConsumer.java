package com.api.jlabs.kafka.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by sjain on 12/25/17.
 */

@Component
//@EnableKafka
public class KafkaConsumer {

    private final static  Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);

    @Autowired
    MessageStore messageStore;

    @KafkaListener(topics ="${jlabs.kafka.topic}",group = "${spring.kafka.consumer.group-id}")
        public void processMessage(String content){
        LOGGER.info("received messages : {} ", content);
        messageStore.put(content);

        }

}
