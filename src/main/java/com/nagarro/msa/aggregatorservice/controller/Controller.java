package com.nagarro.msa.aggregatorservice.controller;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/orderdetails")
public class Controller {
	public static final String userServiceUrl = System.getenv("USER_URL");
	public static final String ordersServiceUrl = System.getenv("ORDERS_URL");

	@GetMapping("/{id}")
	public HashMap<String, Object> retrieveOrdersDetails(@PathVariable Integer id) {
		System.out.println(userServiceUrl);
		System.out.println(ordersServiceUrl);
		RestTemplate request = new RestTemplate();
		Object userDetails = request.getForObject(userServiceUrl + id, Object.class);
		HashMap<String, Object> map = new HashMap<>();
		map.put("userDetails", userDetails);
		Object orders = request.getForObject(ordersServiceUrl + id, Object.class);
		map.put("orders", orders);
		return map;
	}

}
