package com.itlaoqi.aservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@FeignClient("b-service")
public interface BServiceFeignClient {
    @GetMapping("/actor_list")
    public Map<String,Object> selectActorList();
}
