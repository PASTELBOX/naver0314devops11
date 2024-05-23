package com.example.bootmybatistilesv3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"*.member","data.*"})
@MapperScan("data.mapper")
public class BootMybatisTilesV3Application {

    public static void main(String[] args) {
        SpringApplication.run(com.example.demo.BootMybatisTilesV3Application.class, args);
    }

}
