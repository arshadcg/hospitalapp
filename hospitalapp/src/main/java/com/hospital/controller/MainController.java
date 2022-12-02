package com.hospital.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.dto.UserRegistrationDto;
import com.hospital.repos.UserRegistrationDtoRepository;

@Controller
public class MainController {
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	
	@Autowired private UserRegistrationDtoRepository userRegistrationDtoRepository;
	
	@GetMapping("/")
	public String home()
	{
		String password="toor";
		System.out.println("Encoded password of root: "+passwordEncoder().encode(password));
		return "home";
	}
	
	
	
	@GetMapping("/signup")
	public String signupPage()
	{
		return "signup";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response)
	{

		HttpSession session= request.getSession(false);
		SecurityContextHolder.clearContext();
		
		session=request.getSession(false);
		
		if(session!=null)
		{
			session.invalidate();
		}
		for(Cookie cookies:request.getCookies())
		{
			cookies.setMaxAge(0);
		}
		
		return "redirect:/";
	}
	
	
	
	@PostMapping("/register")
	public String registerPage(@RequestBody UserRegistrationDto userRegistrationDto, Model model)
	{
		boolean exists = userRegistrationDtoRepository.existsByUserName(userRegistrationDto.getUserName());
		String nomessage = "User Name Not Available try another one";
		String okmessage="Available!";
		if(exists)
			model.addAttribute("userDuplicate", nomessage);
		
		//model.addAttribute("userDuplicate", okmessage);
		
		UserRegistrationDto dto=null;
		
		dto.setUserName(userRegistrationDto.getUserName());
		dto.setAddressLine(userRegistrationDto.getAddressLine());
		dto.setCityName(userRegistrationDto.getCityName());
		dto.setContactNumber(userRegistrationDto.getContactNumber());
		dto.setEmailId(userRegistrationDto.getEmailId());
		dto.setFirstName(userRegistrationDto.getFirstName());
		dto.setLastName(userRegistrationDto.getLastName());
		dto.setPassword(passwordEncoder().encode(userRegistrationDto.getPassword()));
		
		userRegistrationDtoRepository.save(dto);
		
		
		String success = "Registration sucess";
		
		model.addAttribute("sucessRegistration", success);
		
		
		
		return "signup";
	}
	
}
