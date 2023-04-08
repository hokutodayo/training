package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/user/list")
	public String displayList(Model model) {

		List<User> userlist = userService.searchAll();
		model.addAttribute("userlist", userlist);

		return "user/list";
	}

	@GetMapping("/user/{id}")
	public String displayDetail(@PathVariable Long id, Model model) {

		User user = userService.search(id);
		model.addAttribute("user", user);

		return "user/detail";
	}

	@GetMapping("/user/add")
	public String displayAdd(Model model) {

		model.addAttribute("user", new User());

		return "user/add";
	}

	@PostMapping("/user/create")
	public String createUser(@Validated User user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "user/add";
		}

		userService.createUser(user);

		return "redirect:/user/list";
	}

}
