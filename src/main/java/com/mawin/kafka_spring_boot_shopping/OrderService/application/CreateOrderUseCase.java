package com.mawin.kafka_spring_boot_shopping.OrderService.application;

import com.mawin.kafka_spring_boot_shopping.OrderService.adapter.out.persistence.OrderEntity;
import com.mawin.kafka_spring_boot_shopping.OrderService.domain.Order;

public interface CreateOrderUseCase {
    Order save(Order order);

    Order createOrder(Order order);
}
