package com.salmon.scommerce.web.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.salmon.scommerce.core.domain.NewUser;


@Controller
@RequestMapping("/login")
public class LoginController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	public String getLoginPage() {
		LOGGER.debug("Login page will be display.");
		ModelAndView view = new ModelAndView();
		view.setViewName("login");
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.POST) 
	public String authenticateUser(){
		
		LOGGER.debug("The UserLoginController starts authenticating Usership.");
		
		System.out.println("The UserLoginController starts authenticating Usership.");
		/*
		System.out.println(request.getParameter("username"));
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username == null || "".equals(username) || password == null || "".equals(password)){
			return "login";
		}
		
		NewUser newUser = new NewUser();
		newUser.setUsername(username);
		newUser.setPassword(password);
		
		int result = newUserServicer.loginUser(newUser);
		
		if(result == 0){
			return "login";
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", newUser);
		*/
		return "registersuccess";		
	}

}
