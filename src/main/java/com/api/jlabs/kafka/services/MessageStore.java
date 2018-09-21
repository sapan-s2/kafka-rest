package com.api.jlabs.kafka.services;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by smita on 12/25/17.
 */

@Component
public class MessageStore {

    private List<String> messageStored = new ArrayList<>();

    public  void put (String message){
        messageStored.add(message);

    }

    public String toString(){

        StringBuffer stringBuffer = new StringBuffer();
        messageStored.forEach( messageStored -> stringBuffer.append(messageStored));
        return stringBuffer.toString();
    }

    public void clear(){
        messageStored.clear();
    }

}
