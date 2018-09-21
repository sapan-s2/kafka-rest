package com.api.jlabs.kafka.endpoint;

import com.api.jlabs.kafka.domain.Employee;
import com.api.jlabs.kafka.services.KafkaEmployeeConsumer;
import com.api.jlabs.kafka.services.KafkaEmployeeProducer;
import com.api.jlabs.kafka.services.MessageStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by smita on 12/25/17.
 */

@RestController
public class KafkaRestEmployeeController {

  @Autowired
    KafkaEmployeeProducer employeeProducer;

  @Autowired
    KafkaEmployeeConsumer employeeConsumer;

    @Autowired
    private MessageStore messageStore;

    @PostMapping(value = "/employee")
    public Employee saveEmployee(@RequestBody Employee employee){
        employeeProducer.sendData(employee);
       return employee;
    }

    @GetMapping(value = "/employee")
    public List<String> getEmployee(){
       return employeeConsumer.getEmployees();
    }
}
