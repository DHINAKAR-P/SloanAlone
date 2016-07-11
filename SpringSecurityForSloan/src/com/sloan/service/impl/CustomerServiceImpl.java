package com.sloan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sloan.dao.CustomerDao;
import com.sloan.model.Customer;
import com.sloan.service.CustomerService;


@Service
@Transactional
public class CustomerServiceImpl  implements CustomerService {
	

		@Autowired
		CustomerDao customerDao;
		
		@Override
		public Customer create(Customer careGiver) throws Exception {
			return customerDao.create(careGiver);
		}

		@Override
		public Customer update(Customer careGiver) throws Exception {
			return customerDao.update(careGiver);
		}

		@Override
		public Customer search(long id) throws Exception {
			return customerDao.search(id);
		}
	
	
}
