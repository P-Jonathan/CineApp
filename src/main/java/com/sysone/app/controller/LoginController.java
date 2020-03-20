package com.sysone.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	@GetMapping("/admin")
	public String loginSuccess(Authentication auth) {
		System.out.println("User name: " + auth.getName());
		
		System.out.println("Roles: ");
		
		auth.getAuthorities().forEach(System.out::println);
		
		return "admin/admin";
	}

	@GetMapping("/login")
	public String loginForm() {
		return "admin/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();

		logoutHandler.logout(request, null, null);

		return "redirect:/login";
	}
}
