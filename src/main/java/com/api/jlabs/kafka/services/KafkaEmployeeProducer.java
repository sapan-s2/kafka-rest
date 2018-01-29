package com.api.jlabs.kafka.services;

import com.api.jlabs.kafka.domain.Employee;
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
public class KafkaEmployeeProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaEmployeeProducer.class);

    @Autowired
    private KafkaTemplate<String,Employee> kafkaTemplate;


    @Value("${jlabs.kafka.employee.topic}")
    String kafkaTopic;

    public void sendData(Employee data){
        LOGGER.info("Sending Employee : '{}'", data);
        kafkaTemplate.send(kafkaTopic,data);
    }

}
