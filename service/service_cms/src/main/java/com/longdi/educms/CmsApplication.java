package com.longdi.educms;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: 龍弟
 * @description
 * @date: 2021/8/20 17:28
 */

@SpringBootApplication
@ComponentScan("com.longdi")
@MapperScan("com.longdi.educms.mapper")
public class CmsApplication {
    public static void main( String[] args )
    {
            SpringApplication.run(CmsApplication.class, args);
        }
}
