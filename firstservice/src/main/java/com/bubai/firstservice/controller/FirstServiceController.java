package com.bubai.firstservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bubai.firstservice.service.rest.proxy.SecondServiceClient;

@CrossOrigin
@RestController
@RequestMapping("/endpoint")
public class FirstServiceController {
	@Autowired
	private SecondServiceClient client;
	@GetMapping("/v1/test")
	public String getFirstServiceEndpoint() {
		return "First Service";
	}
	@GetMapping("/v2/test")
	public String invokeSecondService() {
		String response = client.getResponseFromSecondService();
		return "First Service"+":"+response;
	}
}
