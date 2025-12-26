package com.itlaoqi.consumerservice;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@Slf4j
class ConsumerServiceApplicationTests {
    @Resource
    private RestTemplate restTemplate;
    @Test
    public void hello(){
        for(int i = 0 ; i < 10 ; i++){
            String result = restTemplate.getForObject("http://provider-service/hello", String.class);
            log.info(result);
        }
    }
}
