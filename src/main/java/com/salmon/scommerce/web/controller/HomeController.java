package com.salmon.scommerce.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {

private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(method=RequestMethod.GET)
	public String getHomePage() {
		LOG.debug("Home page will be display.");
		ModelAndView view = new ModelAndView();
		view.setViewName("home");
		return "home";
	}
	@RequestMapping(method=RequestMethod.GET,value="login")
	public String getLoginPage() {
		LOG.debug("Login page will be display.");
		ModelAndView view = new ModelAndView();
		view.setViewName("login");
		return "login";
	}
}
