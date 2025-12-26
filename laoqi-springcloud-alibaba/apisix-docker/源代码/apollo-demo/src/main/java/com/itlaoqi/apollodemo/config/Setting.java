package com.itlaoqi.apollodemo.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
@Data
@Slf4j
public class Setting {
    @Value("${setting.upload-addr}")
    private String uploadAddr;
    @Value("${setting.path}")
    private String path;
}
