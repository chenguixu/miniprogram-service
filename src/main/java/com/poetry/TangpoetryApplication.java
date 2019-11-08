package com.poetry;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.poetry.mapper")
@EnableSwagger2
public class TangpoetryApplication {

    public static void main(String[] args) {
        SpringApplication.run(TangpoetryApplication.class, args);
    }

}
