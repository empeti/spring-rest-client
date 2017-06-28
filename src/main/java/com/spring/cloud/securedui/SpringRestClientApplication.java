package com.spring.cloud.securedui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.spring.cloud.securedui.domain.UserRequest;

@SpringBootApplication
public class SpringRestClientApplication {

	public static void main(String[] args) {
		sendRestRequest();
		SpringApplication.run(SpringRestClientApplication.class, args);
	}
	
	private static void sendRestRequest(){
		MultiValueMap<String, String> request = getUserRequest(); 
		RestTemplate rt = new RestTemplate();
		rt.postForObject("http://localhost:9000/user", request, UserRequest.class);
	}

	private static MultiValueMap<String, String> getUserRequest() {
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("name", "name");
		map.add("email", "mpeti@mpeti.hu");
		map.add("password", "password");
		
		return map;
	}
}
