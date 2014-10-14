package com.salmon.scommerce.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping(value="/details",method=RequestMethod.GET)
	public String getUserInfo() {
		LOG.debug("User info page will be display.");
		ModelAndView view = new ModelAndView();
		view.setViewName("home");
		return "user/details";
	}
	

}
