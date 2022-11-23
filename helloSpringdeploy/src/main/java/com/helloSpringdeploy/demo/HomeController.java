package com.helloSpringdeploy.demo;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.helloSpringdeploy.demo.entity.User;
import com.helloSpringdeploy.demo.service.UserService;

@Controller
public class HomeController {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	UserService userService;

	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}

	@GetMapping(value = "/home")
	public String getMethodName() {
		return "App started " + LocalDateTime.now();

	}
	@GetMapping("/register")
	public String register() {
		return "register";
	}


	@PostMapping(value = "/post_register")
	public void post_register(@RequestParam Map<String, String> body) {
		User user = new User();
	
		user.setName(body.get("username"));
		user.setEmail(body.get("email"));
		user.setUsername(body.get("mobile"));
		user.setMobile(body.get("mobile"));
		
		user.setPassword(passwordEncoder.encode(body.get("password")));
		// user.setAccountNonLocked(true);
		userService.getUserRepository().save(user);
	}
	
	
	@GetMapping("/currentusername")
	public String currentUserName(Principal principal) {
	        return principal.getName();
	}

}
