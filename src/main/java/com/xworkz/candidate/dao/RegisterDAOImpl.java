package com.xworkz.candidate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.candidate.dto.RegisterDTO;

@Repository
public class RegisterDAOImpl implements RegisterDAO {

	private final static Logger logger = LoggerFactory.getLogger(RegisterDAOImpl.class);

	public RegisterDAOImpl() {
		System.out.println(this.getClass().getSimpleName());
	}

	@Autowired
	private SessionFactory sessionFactory;

	public Long getCandidateCount(String emailId) {

		logger.info("Started checking email id " + emailId);
		Long count = 0L;
		String countQuery = "select count(*) from RegisterDTO where email=:emailId";
		try {
			Query query = sessionFactory.openSession().createQuery(countQuery);
			query.setParameter("emailId", emailId);
			count = (Long) query.uniqueResult();
		} catch (HibernateException e) {
			logger.info("Exception while getting email count " + emailId);
			count = 0L;
		} 
		return count;
	}

	public Boolean registerCandidate(RegisterDTO registerDTO) {
		logger.info("Started inserting candidate ==");
		Session session = null;
		Transaction transaction = null;
		boolean response;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(registerDTO);
			transaction.commit();
			response = true;
		} catch (HibernateException ex) {
			transaction.rollback();
			logger.info("Error while inserting candidate " + ex.getMessage());
			response = false;
		} finally {
			session.close();
		}
		return response;
	}

	public Long updateCandidateDetail(String userId, String password, boolean isFirstTime) {
		// TODO Auto-generated method stub
		return null;
	}
}
