package com.redhat.consulting.RestConsumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/service")
public class ServiceController {
	
	private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);
		
	@Autowired
	RestTemplate restTemplate;

	@Value("${operations.restURL}")
	String serviceURL;
	
	@GetMapping("/get")
	public String getURL() {
		return restTemplate.getForObject(serviceURL, String.class);
	}
	
	@GetMapping("/multipleGet")
	public void multipleGetURL() {
		int counter = 0;
		long startTime = System.currentTimeMillis();
		while (true) {	
			String output = restTemplate.getForObject(serviceURL, String.class);
			long elapsedTime = (System.currentTimeMillis() - startTime);
			logger.info("Request " + String.format("%05d", counter++) + ", " + String.format("%05d",elapsedTime/1000) + "s (" + counter*1000/elapsedTime + "req/sec): " + output);
		}
	}
	
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}
	
}
