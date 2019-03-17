package com.xworkz.candidate.service.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.candidate.dao.LoginDAOImpl;
import com.xworkz.candidate.dto.HrDTO;
import com.xworkz.candidate.dto.RegisterDTO;

@Service
public class LoginService {

	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

	@Autowired
	private LoginDAOImpl loginDAOImpl;

	public LoginService() {
		System.out.println(this.getClass().getSimpleName());
	}

	public RegisterDTO getLoginUser(String username, String password) {
		RegisterDTO registerDTO = null;

		try {
			registerDTO = loginDAOImpl.getUserForLogin(username, password);
		} catch (Exception e) {
			logger.info("Exception occurred in login service while getting user for login " + e.getStackTrace());
		}
		return registerDTO;
	}

	public HrDTO getHrForLogin(String userId, String password) {
		HrDTO hrDTO = null;
		try {
			hrDTO = loginDAOImpl.getHrForLogin(userId, password);
		} catch (Exception e) {
			logger.info("Exception occurred in login service while getting user for login " + e.getStackTrace());
		}
		return hrDTO;
	}
}
