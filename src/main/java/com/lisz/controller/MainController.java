package com.lisz.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@Value("${DBName}")
	private String name;

	@GetMapping("/")
	public String list(){
		System.out.println(name);
		return "11" + name;
	}
}
