package com.xworkz.candidate.validator;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EmailValidator {

	private static final String validEmailUrl = "https://api.zerobounce.net/v1/validate?apikey=e246972560d94abe9a25b17d5e23c7af&email=";
	private final static Logger logger = LoggerFactory.getLogger(EmailValidator.class);
	public EmailValidator() {
		System.out.println(this.getClass().getSimpleName());
	}
	
	
	public Boolean validateEmail(String emailAddr) {
		
		String url = validEmailUrl + emailAddr;
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		logger.info("Validation url is " +url);
		ResponseEntity<String> json = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		if(json.toString().contains("Valid"))
		{
			logger.info("Response from api contains Valid email response");
			return true;
		} else {
			logger.info("Response from api contains Invalid email response");
			return false;
		}
	}
}
