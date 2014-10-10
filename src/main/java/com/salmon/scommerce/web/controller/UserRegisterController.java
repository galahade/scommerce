package com.salmon.scommerce.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class UserRegisterController {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(UserRegisterController.class);
	
	@RequestMapping(method=RequestMethod.GET, value="userregister")
	public String getUserRegisterPage(){
		LOGGER.debug("The userregister Page will display.");
		ModelAndView view = new ModelAndView();
		view.setViewName("userregister");
		return "userregister";		
	}

}
