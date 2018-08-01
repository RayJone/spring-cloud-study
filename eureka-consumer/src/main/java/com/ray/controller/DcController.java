package com.ray.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {

	/**
	 * 负载均衡调用服务提供者
	 * 通过choose函数获取serviceInstance实例，拼接服务地址
	 *
	 * restTemplate调用服务
	 */
	@Autowired
	LoadBalancerClient loadBalancerClient;

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/consumer")
	public String dc(){
		ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
		String url = "http://"+serviceInstance.getHost() + ":"+serviceInstance.getPort()+"/dc";
		System.out.println(url);
		return restTemplate.getForObject(url,String.class);
	}
}
