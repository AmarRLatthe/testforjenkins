package com.xworkz.candidate.controller.schedule;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScheduleController {

	public ScheduleController() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}
	
	@RequestMapping("/schedule.do")
	public ModelAndView getInterviewSchedule(){
		
		return new ModelAndView("schedule.jsp");
	}
}
