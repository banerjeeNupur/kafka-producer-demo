package com.kafka.producerexample.resource;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.kafka.producerexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResource {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;
    private static final String TOPIC = "test";

    @GetMapping("/publish")
    public String post(){
        User user = new User("nupur","tech");
        ObjectMapper Obj = new ObjectMapper();
        try{
            String jsonStr = Obj.writeValueAsString(user);
            kafkaTemplate.send(TOPIC,jsonStr);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "Published successfully";
    }
}
