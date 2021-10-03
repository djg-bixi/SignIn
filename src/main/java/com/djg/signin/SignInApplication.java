package com.djg.signin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.djg.signin.mapper")
public class SignInApplication {

    public static void main(String[] args) {
        SpringApplication.run(SignInApplication.class, args);
    }

}
