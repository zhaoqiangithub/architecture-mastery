package com.itlaoqi.bservice.controller;

import com.itlaoqi.bservice.feign.CServiceFeignClient;
import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class BController {
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Resource
    CServiceFeignClient cServiceFeignClient;

    @GetMapping("/actor_list")
    public Map selectActorList(){
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Map result = new LinkedHashMap();
        result.put("actorList",jdbcTemplate.queryForList("select * from actor limit 10"));
        result.put("filmList", cServiceFeignClient.selectFilmList());
        return result;
    }
}
