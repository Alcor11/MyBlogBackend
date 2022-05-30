package com.alcor.tobacco;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.alcor.tobacco.mapper")
public class TobaccoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TobaccoApplication.class, args);
    }

}
