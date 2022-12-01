package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.hospital.repos.ProvinceRepository;

@Controller
public class MainController {
	
	
	
	@GetMapping({"/"})
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/superpage")
	public String superPage()
	{
		return "superpage";
	}
	
	
}
