package com.itlaoqi.gatewayorderservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class OrderController {
    
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        // TODO: Implement logic to get all orders from the database
        List<Order> orders = new ArrayList<Order>();
        int numOrders = (int) (Math.random() * 20); // generate random number of orders
        for (int i = 0; i < numOrders; i++) {
            Order order = new Order();
            order.setId((long) i);
            order.setTotalPrice(BigDecimal.valueOf(Math.random() * 100));
            order.setQuantity((int) (Math.random() * 5) + 1); // generate random quantity between 1 and 5
            orders.add(order);
        }
        return orders;
    }
    
    @GetMapping("/order/{id}")
    public Order getOrderById(@PathVariable Long id) {
        // TODO: Implement logic to get order by ID from the database
        Order order = new Order();
        order.setId(id);
        order.setTotalPrice(BigDecimal.valueOf(Math.random() * 100));
        order.setQuantity((int) (Math.random() * 5) + 1); // generate random quantity between 1 and 5
        return order;
    }
    
    @GetMapping("/order/search")
    public List<Order> searchOrders(@RequestParam("query") String query) {
        // TODO: Implement logic to search orders in the database
        List<Order> orders = new ArrayList<Order>();
        int numOrders = (int) (Math.random() * 10) + 1; // generate random number of orders between 1 and 10
        for (int i = 0; i < numOrders; i++) {
            Order order = new Order();
            order.setId((long) i);
            order.setTotalPrice(BigDecimal.valueOf(Math.random() * 100));
            order.setQuantity((int) (Math.random() * 5) + 1); // generate random quantity between 1 and 5
            orders.add(order);
        }
        return orders;
    }
}
