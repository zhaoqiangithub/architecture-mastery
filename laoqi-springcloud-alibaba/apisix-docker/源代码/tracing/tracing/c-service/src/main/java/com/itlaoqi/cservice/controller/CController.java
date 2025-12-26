package com.itlaoqi.cservice.controller;

import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
public class CController {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/film_list")
    public List<Map<String,Object>> selectFilmList(){
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return jdbcTemplate.queryForList("select * from film limit 10");
    }
}
