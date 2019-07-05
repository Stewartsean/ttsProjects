package com.st.websiteProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.st.websiteProject.model.User;
import com.st.websiteProject.service.UserService;

@Controller
public class UserController 
{
	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String index()
	{
		return "/index";
	}
	@GetMapping("/AboutMe")
	public String aboutMe()
	{
		return "/AboutMe";
	}
	@GetMapping("/Users")
	@ResponseBody
	public List<User> findAll()
	{
		return userService.findAll();
	}
}
