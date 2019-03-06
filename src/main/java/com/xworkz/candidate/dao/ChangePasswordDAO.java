package com.xworkz.candidate.dao;

import com.xworkz.candidate.dto.RegisterDTO;

public interface ChangePasswordDAO {

	public RegisterDTO getUserCountForPwdUpdate(String oldPassword, String userId);
	
	public Long getUserCount(String userId);
	
	public Long updateCandidatePassword(String newPassword, String userLoggedIn);
}
