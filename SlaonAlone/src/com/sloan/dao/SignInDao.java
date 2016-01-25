package com.sloan.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sloan.model.CareGiver;
import com.sloan.model.Customer;
import com.sloan.model.KeyValueData;
import com.sloan.model.User;

@Repository
public class SignInDao {

	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public User loginValidation(User user) {
		User userthendicated = entityManager.find(User.class, user.getId());
		return userthendicated;
	}

	@SuppressWarnings("unchecked")
	public List<User> isValidLogin(User user) throws Exception {
		String email = user.getEmail();
		String passWord = user.getPassWord();
		String e = "\"" + email + "\"";
		String pass = "\"" + passWord + "\"";
		String querystr = " Select * FROM user  WHERE email = " + e + " AND passWord=" + pass;
		System.out.println("----query String " + querystr);
		Query result = entityManager.createNativeQuery(querystr, User.class);
		List<User> userObj = result.getResultList();
		return userObj;
	}

	public List<Customer> getCustomer(Long id) throws Exception {
		String querystr = "select * from customer where user_id=" + id;
		Query result = entityManager.createNativeQuery(querystr, Customer.class);
		List<Customer> userObj = result.getResultList();
		return userObj;
	}

	public List<CareGiver> getCareGiver(Long id) throws Exception {
		String querystr = "select * from caregiver where user_id=" + id;
		Query care = entityManager.createNativeQuery(querystr, CareGiver.class);
		List<CareGiver> userObj = care.getResultList();
		return userObj;
	}
	
	@SuppressWarnings("unchecked")
	public List<KeyValueData> isEnviron(KeyValueData keyVal) {
		String keydata = keyVal.getKey1();
		String e = "\"" + keydata + "\"";
		String querystr = "select * FROM key_db  WHERE key1 =" + e;
		Query userObject = entityManager.createNativeQuery(querystr,
				KeyValueData.class);
		List<KeyValueData> keyObj = userObject.getResultList();
		return keyObj;
	}

}
