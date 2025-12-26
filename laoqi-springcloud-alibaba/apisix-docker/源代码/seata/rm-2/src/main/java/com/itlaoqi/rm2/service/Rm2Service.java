package com.itlaoqi.rm2.service;

import jakarta.annotation.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;


@Service
public class Rm2Service {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void reduceStorage(Integer goodsId, Integer quantity){
        List<Map<String, Object>> storageList = jdbcTemplate.queryForList("select * from storage where goods_id = ?", new Object[]{goodsId});
        if(storageList.size() == 0){
            throw new IllegalStateException("no matching product");
        }
        int count = Integer.parseInt(storageList.get(0).get("quantity").toString());
        if(count < quantity){
            throw new IllegalStateException("out of stock");
        }

        jdbcTemplate.update("update storage set quantity = ? where goods_id = ?", new Object[]{count - quantity, goodsId});
    }
}
