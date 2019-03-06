package com.xworkz.candidate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.candidate.dto.RegisterDTO;
import com.xworkz.candidate.service.ChangePasswordService;

@Controller
public class ChangePasswordController {

	@Autowired
	private ChangePasswordService changePasswordService;

	private static final Logger logger = LoggerFactory.getLogger(ChangePasswordController.class);

	public ChangePasswordController() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "changePassword.do", method = RequestMethod.POST)
	public ModelAndView changePassword(@RequestParam String oldPassword, @RequestParam String newPassword,
			@RequestParam String confirmPassword, HttpServletRequest request) {
		
		HttpSession httpSession = request.getSession(true);
		String userLoggedIn = (String) httpSession.getAttribute("user");
		httpSession.setAttribute("user", userLoggedIn);
		logger.info("Inside change password controller, changing user password, user=" +userLoggedIn);
		RegisterDTO registerDTO = null;
		if(newPassword.equalsIgnoreCase(confirmPassword)) {
			registerDTO = changePasswordService.changePasswordService(oldPassword, userLoggedIn);
			if(registerDTO != null && registerDTO.getPassword().equalsIgnoreCase(oldPassword)) {
				Long pwdUpdated = changePasswordService.updatePwdService(newPassword, userLoggedIn);
				logger.info("Response ================== " +pwdUpdated);
				if(pwdUpdated == 1) {
					return new ModelAndView("login.jsp");
				} else {
					return new ModelAndView("changepassword.jsp", "pwdnotmatching", "Failed updating password, please try again");
				}
			} else {
				return new ModelAndView("login.jsp");
			}
		} else {
			return new ModelAndView("changepassword.jsp", "pwdnotmatching", "Passwords aren't matching");
		}
	}
	
	@RequestMapping("/changepassword.do")
	public ModelAndView checkUser(@RequestParam String username, HttpServletRequest request) {
		// Add http session here
		// set user
		logger.info("Inside change password username " +username);
		HttpSession httpSession = request.getSession(true);
		httpSession.setAttribute("user", username);
		try {
			Long userCount = changePasswordService.servToRedirectChangePassword(username);
			if(userCount == 1){
				return new ModelAndView("changepassword.jsp");
			} else {
				return new ModelAndView("login.jsp");
			}
		} catch (Exception exception) {
			logger.info("Exception occurred while checking user");
			return new ModelAndView("login.jsp");
		}
	}
}