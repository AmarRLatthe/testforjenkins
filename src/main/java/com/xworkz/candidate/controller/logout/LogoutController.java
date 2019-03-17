package com.xworkz.candidate.controller.logout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public ModelAndView logoutUser(HttpServletRequest request){
		logger.info("Inside logout controller === ");
		HttpSession session = request.getSession();
		if(session != null) {
			logger.info("Session is getting closed.....");
			session.invalidate();
			return new ModelAndView("login.jsp");
		}
		return new ModelAndView("home.jsp");
	}
}
