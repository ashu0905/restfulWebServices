package com.springbootms.rest.webservices.restfulwebservices.helloworld;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	@GetMapping("/hello-world")
	public ResponseEntity<String> helloWorld() {
		return new ResponseEntity<>("Hello World", HttpStatus.OK);
	}
	
	@GetMapping("/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping("/hello-world/{name}")
	public String helloWorldName(@PathVariable("name") String name) {
		return "Hello " + name + "'s World";
	}
}