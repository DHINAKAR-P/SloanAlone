package com.sloan.service;

import com.sloan.model.Customer;

public interface CustomerService {

	Customer create(Customer customer) throws Exception;

	Customer update(Customer customer) throws Exception;

	Customer search(long id) throws Exception; 
	
}
