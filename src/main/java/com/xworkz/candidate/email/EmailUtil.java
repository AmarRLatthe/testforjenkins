package com.xworkz.candidate.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailUtil {

	@Autowired
	private MailSender mailSender;
	
	public void sendEmail(String toAddr, String subject, String body) {
		
		SimpleMailMessage mailMsg = new SimpleMailMessage();
		mailMsg.setTo(toAddr);
		mailMsg.setSubject(subject);
		mailMsg.setText(body);
		mailSender.send(mailMsg);
	}
}
