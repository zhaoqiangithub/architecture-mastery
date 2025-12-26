package com.itlaoqi.sentinelnacosconfig.controller;

import com.itlaoqi.sentinelnacosconfig.service.SampleService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class SentinelSampleController {
    //演示用的业务逻辑类
    @Resource
    private SampleService sampleService;

    /**
     * 流控测试接口
     * @return
     */
    @GetMapping("/test_flow_rule")
    public ResponseObject testFlowRule(){
        //code=0代表服务器处理成功
        return new ResponseObject("0","success!");
    }

    /**
     * 熔断测试接口
     * @return
     */
    @GetMapping("/test_degrade_rule")
    public String testDegradeRule() {
        int ex = new Random().nextInt(100);
        if (ex > 70) {
            throw new RuntimeException("Unexpected exception");
        }
        return "SUCCESS";
    }
}