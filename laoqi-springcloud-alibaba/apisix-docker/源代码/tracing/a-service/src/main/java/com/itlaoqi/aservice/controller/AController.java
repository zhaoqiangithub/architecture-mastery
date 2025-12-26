package com.itlaoqi.aservice.controller;

import com.itlaoqi.aservice.feign.BServiceFeignClient;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AController {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Resource
    private BServiceFeignClient bServiceFeignClient;

    @GetMapping("/info")
    public Map getInfo(){
        Map result = new LinkedHashMap();
        result.put("staffList",jdbcTemplate.queryForList("select * from staff limit 10"));
        result.put("ActorList", bServiceFeignClient.selectActorList());
        return result;
    }

}
