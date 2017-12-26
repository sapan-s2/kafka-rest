package com.api.jlabs.kafka.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by smita on 12/25/17.
 */

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @Value("${jlabs.kafka.topic}")
    String kafkaTopic;

    public void sendData(String data){
        LOGGER.info("Sending Data :", data);
        kafkaTemplate.send(kafkaTopic,data);
    }

}
