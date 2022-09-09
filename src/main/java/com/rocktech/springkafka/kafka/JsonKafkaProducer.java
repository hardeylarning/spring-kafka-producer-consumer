package com.rocktech.springkafka.kafka;

import com.rocktech.springkafka.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JsonKafkaProducer {
    @Autowired
    private KafkaTemplate<String, User> userKafkaTemplate;

    public void sendMessage(User user) {
        log.info(String.format("Message sent -> %s", user.toString()));
        Message<User> message = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, "jsonTopic")
                .build();
        userKafkaTemplate.send(message);
    }
}
