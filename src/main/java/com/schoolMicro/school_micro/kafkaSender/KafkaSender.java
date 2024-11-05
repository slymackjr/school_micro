package com.schoolMicro.school_micro.kafkaSender;

import com.schoolMicro.school_micro.entity.School;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class KafkaSender {
    private final Logger log = LoggerFactory.getLogger(KafkaSender.class);

    @Autowired
    private KafkaTemplate<String, School> kafkaTemplate;

    @Value("${topic.name}")
    private String topic;

    public void sendMessage(School school) {
        log.info(String.format("\n ===== Producing Message JSON ====== \n"+ school));
        Message<School> message = MessageBuilder.withPayload(school).setHeader(KafkaHeaders.TOPIC, topic).build();
        this.kafkaTemplate.send(topic, school);
    }
}