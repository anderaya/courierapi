package com.ander.courierapi.shared.infrastructure.ports;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.ander.courierapi.shared.api.events.ports.EventPublisherPort;

@Component
public class KafkaEventPublisher implements EventPublisherPort {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public KafkaEventPublisher(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public <T> void publish(String topic, T event) {
        kafkaTemplate.send(topic, event);
    }
}