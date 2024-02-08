package com.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class LoginController {

	@GetMapping("/welcomes")
	public String Welcome(){
		return "Welcome";
	}
	
	@GetMapping("/admin")
	public String Admin() {
		return "Admin";
	}
	@GetMapping("/basic") public String basic()
    {
        return "basic";
    }
 
    @GetMapping("/login") public String login()
    {
        return "login";
    }
    
    @GetMapping("/error")
    public String error() {
        return "error";
    }

}
