package com.api.jlabs.kafka.endpoint;

import com.api.jlabs.kafka.services.KafkaProducer;
import com.api.jlabs.kafka.services.MessageStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by smita on 12/25/17.
 */

@RestController
public class KafkaRestController {

    private KafkaProducer kafkaProducer;
    private MessageStore messageStore;

    @Autowired
    public KafkaRestController(KafkaProducer kafkaProducer, MessageStore messageStore) {
        this.kafkaProducer = kafkaProducer;
        this.messageStore = messageStore;
    }

    @GetMapping(value="/producer")
    public String producer(@RequestParam("data") String data){

        kafkaProducer.sendData(data);
        return "done";
    }

    @GetMapping(value="/consumer")
    public String RecieveAllMessages(){

        String messages = messageStore.toString();
        messageStore.clear();
        return messages;
    }
}
