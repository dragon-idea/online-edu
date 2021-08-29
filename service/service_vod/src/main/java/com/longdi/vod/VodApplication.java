package com.longdi.vod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/8/19 0:03
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan(basePackages={"com.longdi"})
@EnableDiscoveryClient
public class VodApplication {
    public static void main( String[] args )
    {
            SpringApplication.run(VodApplication.class, args);
        }
}
