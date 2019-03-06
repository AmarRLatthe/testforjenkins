package com.xworkz.candidate.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.candidate.dao.HrDAO;
import com.xworkz.candidate.dto.RegisterDTO;

@Service
public class HrService {

	public static final Logger logger = LoggerFactory.getLogger(HrService.class.getClass());
	
	@Autowired
	private HrDAO hrDAO;
	
	public HrService() {
		logger.info(this.getClass().getSimpleName());
	}
	
	public List<RegisterDTO> getCandidates() {
		logger.info("Inside get condidates.... ");
		List<RegisterDTO> registerDTOs = null;
		try {
			registerDTOs = hrDAO.getCandidates();
		} catch (Exception e) {
			logger.info("Exception while getting candidates in service.... ");
		}
		return registerDTOs;
	}
}
