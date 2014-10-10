package com.salmon.scommerce.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.salmon.scommerce.core.services.UserService;
import com.salmon.scommerce.persistence.domain.AdminUser;

@Controller
@RequestMapping("/userregister")
public class UserRegisterController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(UserRegisterController.class);
		
	@RequestMapping(method=RequestMethod.GET)
	public String getUserRegisterPage(){
		LOGGER.debug("The userregister Page will display.");
		ModelAndView view = new ModelAndView();
		view.setViewName("userregister");
		return "userregister";		
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public String registerUser(HttpServletRequest request, UserService userServicer){
		
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
		
		AdminUser adminUser = new AdminUser();
		adminUser.setFirstname(firstname);
		adminUser.setLastname(lastname);
		adminUser.setEmail(email);
		adminUser.setUsername(username);
		adminUser.setPassword(password);

		System.out.println(adminUser.getFirstname() + " & " + adminUser.getLastname());
		
		int added = 0;
		
		
		if(added != 1){
			return "userregister";	
		}
		
		return "registersuccess";	
		
	}

}
