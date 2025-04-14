package com.mawin.kafka_spring_boot_shopping.OrderService.application;

import com.mawin.kafka_spring_boot_shopping.OrderService.adapter.out.messaging.OrderEventProducer;
import com.mawin.kafka_spring_boot_shopping.OrderService.adapter.out.persistence.OrderEntity;
import com.mawin.kafka_spring_boot_shopping.OrderService.adapter.out.persistence.OrderRepository;
import com.mawin.kafka_spring_boot_shopping.OrderService.domain.Order;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class CreateOrderService implements CreateOrderUseCase {


    @Override
    @Transactional
    public Order save(Order order) {
        // Logic to create an order
        // For example, save the order to the database
        // You can also use a constructor or a method to convert Order to OrderEntity
        OrderEntity orderEntity = new OrderEntity(order.getProduct(), order.getQuantity());
        OrderEntity savedEntity = orderRepository.save(orderEntity);

        // Map saved OrderEntity back to Order
        Order savedOrder = new Order();
        savedOrder.setId(savedEntity.getId());
        savedOrder.setProduct(savedEntity.getProduct());
        savedOrder.setQuantity(savedEntity.getQuantity());
        return savedOrder;
    }

    private final OrderEventProducer orderEventProducer;
    private final OrderRepository orderRepository;

    public CreateOrderService(OrderRepository orderRepository, OrderEventProducer orderEventProducer) {
        this.orderRepository = orderRepository;
        this.orderEventProducer = orderEventProducer;
    }
    @Override
    public Order createOrder(Order order) {
        // Save the order to the database
        OrderEntity orderEntity = new OrderEntity(order.getProduct(), order.getQuantity());
        OrderEntity savedEntity = orderRepository.save(orderEntity);

        // Convert saved entity back to domain object
        Order savedOrder = new Order(savedEntity);

        // Send an event to Kafka
        orderEventProducer.sendOrderCreatedEvent(savedOrder);

        return savedOrder;
    }
}
