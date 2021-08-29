package com.longdi.eduorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/8/24 15:35
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.longdi"})
@MapperScan("com.longdi.eduorder.mapper")
@EnableDiscoveryClient
@EnableFeignClients
public class OrdersApplication {
    public static void main( String[] args )
    {
            SpringApplication.run(OrdersApplication.class, args);
        }
}
