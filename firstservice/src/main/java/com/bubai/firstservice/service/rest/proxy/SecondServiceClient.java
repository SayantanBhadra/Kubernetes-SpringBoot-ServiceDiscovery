package com.bubai.firstservice.service.rest.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("http://svc-secondservice/secondservice")
public interface SecondServiceClient {
	@GetMapping("/endpoint/v1/test")
	public String getResponseFromSecondService();
}
