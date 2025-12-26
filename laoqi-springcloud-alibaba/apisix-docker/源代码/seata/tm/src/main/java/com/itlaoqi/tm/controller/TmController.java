package com.itlaoqi.tm.controller;

import com.itlaoqi.tm.service.TmService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TmController {
    @Resource
    private TmService tmService;
    /*
     * http://localhost:8000/sale?orderId=6&memberId=1&goodsId=2&points=20&quantity=20
     */
    @GetMapping("/sale")
    public String sale(Integer orderId,Integer memberId,Integer goodsId,Integer points,Integer quantity){
        return tmService.sale(orderId,memberId,goodsId,points,quantity);
    }
}
