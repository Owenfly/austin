package com.zust.austin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AustinApplication {
    public static void main(String[] args) {

        SpringApplication.run(AustinApplication.class, args);

        //开启apollo动态配置
        System.setProperty("apollo.config-service", "http://austin-apollo-config:8080");
    }
}


