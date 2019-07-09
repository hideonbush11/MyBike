package com.project.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value="com.project.*")
@SpringBootApplication
public class MyBikeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyBikeApplication.class, args);
    }

}
