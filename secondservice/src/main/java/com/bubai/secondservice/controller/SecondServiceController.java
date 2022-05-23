package com.bubai.secondservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bubai.secondservice.service.rest.proxy.FirstServiceClient;

@CrossOrigin
@RestController
@RequestMapping("/endpoint")
public class SecondServiceController {
	@Autowired
	private FirstServiceClient client;
	@GetMapping("/v1/test")
	public String getFirstServiceEndpoint() {
		return "Second Service";
	}
	@GetMapping("/v2/test")
	public String invokeFirstService() {
		String response = client.getResponseFromFirstService();
		return "Second Service"+":"+response;
	}
}
