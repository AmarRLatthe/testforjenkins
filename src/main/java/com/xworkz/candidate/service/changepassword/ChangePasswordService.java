package com.xworkz.candidate.service.changepassword;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.candidate.dao.ChangePasswordDAO;
import com.xworkz.candidate.dto.RegisterDTO;

@Service
public class ChangePasswordService {

	Logger logger = LoggerFactory.getLogger(ChangePasswordService.class);

	public ChangePasswordService() {
		System.out.println(this.getClass().getSimpleName());
	}

	@Autowired
	private ChangePasswordDAO changePasswordDAO;

	public Long servToRedirectChangePassword(String username) {
		logger.info("Inside change password service: username is " + username);
		Long userCount = 0L;
		try {
			userCount = changePasswordDAO.getUserCount(username);
			return userCount;
		} catch (Exception ex) {
			logger.info("Exception inside ch: username is " + username);
			return userCount;
		}
	}

	public RegisterDTO changePasswordService(String oldPassword, String userLoggedIn) {
		RegisterDTO response = null;
		try {
			response = changePasswordDAO.getUserCountForPwdUpdate(oldPassword, userLoggedIn);
			return response;
		} catch (Exception e) {
			logger.info("Exception inside get password count service " +e.getMessage());
			return response;
		}
	}
	
	public Long updatePwdService(String newPassword, String userLoggedIn) {
		Long pwdUpdated = changePasswordDAO.updateCandidatePassword(newPassword, userLoggedIn);
		return pwdUpdated;
	}
}
