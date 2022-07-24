package com.ironhack.f1dataserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class F1DataServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(F1DataServicesApplication.class, args);
	}

}
