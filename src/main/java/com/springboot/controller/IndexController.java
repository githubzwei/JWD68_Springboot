package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class IndexController {

	@GetMapping("/index")
	public String showIndex(Model m) {
		m.addAttribute("message", "Springboot");
		return "index";
	}
	@GetMapping("/users_list")
	public String showUsers(Model m) {
		List<String> users = new ArrayList<String>();
		users.add("Su Su");
		users.add("Mg Mg");
		users.add("Ag Ag");
		
		m.addAttribute("users_list", users);
		return "user_list";
		
	}
}
