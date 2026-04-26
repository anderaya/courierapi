package com.ander.courierapi.shared.api.events.ports;

public interface EventPublisherPort {

    <T> void publish(String topic, T event);
}