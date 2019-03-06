package com.xworkz.candidate.dao;

import com.xworkz.candidate.dto.HrDTO;
import com.xworkz.candidate.dto.RegisterDTO;

public interface LoginDAO {

	public RegisterDTO getUserForLogin(String userId, String password);
	
	public HrDTO getHrForLogin(String userId, String password);
	
}
