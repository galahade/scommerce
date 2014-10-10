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
@RequestMapping("/userregister")
public class UserRegisterController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(UserRegisterController.class);
	
	@Autowired
	NewUserService newUserServicer;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getUserRegisterPage(){
		LOGGER.debug("The userregister Page will display.");
		ModelAndView view = new ModelAndView();
		view.setViewName("userregister");
		return "userregister";		
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public String registerUser(HttpServletRequest request){
		
		LOGGER.debug("registerUser starts registering user.");
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username == null || "".equals(username) || password == null || "".equals(password)){
			System.out.println("Null fields!");
			return "userregister";	
		}
		
		NewUser newUser = new NewUser();
		newUser.setFirstname(firstname);
		newUser.setLastname(lastname);
		newUser.setEmail(email);
		newUser.setUsername(username);
		newUser.setPassword(password);

		System.out.println(newUser.getFirstname() + " & " + newUser.getLastname());
		
		int added = newUserServicer.registerNewUser(newUser);

		if(added != 1){
			return "userregister";	
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("user", newUser);
		
		return "registersuccess";	
		
	}

}
