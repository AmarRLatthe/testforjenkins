package com.xworkz.candidate.dao;

import com.xworkz.candidate.dto.RegisterDTO;

public interface RegisterDAO {

	public Long getCandidateCount(String emailId);
	
	public Boolean registerCandidate(RegisterDTO registerDTO);
	
	public Long updateCandidateDetail(String userId, String password, boolean isFirstTime);
}
