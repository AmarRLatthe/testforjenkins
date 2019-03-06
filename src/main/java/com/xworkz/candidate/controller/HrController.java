package com.xworkz.candidate.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.candidate.dto.RegisterDTO;
import com.xworkz.candidate.service.HrService;

@Controller
public class HrController {

	Logger logger = LoggerFactory.getLogger(HrController.class.getClass());
	
	@Autowired
	private HrService hrService;
	
	public HrController() {
		logger.info("Created \t" +this.getClass().getSimpleName());
	}
	
	@RequestMapping(value="candidates.do", method=RequestMethod.GET)
	public ModelAndView getCandidates() {
		List<RegisterDTO> registerDTOs = hrService.getCandidates();
		if(registerDTOs != null && registerDTOs.size() > 0) {
			return new ModelAndView("candidates.jsp", "candidates", registerDTOs);
		}
		return new ModelAndView("hrhome.jsp", "nocandidates", "No candidates found for interview");
	}
}
