package com.itlaoqi.gatewayproductservice;

import lombok.Data;

import java.math.BigDecimal;

@Data
class Product {
    private Long id;
    private String name;
    private BigDecimal price;

    public Product(Long id, String name, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}