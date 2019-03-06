package com.xworkz.candidate.dao;

import java.util.List;

import com.xworkz.candidate.dto.RegisterDTO;

public interface HrDAO {

	public List<RegisterDTO> getCandidates();
}
