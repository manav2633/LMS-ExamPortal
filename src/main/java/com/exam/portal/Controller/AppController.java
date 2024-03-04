package com.exam.portal.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AppController {

	@GetMapping("/")
	public String index() {
		return "organiser/login";
	}
	
	@GetMapping("/exam")
	public String exam() {
		return "index";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
	@GetMapping("/contact-us")
	public String contactUs() {
		return "contact";
	}
	
	
	@GetMapping("organiser/assign")
	public String Showroles() {
		return "organiser/assign_roles";
	}
}
