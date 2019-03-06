package com.xworkz.candidate.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import com.xworkz.candidate.dto.RegisterDTO;

@Component
public class UsernameUtil {

	public UsernameUtil() {
		System.out.println(this.getClass().getSimpleName());
	}

	public String generateUsername(RegisterDTO registerDTO) {

		String userName = "";

		userName = registerDTO.getName().substring(0, 3) + registerDTO.getEmail().substring(0, 3)
				+ registerDTO.getBirthDate().toString().replace("/", "").substring(0, 3);
		return userName;
	}
	
	public String generatePassword() {
		String password = RandomStringUtils.random(8, true, true);
		return password;
	}
}
