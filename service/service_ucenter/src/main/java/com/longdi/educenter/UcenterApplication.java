package com.longdi.educenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/8/21 22:57
 */
@ComponentScan({"com.longdi"})
@SpringBootApplication
@MapperScan("com.longdi.educenter.mapper")
@EnableDiscoveryClient
public class UcenterApplication {
public static void main( String[] args )
{
        SpringApplication.run(UcenterApplication.class, args);
    }

}
