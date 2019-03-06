package com.xworkz.candidate.dao;

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
public class ChangePasswordDAOImpl implements ChangePasswordDAO {

	private static final Logger logger = LoggerFactory.getLogger(ChangePasswordDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public RegisterDTO getUserCountForPwdUpdate(String oldPassword, String userId) {
		logger.info("Started getting password count " + oldPassword);
		String getUserQuery = "select count(*) from RegisterDTO where userId=:userID and password=:pwd";
		RegisterDTO registerDTO = null;
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query =session.createQuery(getUserQuery);
			logger.info("Getting user using password and userId " );
			query.setParameter("userID", userId);
			query.setParameter("pwd", oldPassword);
			registerDTO = (RegisterDTO) query.uniqueResult();
			return registerDTO;
		} catch (Exception e) {
			logger.info("Exception while getting user using password and userId" + e.getMessage());
			return registerDTO;
		} finally {
			session.close();
		}
	}

	@Override
	public Long getUserCount(String userId) {
		Session session = null;
		String queryString = "select count(*) from RegisterDTO where userId=:userId";
		Long userCount = 0L;
		logger.info("Inside userid count dao");
		try {
			session = sessionFactory.openSession();
			Query query = session.createQuery(queryString);
			query.setParameter("userId", userId);
			userCount = (Long) query.uniqueResult();
			logger.info("Inside userid count dao " +userCount);
			return userCount;
		} catch (Exception ex) {
			logger.info("Exception occurred while getting user id count " +ex.getMessage());
			return userCount;
		} finally {
			session.close();
		}
	}

	@Override
	public Long updateCandidatePassword(String newPassword, String userLoggedIn) {
		logger.info("Inside update password DAO new password " +newPassword);
		String updateUserQry = "update RegisterDTO set password=:pwd where userId=:userID";
		Session session = null;
		Transaction transaction = null;
		Long pwdUpdated = 0L;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery(updateUserQry);
			query.setParameter("pwd", newPassword);
			query.setParameter("userID", userLoggedIn);
			pwdUpdated = (Long) query.uniqueResult();
			transaction.commit();
			return pwdUpdated;
		} catch (Exception e) {
			logger.info("Exception Inside update password DAO new password " +pwdUpdated + e.getMessage());
			return pwdUpdated;
		} finally {
			session.close();
		}
	}
}
