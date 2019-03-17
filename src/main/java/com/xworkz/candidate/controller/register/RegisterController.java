package com.xworkz.candidate.controller.register;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.candidate.dao.RegisterDAO;
import com.xworkz.candidate.dto.RegisterDTO;
import com.xworkz.candidate.email.EmailUtil;
import com.xworkz.candidate.util.UsernameUtil;
import com.xworkz.candidate.validator.EmailValidator;

@Controller
@RequestMapping("/")
public class RegisterController {

	@Autowired
	private EmailValidator emailValidator;

	@Autowired
	private RegisterDAO registerDAO;

	@Autowired
	private EmailUtil emailUtil;

	@Autowired
	private UsernameUtil usernameUtil;

	private final static Logger logger = LoggerFactory.getLogger(RegisterController.class);

	public RegisterController() {
		System.out.println(this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/register.do", method = RequestMethod.POST)
	public ModelAndView registerUser(RegisterDTO registerDTO) {
		String username = "";
		String password = "";
		Boolean emailValidResp = emailValidator.validateEmail(registerDTO.getEmail());
		if (emailValidResp) {
			if (registerDTO.getPhoneNumber() != null && registerDTO.getPhoneNumber().length() == 10) {
				Long emailCount = registerDAO.getCandidateCount(registerDTO.getEmail());
				if (emailCount >= 1) {
					logger.info("Already registered email " + registerDTO.getEmail());
					return new ModelAndView("register.jsp", "duplicateemail", "Provided email address is already registered");
				} else {
					logger.info("New candidate ====" + registerDTO.getEmail());
					
					username = usernameUtil.generateUsername(registerDTO);
					password = usernameUtil.generatePassword();
					logger.info("Generated user id is ====" + username);
					registerDTO.setFirstTime(true);
					registerDTO.setUserId(username);
					registerDTO.setPassword(password);
					boolean response = registerDAO.registerCandidate(registerDTO);
					if(response) {
						emailUtil.sendEmail(registerDTO.getEmail(), "Candidate Registration",
								"Dear "+ registerDTO.getName()  +", \n" + "\n Below are your details.\n" + "Job Code: " + registerDTO.getJobCode()
										+ "\n User Id: " + username + "\n Password: " + password
										+ "\n Below is the link using which you update your password and login to"
										+ "apply for job. \n\n Change password = http://localhost:8070/imapp/changepassword.do?username=" + username
										+ "\n\n\n For any queries reach out our HR Team on 080-42083810 \n\n"
										+ "Thanks and Regards,\n" + "Team IBM");
						logger.info("Response from insert user " + response);
						return new ModelAndView("register.jsp", "RegisterSuccessful", "Your registration for job was successful, please check your email "
								+ "for further details.");
					} else {
						return new ModelAndView("register.jsp", "RegisterUnsuccessful", "Your registration for job was unsuccessful, please try again.");
					}
					
				}
			} else {
				return new ModelAndView("register.jsp", "InvalidPhoneNo", "Provided Phone number is Invalid");
			}
		} else {
			return new ModelAndView("register.jsp", "InvalidEmail", "Provided Email is Invalid");
		}
	}

	@InitBinder
	public void allowEmptyDateBinding(WebDataBinder binder) {
		// tell spring to set empty values as null instead of empty string.
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
		simpleDateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat, false));
	}

}
