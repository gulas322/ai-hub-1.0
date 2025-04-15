package com.vm.ai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.vm.ai.mapper")
@SpringBootApplication
public class VwAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VwAiApplication.class, args);
    }

}
