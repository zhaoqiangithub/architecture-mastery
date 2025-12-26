package com.itlaoqi.bservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;

@FeignClient("c-service")
public interface CServiceFeignClient {
    @GetMapping("/film_list")
    public List<Map<String,Object>> selectFilmList();
}
