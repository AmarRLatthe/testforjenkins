package com.xworkz.candidate.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.candidate.dto.HrDTO;
import com.xworkz.candidate.dto.LoginDTO;
import com.xworkz.candidate.dto.RegisterDTO;
import com.xworkz.candidate.service.login.LoginService;

@Controller
public class LoginController {

	Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;

	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	public ModelAndView loginController(LoginDTO loginDTO, HttpServletRequest request) {
		logger.info("Inside login controller " + loginDTO.getUsername());
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(60 * 1);

		logger.info("Session id in login controller " +session.getId());
		if (loginDTO != null && loginDTO.getUsername().length() > 0) {
			if (loginDTO != null && loginDTO.getPassword().length() > 0) {
				logger.info("inside if after ====");
				RegisterDTO registerDTO = loginService.getLoginUser(loginDTO.getUsername(), loginDTO.getPassword());
				logger.info("Username from db " + loginDTO.getUsername() + " password is " + loginDTO.getPassword());
				if (registerDTO != null && registerDTO.getUserId().equalsIgnoreCase(loginDTO.getUsername())
						&& registerDTO.getPassword().equalsIgnoreCase(loginDTO.getPassword())) {
					session.setAttribute("userInfo", registerDTO);
					logger.info("Username password are matching");
					return new ModelAndView("home.jsp", "userLoggedIn", loginDTO.getUsername());
				} else {
					HrDTO hrDTO = loginService.getHrForLogin(loginDTO.getUsername(), loginDTO.getPassword());
					if (hrDTO != null && hrDTO.getUserId().equalsIgnoreCase(loginDTO.getUsername())
							&& hrDTO.getPassword().equalsIgnoreCase(loginDTO.getPassword())) {
						return new ModelAndView("hrhome.jsp", "invalidlogindetails", "Username/Password is invalid");
					} else {
						return new ModelAndView("login.jsp", "invalidlogindetails", "Username/Password is invalid");
					}
				}
			} else {
				return new ModelAndView("userisnotprovided", "Username is required", "login.jsp");
			}
		} else {
			return new ModelAndView("pwdnotprovided", "Password is required", "login.jsp");
		}
	}
}
