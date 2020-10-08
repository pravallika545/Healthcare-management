package com.dxc.appointment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AppointmentmgtApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointmentmgtApplication.class, args);
	}

}
