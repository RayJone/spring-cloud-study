package com.ray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务消费者
 */
@SpringBootApplication
@EnableDiscoveryClient		//上边的注解包含了这个功能，可以获取client的services
public class EurekaConsumerApplication {

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerApplication.class);
	}
}
