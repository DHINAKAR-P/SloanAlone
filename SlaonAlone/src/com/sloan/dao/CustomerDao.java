package com.sloan.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sloan.controller.OrganisationController;
import com.sloan.model.Customer;
import com.sloan.model.Organisation;
import com.sloan.model.User;


@Repository
@Transactional
public class CustomerDao {

	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	OrganisationController orgController;

	
	public Customer create(Customer care) throws Exception {
		
		Customer customer = new Customer();
		customer.setId(care.getId());
		customer.setDetails(care.getDetails());
		customer.setGender(care.getGender());
		customer.setName(care.getName());
		User user=new User();
		user.setId(care.getUser().getId());
		user.setFirstName(care.getUser().getFirstName());
		user.setLastName(care.getUser().getLastName());
		user.setOldPassword(care.getUser().getOldPassword());
		user.setPassWord(care.getUser().getPassWord());
		user.setPhoneNumber(care.getUser().getPhoneNumber());
		user.setEmail(care.getUser().getEmail());		
		user.setUserType(care.getUser().getUserType());		
		
		Organisation org= orgController.createOrganisation(care.getUser().getOrganisation());
		user.setOrganisation(org);
		
		customer.setUser(user);
		entityManager.persist(customer);
		entityManager.flush();
		return customer;
	}

	public Customer update(Customer customer) throws Exception {
		entityManager.merge(customer);
		entityManager.flush();
		return customer;
	}

	public Customer search(long id) throws Exception {
		ArrayList<Customer> list = new ArrayList<Customer>();
		Customer customerUpdate;
		customerUpdate =  (Customer) entityManager.find(Customer.class, id);
		return customerUpdate;
	}
}
