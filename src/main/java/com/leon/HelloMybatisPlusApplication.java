package com.leon;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.leon.mapper.**")
@SpringBootApplication
public class HelloMybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloMybatisPlusApplication.class, args);
    }

}
