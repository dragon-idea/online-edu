package com.longdi.msmservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/8/21 16:43
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@ComponentScan("com.longdi")
public class MsmApplication {
    public static void main( String[] args )
    {
            SpringApplication.run(MsmApplication.class, args);
        }
}
