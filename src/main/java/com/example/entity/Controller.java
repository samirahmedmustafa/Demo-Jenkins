package com.example.entity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
public class Controller {

	@GetMapping
	public String getItems() {
		return "Hello API!";
	}
	
	@GetMapping("bye")
	public String getGoodbye() {
		return "Good bye API!";
	}
}
