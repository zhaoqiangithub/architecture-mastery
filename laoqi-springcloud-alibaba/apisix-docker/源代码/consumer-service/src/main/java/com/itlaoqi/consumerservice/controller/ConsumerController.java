package com.itlaoqi.consumerservice.controller;

import com.itlaoqi.consumerservice.config.CustomLoadBalancerConfiguration;
import jakarta.annotation.Resource;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@LoadBalancerClient(value = "loadbalancer", configuration = CustomLoadBalancerConfiguration.class)
public class ConsumerController {
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/remote-call")
    public String  remoteCall(){
        String result = restTemplate.getForObject("http://provider-service/hello", String.class);
        return "remote:" + result;
    }
}
