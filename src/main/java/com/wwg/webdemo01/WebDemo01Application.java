package com.wwg.webdemo01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.wwg")
public class WebDemo01Application {

    public static void main(String[] args) {
        SpringApplication.run(WebDemo01Application.class, args);
    }

}
