package com.pyy.pharmacy.common.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@MapperScan("com.pyy.pharmacy.order.controller")
@Configuration
public class RestTemplateConfig {
    //nacos
    @Bean
    @LoadBalanced  //负载均衡器注解
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        RestTemplate restTemplate = builder.build();
        return restTemplate;
    }

}
