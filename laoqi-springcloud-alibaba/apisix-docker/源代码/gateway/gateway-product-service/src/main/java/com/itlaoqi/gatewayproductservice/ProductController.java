package com.itlaoqi.gatewayproductservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class ProductController {

    // Sample data for products
    private static final List<Product> PRODUCTS = new ArrayList<Product>();
    static {
        PRODUCTS.add(new Product(1L, "iPhone 13", new BigDecimal("699.99")));
        PRODUCTS.add(new Product(2L, "Samsung Galaxy S22", new BigDecimal("899.99")));
        PRODUCTS.add(new Product(3L, "MacBook Air", new BigDecimal("1299.99")));
        PRODUCTS.add(new Product(4L, "Dell XPS 13", new BigDecimal("999.99")));
        PRODUCTS.add(new Product(5L, "iPad Air", new BigDecimal("499.99")));
        PRODUCTS.add(new Product(6L, "Google Pixel 6", new BigDecimal("699.99")));
        PRODUCTS.add(new Product(7L, "Sony PlayStation 5", new BigDecimal("499.99")));
        PRODUCTS.add(new Product(8L, "Nintendo Switch OLED", new BigDecimal("349.99")));
        PRODUCTS.add(new Product(9L, "Bose QuietComfort 35 II", new BigDecimal("299.99")));
        PRODUCTS.add(new Product(10L, "Apple Watch Series 7", new BigDecimal("399.99")));
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        Random random = new Random();
        int count = random.nextInt(20) + 1;
        List<Product> products = new ArrayList<Product>();
        for (int i = 0; i < count; i++) {
            int index = random.nextInt(PRODUCTS.size());
            products.add(PRODUCTS.get(index));
        }
        return products;
    }

    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable Long id) {
        for (Product product : PRODUCTS) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }

    @GetMapping("/product/search")
    public List<Product> searchProducts(@RequestParam("query") String query) {
        Random random = new Random();
        int count = random.nextInt(20) + 1;
        List<Product> products = new ArrayList<Product>();
        for (int i = 0; i < count; i++) {
            int index = random.nextInt(PRODUCTS.size());
            Product product = PRODUCTS.get(index);
            if (product.getName().toLowerCase().contains(query.toLowerCase())) {
                products.add(product);
            }
        }
        return products;
    }

}