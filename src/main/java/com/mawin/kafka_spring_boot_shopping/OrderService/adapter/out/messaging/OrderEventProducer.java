package com.mawin.kafka_spring_boot_shopping.OrderService.adapter.out.messaging;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mawin.kafka_spring_boot_shopping.OrderService.domain.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderEventProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public OrderEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderCreatedEvent(Order order) {
        try {
            String message = objectMapper.writeValueAsString(order);
            kafkaTemplate.send("order-created", message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to send order created event", e);
        }
    }


}
