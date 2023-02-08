package com.huerta.springboot.app.gateway.springbootservicegatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringBootServiceGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootServiceGatewayServerApplication.class, args);
	}

}
