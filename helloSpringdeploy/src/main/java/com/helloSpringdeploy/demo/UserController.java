package com.helloSpringdeploy.demo;

import java.awt.PageAttributes.MediaType;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.helloSpringdeploy.demo.entity.User;
import com.helloSpringdeploy.demo.service.UserService;

@RestController // This means that this class is a Controller
@RequestMapping(path="/user") // This means URL's start with /demo (after Application path)
public class UserController {
	
	
  @Autowired // This means to get the bean called userRepository
         // Which is auto-generated by Spring, we will use it to handle the data
   
 UserService userService;
  @Autowired
  private PasswordEncoder passwordEncoder; 
  
  
  
  @PostMapping(
	      value = "/register" 
	   )
	   public void addUser(@RequestParam Map<String, String> body) {
	      User user = new User(); user.setUsername(body.get("username")); 
	      user.setPassword(passwordEncoder.encode(body.get("password"))); 
	     // user.setAccountNonLocked(true); 
	      userService.getUserRepository().save(user); 
	   }

  @PostMapping(path="/add") // Map ONLY POST Requests
  public @ResponseBody String addNewUser (@RequestParam String name
      , @RequestParam String email) {
    // @ResponseBody means the returned String is the response, not a view name
    // @RequestParam means it is a parameter from the GET or POST request

    User n = new User();
    n.setName(name);
    n.setEmail(email);
    userService.getUserRepository().save(n);
    return "Saved";
  }

  @GetMapping(path="/all")
  public @ResponseBody Iterable<User> getAllUsers() {
    // This returns a JSON or XML with the users
    return userService.getUserRepository().findAll();
  }
}