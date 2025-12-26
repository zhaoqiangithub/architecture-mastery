package com.itlaoqi.aservice.controller;

import com.itlaoqi.aservice.feign.BServiceFeignClient;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class AController {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Resource
    private BServiceFeignClient bServiceFeignClient;

    @GetMapping("/info")
    public Map getInfo(){
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Map result = new LinkedHashMap();
        result.put("staffList",jdbcTemplate.queryForList("select * from staff limit 10"));
        result.put("ActorList", bServiceFeignClient.selectActorList());
        return result;
    }

}
