package com.huerta.springboot.app.item.springbootitemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SpringbootItemServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringbootItemServiceApplication.class, args);
  }
}