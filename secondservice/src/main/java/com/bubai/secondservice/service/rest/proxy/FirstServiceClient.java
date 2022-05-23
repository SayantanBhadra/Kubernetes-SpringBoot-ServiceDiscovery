package com.bubai.secondservice.service.rest.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="http://svc-firstservice/firstservice")
public interface FirstServiceClient {
	@GetMapping("/endpoint/v1/test")
	public String getResponseFromFirstService();
}
