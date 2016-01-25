package com.sloan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sloan.model.Organisation;
import com.sloan.model.baseOrganisation;
import com.sloan.service.impl.OrganisationServiceImpl;

@Controller
@RequestMapping("/organization")
public class OrganisationController {

	@Autowired
	private OrganisationServiceImpl orgserviceimpl;
	
	@SuppressWarnings("null")
	@RequestMapping(method = RequestMethod.GET, value = "/getAllOrg/", headers = "Accept=application/json")
	@ResponseBody
	public List<baseOrganisation> getAllOrganisation() {
		
		List<baseOrganisation> organisationList = orgserviceimpl.getAllOrganisation();
		/*List<baseOrganisation> returnList=null;
		System.out.println("organisationList.size()----"+organisationList.size()); 
		for (int i=0;i<organisationList.size()-1;i++){
			 baseOrganisation baseOrg=new baseOrganisation();
			System.out.println("organization-----"+organisationList.get(i).toString());
			baseOrg.setOrganisation_location(organisationList.get(i).getOrganisation_location());
			baseOrg.setOrganisation_name(organisationList.get(i).getOrganisation_name());
			baseOrg.setOrganisation_phonenumber(organisationList.get(i).getOrganisation_phonenumber());
			returnList.add(baseOrg);
			}*/
		return organisationList;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findOrganisationById/", headers = "Accept=application/json")
	@ResponseBody
	public Organisation findOrganisationByName(@RequestParam("organisationId") long organisationId) {
		Organisation orgListForName = orgserviceimpl.findOrganisationByName(organisationId);
		return orgListForName;
	}

	
	@RequestMapping(method = RequestMethod.POST, value = "/create/", headers = "Accept=application/json")
	@ResponseBody
	public Organisation createOrganisation(@RequestBody Organisation organisationId) {
		Organisation orgListForName = orgserviceimpl.createOrganisation(organisationId);
		return orgListForName;
	}
	
	
}
