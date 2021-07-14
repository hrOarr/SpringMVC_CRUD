package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.User;
import com.service.UserService;
import com.validation.UserValidation;

@Controller
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping()
	public String allUsers(Model model) {
		List<User> users = userService.allUsers();
		model.addAttribute("users", users);
		return "users/user_list";
	}
	
	@GetMapping("/add")
	public String addUser(Model model) {
		model.addAttribute("type", "add");
		return "users/show_form";
	}
	
	@ModelAttribute("user")
	public User getUser() {
		return new User();
	}
	
	@PostMapping("/add")
	public String addUser(@ModelAttribute("user") User user, Model model) {
		UserValidation userValidation = new UserValidation();
		boolean error = userValidation.validate(user, model);
		if(error) {
			model.addAttribute("type", "add");
			return "users/show_form";
		}
		userService.InsertUser(user);
		return "redirect:/users";
	}
	
	@GetMapping("/update/{id}")
	public String updateUser(@PathVariable("id") int id, Model model) {
		User user = userService.selectUser(id);
		model.addAttribute("user", user);
		model.addAttribute("type", "update");
		return "users/show_form";
	}
	
	@PostMapping("/update")
	public String updateUser(@ModelAttribute("user") User user, Model model) {
		UserValidation userValidation = new UserValidation();
		boolean error = userValidation.validate(user, model);
		if(error) {
			model.addAttribute("type", "update");
			return "users/show_form";
		}
		userService.updateUser(user);
		return "redirect:/users";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		userService.deleteUser(id);
		return "redirect:/users";
	}
}
