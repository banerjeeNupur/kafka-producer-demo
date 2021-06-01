package com.kafka.producerexample.resource;

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
    KafkaTemplate<String, User> kafkaTemplate;
    private static final String TOPIC = "testTopic";

    @GetMapping("/publish")
    public String post(){

        kafkaTemplate.send(TOPIC,new User("nupur","tech"));
        return "Published successfully";
    }
}
