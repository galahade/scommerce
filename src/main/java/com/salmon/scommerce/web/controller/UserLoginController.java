package com.salmon.scommerce.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.salmon.scommerce.core.domain.NewUser;
import com.salmon.scommerce.core.services.NewUserService;

@Controller
@RequestMapping("/login")
public class UserLoginController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(UserRegisterController.class);
	
	@Autowired
	NewUserService newUserServicer;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getUserRegisterPage(){
		LOGGER.debug("The userlogin Page will display.");
		ModelAndView view = new ModelAndView();
		view.setViewName("userlogin");
		return "userlogin";		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/authenticator") 
	public String authenticateUser(){
		
		LOGGER.debug("The UserLoginController starts authenticating Usership.");
		
		System.out.println("The UserLoginController starts authenticating Usership.");
		
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
		
		return "registersuccess";		
	}

}
