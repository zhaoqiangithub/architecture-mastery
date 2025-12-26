package com.zq.firstmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
public class FirstMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstMicroserviceApplication.class, args);
    }

}
