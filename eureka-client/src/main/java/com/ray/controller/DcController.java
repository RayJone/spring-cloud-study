package com.ray.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

	//com.netflex下的没有对应的bean
	@Autowired
	DiscoveryClient discoveryClient;

	@GetMapping("/dc")
	public String dc(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String services = "services  " + discoveryClient.getServices();
		System.out.println(services);
		return services;
	}
}
