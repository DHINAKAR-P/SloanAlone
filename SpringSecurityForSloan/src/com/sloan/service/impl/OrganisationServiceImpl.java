package com.sloan.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sloan.dao.OrganisationDao;
import com.sloan.model.Organisation;
import com.sloan.model.baseOrganisation;
import com.sloan.service.OrganisationService;


@Service("organisationServiceImpl")
@Transactional
public class OrganisationServiceImpl implements OrganisationService{

	@Autowired
	private OrganisationDao organisationDao;  
	
	@Override
	public List<baseOrganisation> getAllOrganisation() {
		List<baseOrganisation> returnList = new ArrayList<baseOrganisation>() ;
		List<baseOrganisation> orgList = organisationDao.getAllOrganisation();
		for (int i=0;i<=orgList.size()-1;i++){
			 baseOrganisation baseOrg=new baseOrganisation();
			System.out.println("organization---in impl--"+orgList.get(i).toString());
			baseOrg.setId(orgList.get(i).getId()); 
			baseOrg.setOrganisation_location(orgList.get(i).getOrganisation_location());
			baseOrg.setOrganisation_name(orgList.get(i).getOrganisation_name());
			baseOrg.setOrganisation_phonenumber(orgList.get(i).getOrganisation_phonenumber());
			returnList.add(baseOrg);
			}
		return returnList;
	}

	@Override
	public Organisation findOrganisationByName(long organisationId) {
		Organisation orgListByName = organisationDao.findOrganisationByName(organisationId);
		return orgListByName;
	}

	public Organisation createOrganisation(Organisation organisationId) { 
		Organisation OrganisationForUser = organisationDao.createOrganisation(organisationId);
		return OrganisationForUser;
	}

}
