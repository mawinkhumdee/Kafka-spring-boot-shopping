package com.mawin.kafka_spring_boot_shopping.OrderService.adapter.out.persistence;

import com.mawin.kafka_spring_boot_shopping.OrderService.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
    // Custom query methods can be defined here if needed

}
