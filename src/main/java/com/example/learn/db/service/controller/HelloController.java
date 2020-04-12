package com.example.learn.db.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ecwid.consul.v1.ConsulClient;

@RestController
public class HelloController {
	
	@Autowired
	ConsulClient client;

	
	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	@GetMapping("/hello/{name}")
	public String helloFriend(@PathVariable("name")String name) {
		client.setKVValue("name", name);
		return "Hello "+name;
	}
}
