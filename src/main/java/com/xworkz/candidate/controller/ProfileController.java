package com.xworkz.candidate.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.candidate.dto.RegisterDTO;

@Controller
public class ProfileController {

	Logger logger = LoggerFactory.getLogger(ProfileController.class);
	@RequestMapping(value = "profile.do")
	public ModelAndView getUserProfile(HttpServletRequest request) {

		logger.info("Inside get user progile of profile controller");
		HttpSession session = request.getSession(false);
		if (session == null) {
			return new ModelAndView("login.jsp");
		}
		RegisterDTO registerDTO = (RegisterDTO) session.getAttribute("userInfo");
		logger.info("User phone number " + registerDTO.getPhoneNumber());
		if(registerDTO != null) {
			registerDTO.setPassword(null);
			return new ModelAndView("profile.jsp", "dto", registerDTO);
		} else {
			return new ModelAndView("home.jsp");
		}
	}
}
