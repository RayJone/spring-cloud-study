package com.ray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient		//上边的注解包含了这个功能，可以获取client的services
public class EurekaApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaApplication.class);
	}
}
