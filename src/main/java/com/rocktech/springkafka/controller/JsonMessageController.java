package com.rocktech.springkafka.controller;

import com.rocktech.springkafka.kafka.JsonKafkaProducer;
import com.rocktech.springkafka.kafka.KafkaProducer;
import com.rocktech.springkafka.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/kafka")
public class JsonMessageController {
    @Autowired
    private JsonKafkaProducer kafkaProducer;

    @PostMapping("publish")
    public ResponseEntity<String> publish(@RequestBody User user) {
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to the topic");
    }
}
