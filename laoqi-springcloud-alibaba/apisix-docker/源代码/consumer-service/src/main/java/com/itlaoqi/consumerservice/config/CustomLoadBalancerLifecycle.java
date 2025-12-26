package com.itlaoqi.consumerservice.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.CompletionContext;
import org.springframework.cloud.client.loadbalancer.LoadBalancerLifecycle;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.cloud.client.loadbalancer.Response;
import org.springframework.cloud.loadbalancer.core.*;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
@Slf4j
public class CustomLoadBalancerLifecycle implements LoadBalancerLifecycle {
    @Override
    public void onStart(Request request) {
        log.info("Starting load balancing for request: " + request);
    }

    @Override
    public void onStartRequest(Request request, Response lbResponse) {
        log.info("Selected service instance: " + lbResponse.getServer());
    }

    @Override
    public void onComplete(CompletionContext completionContext) {
        // 在负载均衡之后执行的操作
        log.info("Load balancing completed for request: " + completionContext.getLoadBalancerRequest() +
                ", with status: " + completionContext.status());
        log.info("====================================");
    }

}
