package com.neosunivesity.springboot.web.controller;

import com.neosunivesity.springboot.web.service.ValidationLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	@Autowired
	@Qualifier("validationLogin")
	private ValidationLogin validationLogin;

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model){
		return "login";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){
		if(validationLogin.isvalidUser(name,password)){
			model.put("name", name);
			model.put("password",password);
			return "welcome";
		}else{
			model.put("messageErrorUser","Invalidad user information, please try again");
			return "login";
		}

	}

}
