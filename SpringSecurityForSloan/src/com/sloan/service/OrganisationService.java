package com.sloan.service;

import java.util.List;

import com.sloan.model.Organisation;
import com.sloan.model.baseOrganisation;

public interface OrganisationService {

	public List<baseOrganisation> getAllOrganisation();
	
	public Organisation findOrganisationByName(long organisationId);
	
}
