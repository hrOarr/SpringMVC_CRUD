package com.testing;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/show")
public class AddController {
	
	@RequestMapping("/")
	public String getHome() {
		System.out.println("Hello there.........");
		return "home";
	}
}
