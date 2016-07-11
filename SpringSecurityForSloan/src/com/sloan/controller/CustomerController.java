package com.sloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sloan.model.Customer;
import com.sloan.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(method = RequestMethod.POST, value = "/create", headers = "Accept=application/json")
	@ResponseBody
	public Customer create(@RequestBody Customer careGiver) throws Exception {
		System.out.println("care giver in controller-----" + careGiver.toString());
		return customerService.create(careGiver);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update", headers = "Accept=application/json")
	@ResponseBody
	public Customer update(@RequestBody Customer careGiver) throws Exception {
		return customerService.update(careGiver);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/search", headers = "Accept=application/json")
	@ResponseBody
	public Customer search(@RequestParam("id") long id) throws Exception {
		return customerService.search(id);

	}

}
