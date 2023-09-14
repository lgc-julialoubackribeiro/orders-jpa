package com.crudorders.orders.controller;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.crudorders.orders.model.User;

@Service
public class RestConsumer {
	
	private RestTemplate restTemplate = new RestTemplate();	
	private String url = "http://localhost:8081/users/";
	
	public ResponseEntity<User> getUser(User user) {
		try {
			ResponseEntity<User> usuario = restTemplate.getForEntity(url+=user.getId(), User.class);
			
			return ResponseEntity.ok().body(usuario.getBody());
		} catch (Exception e) {		
			return postUser(user);
		}
	}
	
	public ResponseEntity<User> postUser(User user) {
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			JSONObject userObject = new JSONObject();
			userObject.put("name", user.getName());
			userObject.put("email", user.getEmail());
			
			HttpEntity<String> request = new HttpEntity<String>(userObject.toString(), headers);
			ResponseEntity<User> responseEntityStr = restTemplate.postForEntity(url, request, User.class);
			
			System.out.print(responseEntityStr);
			return responseEntityStr;
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
}