package com.codecool.restclients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class RestClientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestClientsApplication.class, args);
	}

}
