package com.mawin.kafka_spring_boot_shopping.OrderService.adapter.in.web;

import com.mawin.kafka_spring_boot_shopping.OrderService.application.CreateOrderUseCase;
import com.mawin.kafka_spring_boot_shopping.OrderService.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/v1/orders")
public class OrderController {
    private final CreateOrderUseCase createOrderUseCase;
    @Autowired
    public OrderController(CreateOrderUseCase createOrderUseCase) {
        this.createOrderUseCase = createOrderUseCase;
    }
    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order) {
        // Validate the order object if necessary
        // For example, check if product and quantity are valid
        if (order.getProduct() == null || order.getQuantity() <= 0) {
            throw new IllegalArgumentException("Invalid order details");
        }
        order.setId(null); // Ensure ID is null for new orders
        return createOrderUseCase.save(order);
    }

}
