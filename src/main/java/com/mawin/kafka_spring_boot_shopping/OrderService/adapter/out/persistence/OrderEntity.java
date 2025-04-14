package com.mawin.kafka_spring_boot_shopping.OrderService.adapter.out.persistence;

import com.mawin.kafka_spring_boot_shopping.OrderService.domain.Order;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product;
    private int quantity;

    public OrderEntity(Order order) {
    }
    public OrderEntity(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public OrderEntity() {

    }

    public OrderEntity(OrderEntity order) {
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

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
