package com.xworkz.candidate.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.candidate.dto.HrDTO;
import com.xworkz.candidate.dto.RegisterDTO;


@Repository
public class LoginDAOImpl implements LoginDAO {

	Logger logger = LoggerFactory.getLogger(LoginDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public RegisterDTO getUserForLogin(String userId, String password) {
		Session session = null;
		RegisterDTO registerDTO = null;
		String getUser = "from RegisterDTO where userId=:userID and password=:pwd";
		logger.info("Inside getUserForLogin: executing query " +getUser + "user ===" +password);
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(getUser);
			query.setParameter("userID", userId);
			query.setParameter("pwd", password);
			registerDTO = (RegisterDTO) query.uniqueResult();
		} catch (Exception e){
			logger.info("Exception occurred while getting login user " +e.getMessage());
		}
		return registerDTO;
	}

	@Override
	public HrDTO getHrForLogin(String userId, String password) {
		String getHr = "From HrDTO where userId=:uId and password=:pwd";
		Session session = null;
		HrDTO hrDTO = null;
		logger.info("Inside getHrForLogin: executing query " + userId + " user === " +password);
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(getHr);
			query.setParameter("uId", userId);
			query.setParameter("pwd", password);
			hrDTO = (HrDTO) query.uniqueResult();
		} catch (Exception e) {
			logger.info("Exception occurred while getting login HR " +e.getMessage());
		}
		return hrDTO;
	}
	
	
	
}
