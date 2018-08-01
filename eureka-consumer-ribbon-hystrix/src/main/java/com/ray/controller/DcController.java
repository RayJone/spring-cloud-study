package com.ray.controller;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {
	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ConsumerService consumerService;

	@GetMapping("/consumer")
	public String dc(){
		return consumerService.consumer();
	}

	@Service
	class ConsumerService{

		@HystrixCommand(fallbackMethod = "fallback")
		public String consumer(){
			return restTemplate.getForObject("http://eureka-client/dc",String.class);
		}
		public  String fallback(){
			return "fallback";
		}
	}
}