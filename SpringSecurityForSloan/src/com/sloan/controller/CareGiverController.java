package com.sloan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sloan.model.CareGiver;
import com.sloan.service.CareGiverService;

@Controller
@RequestMapping("/careGiver")
public class CareGiverController {
	

	@Autowired
	CareGiverService careService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/create", headers = "Accept=application/json")
	@ResponseBody
	public CareGiver create(@RequestBody CareGiver careGiver) throws Exception {
		System.out.println("care giver in controller"+careGiver.toString());
		return careService.create(careGiver); 
	}

	@RequestMapping(method = RequestMethod.POST, value = "/update", headers = "Accept=application/json")
	@ResponseBody
	public CareGiver update(@RequestBody CareGiver careGiver) throws Exception {
		return careService.update(careGiver);
	}
	 

	@RequestMapping(method = RequestMethod.GET, value = "/search", headers = "Accept=application/json")
	@ResponseBody
	public CareGiver search(@RequestParam("id") long id) throws Exception {
		 return careService.search(id);
		
	}
	
	
}
