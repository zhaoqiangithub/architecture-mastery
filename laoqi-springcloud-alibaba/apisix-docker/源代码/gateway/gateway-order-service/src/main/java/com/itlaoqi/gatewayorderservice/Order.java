package com.itlaoqi.gatewayorderservice;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private Long id;
    private BigDecimal totalPrice;
    private Integer quantity;

    public Order() {}

    public Order(Long id, BigDecimal totalPrice, Integer quantity) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
    }
}
