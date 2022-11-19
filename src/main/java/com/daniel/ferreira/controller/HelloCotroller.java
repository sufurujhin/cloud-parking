package com.daniel.ferreira.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloCotroller {

	@GetMapping
	public String hello() {
		return "Hello DIO...";
	}
}
