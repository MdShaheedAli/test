package com.example.AopAndLog.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("")
@CrossOrigin("*")
@RestController
public class HelloController {
	
	@GetMapping("/hello")
	public String sayHello(String name) {
		return "hello... "+name;
	}
	
	@GetMapping("/hi")
	public String sayHi(String name) {
		int a=5/0;
		return "hi... "+name;
	}
	
	@GetMapping("/hey")
	public String sayHey(String name) {
		return "hey... "+name;
	}
	

}
