package com.nagarro.msa.aggregatorservice.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/orderdetails")
public class Controller {

	@Autowired
	private RestTemplate request;
	
	@Value("${USER_URL}")
	private String userServiceUrl;
	@Value("${ORDERS_URL}")
	private String ordersServiceUrl;

	@GetMapping("/{id}")
	public HashMap<String, Object> retrieveOrdersDetails(@PathVariable Integer id) {
		HashMap<String, Object> map = new HashMap<>();
		Object userDetails;
		try {
		userDetails = request.getForObject(userServiceUrl + id, Object.class);
		map.put("userDetails", userDetails);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			map.put("userDetails", "User not found at id- " + id);
		}
		Object orders = request.getForObject(ordersServiceUrl + id, Object.class);
		map.put("orders", orders);
		return map;
	}

}
