package com.sloan.service;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sloan.dao.GpUserDao;
import com.sloan.interfaces.services.IGpUserService;
import com.sloan.model.GpUser;




@Service
@Transactional
public class GpUserService implements UserDetailsService, IGpUserService {

	private Log log = LogFactory.getLog(getClass());

	@Autowired
	private GpUserDao gpuser_Dao;
	
	@SuppressWarnings("unused")
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		GpUser user = gpuser_Dao.findUser(userName);
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		if (user == null) {
			throw new UsernameNotFoundException("No User found");
		}
		return user;
	}
	@Override
	public void Update_docker_json(GpUser user) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
