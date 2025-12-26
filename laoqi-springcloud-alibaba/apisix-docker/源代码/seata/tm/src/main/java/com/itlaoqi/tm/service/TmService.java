package com.itlaoqi.tm.service;

import com.itlaoqi.tm.feignclient.Rm1FeignClient;
import com.itlaoqi.tm.feignclient.Rm2FeignClient;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TmService {
    @Resource
    Rm1FeignClient orderFeignClient;
    @Resource
    Rm2FeignClient storageFeignClient;

    @GlobalTransactional(name = "seata-group-tx-mall", rollbackFor = {Exception.class})
    public String sale(Integer orderId,Integer memberId,Integer goodsId,Integer points,Integer quantity) {
        String orderResult = orderFeignClient.createOrder(orderId,memberId,goodsId,points,quantity);
        String storageResult = storageFeignClient.reduceStorage(goodsId, quantity);
        return orderResult + "/" + storageResult;
    }

}
