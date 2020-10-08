package com.dxctraining.hotelregistry.registryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RegistryappApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistryappApplication.class, args);
	}

}
