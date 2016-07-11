package com.sloan.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.sloan.model.KeyValueData;
import com.sloan.model.User;
import com.sloan.response.ResponseWrapper;
import com.sloan.service.SignInService;
import com.sloan.utils.GpUserUtils;


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
	

	@RequestMapping(value = "/loginSuccess/", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> success() {
		System.out.println("Login success controller called");
		Map<String, Object> response = new HashMap<String, Object>();
		System.out.println("Login success controller called");
		System.out.println("*********UserName*******" + GpUserUtils.getLoggedUser().getUsername());
		System.out.println("*********UserId*********" + GpUserUtils.getLoggedUser().getId());
		response.put("status", "success");
		response.put("username", GpUserUtils.getLoggedUser().getUsername());
		response.put("userid", GpUserUtils.getLoggedUser().getId());
		return response;
	}

	@RequestMapping(value = "/loginFailure/", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> failure() {
		System.out.println("Login failure controller called");
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", "failed");
		return response;
	}

	@RequestMapping(value = "/accessDenied/", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> accessDenied() {
		System.out.println("Access denied controller called");
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", "Access Denied");
		return response;
	}

	@RequestMapping(value = "/noUserPrincipalFound/", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> sessionNotFound() {
		System.out.println("No user principal controller called");
		System.out.println("No principal found. Redirect the page to login");
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", "No User principal Found. Redirect to login");
		return response;
	}

	@RequestMapping(value = "/logout/", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> logout() {
		System.out.println("Logged out controller called");
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("status", "logged out");
		return response;
	}
	
	
}
