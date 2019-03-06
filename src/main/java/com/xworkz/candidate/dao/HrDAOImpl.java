package com.xworkz.candidate.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.candidate.dto.RegisterDTO;

@Repository
public class HrDAOImpl implements HrDAO {

	private static final Logger logger = LoggerFactory.getLogger(HrDAOImpl.class.getClass());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public HrDAOImpl() {
		logger.info(HrDAOImpl.class.getSimpleName());
	}
	@Override
	public List<RegisterDTO> getCandidates() {
		logger.info("Inside get candidates to get all candidates...");
		String query = "from RegisterDTO";
		Session session = null;
		List<RegisterDTO> registerDTOs = null;
		try {
			session = sessionFactory.openSession(); 
			Query query2 = session.createQuery(query);
			registerDTOs = query2.list();
		} catch (Exception e) {
			logger.info("Exception while getting candidates ..... ");
			e.printStackTrace();
		}
		return registerDTOs;
	}

}
