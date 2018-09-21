package com.api.jlabs.kafka.services;

import com.api.jlabs.kafka.domain.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smita on 12/25/17.
 */

@Component
public class KafkaEmployeeConsumer {

    private final static  Logger LOGGER = LoggerFactory.getLogger(KafkaEmployeeConsumer.class);

//    @Autowired
//    MessageStore messageStore;


    private List<String> employees = new ArrayList<>();

    @KafkaListener(topics ="${jlabs.kafka.employee.topic}"
            ,containerFactory = "kafkaListenerContainerFactory"
    )
        public void processMessage(String content){

        LOGGER.info("received messages : {} ", content);
        employees.add(content);

        }


    public List<String> getEmployees(){
        return employees;
    }

}
