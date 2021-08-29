package com.longdi.staservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/8/25 11:52
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.longdi"})
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.longdi.staservice.mapper")
@EnableScheduling
public class StaApplication {
    public static void main( String[] args )
    {
            SpringApplication.run(StaApplication.class, args);
        }
}
