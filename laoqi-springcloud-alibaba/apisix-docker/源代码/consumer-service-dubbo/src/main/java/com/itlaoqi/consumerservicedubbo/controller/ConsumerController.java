package com.itlaoqi.consumerservicedubbo.controller;

import com.itlaoqi.providerservicedubbo.dubbo.ProviderService;
import com.itlaoqi.providerservicedubbo.dto.User;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerController {
    @DubboReference
    private ProviderService providerService;
    @GetMapping("/list")
    public List<User> list(int page, int rows) {
        return providerService.query(page, rows);
    }
}
