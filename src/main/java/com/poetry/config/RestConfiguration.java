package com.poetry.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author xice
 * @time 2019-09-2019/9/17
 */
@Configuration
public class RestConfiguration {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;
    @Bean
    public RestTemplate restTemplate(){
        return restTemplateBuilder.build();
    }
}
