package com.mawin.kafka_spring_boot_shopping.OrderService.domain;

import com.mawin.kafka_spring_boot_shopping.OrderService.adapter.out.persistence.OrderEntity;

public class Order {
    private Long id;
    private String product;
    private int quantity;

    public Order(){}

    public Order(OrderEntity savedEntity) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
