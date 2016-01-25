package com.sloan.service;


import java.util.List;

import com.sloan.model.KeyValueData;
import com.sloan.model.User;

public interface SignInService {
	
	
	public Object isValidLogin(User user) throws Exception;
	public List<KeyValueData> isEnvironment(KeyValueData user);
	
	
}
