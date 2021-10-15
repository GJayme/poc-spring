package com.example.pocsimplespring.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TopicProducer {

    @Value("${topic.name.producer}")
    private String topicName;

    // é responsável por envio de mensagens para os tópicos, o primeiro String é o tópico e o segundo é o tipo de infromacão
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void send(String message) {
        log.info("Payload enviado: {}", message);
        kafkaTemplate.send(topicName, message);
    }
}
