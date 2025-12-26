package com.itlaoqi.sentineldashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@RestController
public class SentinelSampleController {
    @GetMapping("/test_flow_rule")
    public String testFlowRule() {
        try {
            Thread.sleep(new Random().nextInt(100));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "SUCCESS";
    }

    @GetMapping("/test_degrade_rule")
    public String testDegradeRule() {
        int ex = new Random().nextInt(100);
        if (ex > 70) {
            throw new RuntimeException("Unexpected exception");
        }
        return "SUCCESS";
    }


    @GetMapping("/relate")
    public String testFlowRule1() {
        return "SUCCESS";
    }

}