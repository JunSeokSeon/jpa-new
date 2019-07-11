package com.jpa.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestMainController {
	@RequestMapping("/")
	public String index() {
		return "helloworld!";
	}
}
