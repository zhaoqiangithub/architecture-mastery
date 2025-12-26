package com.itlaoqi.consumerserviceopenfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ConsumerServiceOpenfeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerServiceOpenfeignApplication.class, args);
    }

}
