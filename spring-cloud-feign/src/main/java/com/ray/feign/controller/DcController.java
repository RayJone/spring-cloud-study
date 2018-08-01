package com.ray.feign.controller;

import com.ray.feign.interfaces.DcClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DcController {

	@Autowired
	DcClient dcClient;

	@GetMapping("/consumer")
	public String consumer(){
		return dcClient.consumer();
	}
}
