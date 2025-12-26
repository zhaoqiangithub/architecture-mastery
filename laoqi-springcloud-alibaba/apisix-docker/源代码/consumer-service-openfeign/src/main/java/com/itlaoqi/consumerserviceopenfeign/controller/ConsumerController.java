package com.itlaoqi.consumerserviceopenfeign.controller;

import com.itlaoqi.consumerserviceopenfeign.dto.User;
import com.itlaoqi.consumerserviceopenfeign.feignclient.ProviderServiceFeignClient;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerController {
    @Resource
    private ProviderServiceFeignClient providerServiceFeignClient;
    @GetMapping("/do1")
    public List doSth1(){
        List<User> userList = providerServiceFeignClient.query(1, 10);
        return userList;
    }

    @GetMapping("/do2")
    public User doSth2(){
        String uid="10";
        User user = providerServiceFeignClient.createUser(uid, new User(uid, "testUser", "testPassword", "testNickname"));
        return user;
    }

    @GetMapping("/do3")
    public String doSth3(){
        String result = providerServiceFeignClient.hello();
        return result;
    }
}
