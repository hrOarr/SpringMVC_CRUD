package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.User;
import com.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	@Qualifier(value = "userServiceImp")
	private UserService userService;
	
	@RequestMapping("/")
	public String allUsers(Model model) {
		List<User> users = userService.allUsers();
		model.addAttribute("users", users);
		return "users/user_list";
	}
	
	@RequestMapping("/new")
	public String newUser() {
		return "users/add_form";
	}
	
	@PostMapping("/add")
	public String addUser(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("country") String country) {
		userService.InsertUser(new User(name, email, country));
		return "redirect:/users/";
	}
	
	@RequestMapping("/update/{id}")
	public String updateUser(@PathVariable("id") int id, Model model) {
		User user = userService.selectUser(id);
		model.addAttribute("user", user);
		return "users/update_form";
	}
	
	@PostMapping("/edit")
	public String editUser(@RequestParam("name") String name, 
			@RequestParam("email") String email, 
			@RequestParam("country") String country, @RequestParam("id") String id) {
		int user_id = Integer.parseInt(id);
		userService.updateUser(new User(user_id, name, email, country));
		return "redirect:/users/";
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
		return "redirect:/users/";
	}
}
