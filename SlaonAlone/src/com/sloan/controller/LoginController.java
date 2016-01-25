package com.sloan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sloan.model.KeyValueData;
import com.sloan.model.User;
import com.sloan.response.ResponseWrapper;
import com.sloan.service.SignInService;


@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private SignInService signin;

	@RequestMapping(value = "/first", method = RequestMethod.GET)
	public String firstinit() {
		return "rest web service hit successfully";
	}
	
	@RequestMapping(value = "/loginValidation", method = { RequestMethod.POST }, consumes = "application/json", produces = "application/json")
	public ResponseWrapper loginValidation(@RequestBody User user) throws Exception {
		ResponseWrapper wrap = new ResponseWrapper();
		System.err.println("User Email From Angular Side "+user.getEmail());
		Object obj = signin.isValidLogin(user);
		if (obj != null && obj!="failed") {
			wrap.setResponseSuccess("success");
			wrap.setResponseCode(200);
			wrap.setResult(obj);
		} else {
			wrap.setResponseError("error");
			wrap.setResponseCode(404);
		}
		return wrap;
	}
	
	
	@RequestMapping(value = "/isEnvOrPro", method = { RequestMethod.POST }, consumes = "application/json", produces = "application/json")
	public ResponseWrapper isEnvOrPro(@RequestBody KeyValueData keyValue) {
		ResponseWrapper wrap = new ResponseWrapper();
		Map<String, String> keyValueData = new HashMap<String, String>();
		String keyData = "";
		String ValueData = "";
		List<KeyValueData> values = signin.isEnvironment(keyValue);
		System.out.println("values.size()===="+values.size());
		if (values != null && values.size() > 0) {
			for (int i = 0; i <= values.size()-1; i++) {
				keyData = values.get(i).getKey1();
				System.out.println("in copntroller---"+ values.get(i).getValue1()); 
				ValueData = values.get(i).getValue1();
				keyValueData.put(keyData, ValueData);
			}
			wrap.setResponseSuccess("success");
			wrap.setResult(keyValueData);
			return wrap;
		}
		wrap.setResponseError("error");
		wrap.setResponseInfo("There is No key in the name  which you gave to me");
		wrap.setResult("not yet");
		return wrap;
	}
	

}
