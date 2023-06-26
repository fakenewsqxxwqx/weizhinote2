package com.example.weizhinote2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.weizhinote2.mapper")
public class Weizhinote2Application {

    public static void main(String[] args) {
        SpringApplication.run(Weizhinote2Application.class, args);
    }

}
