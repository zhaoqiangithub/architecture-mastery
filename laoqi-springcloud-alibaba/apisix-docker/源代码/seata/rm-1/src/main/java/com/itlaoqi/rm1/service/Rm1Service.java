package com.itlaoqi.rm1.service;

import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class Rm1Service {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void createOrder(Integer orderId,Integer memberId,Integer goodsId,Integer points,Integer quantity){
        jdbcTemplate.update("INSERT INTO `rm-db-1`.`order`(`order_id`, `goods_id`, `member_id`, `quantity`, `points`) VALUES (?, ?, ?, ?, ?);",new Object[]{
                orderId,memberId,goodsId,quantity,0
        });
    }
}
