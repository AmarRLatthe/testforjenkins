package com.xworkz.candidate.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	Logger logger = LoggerFactory.getLogger(LogoutController.class);
	
	public LogoutController() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}
	
	@RequestMapping("/logout.do")
	public ModelAndView logoutUser(){
		logger.info("Inside logout controller === ");
		return new ModelAndView("login.jsp");
	}
}
