package com.sloan.dao;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sloan.controller.OrganisationController;
import com.sloan.model.CareGiver;
import com.sloan.model.Organisation;
import com.sloan.model.User;


@Repository
@Transactional
public class CareGiverDao {

	
	@PersistenceContext
	EntityManager entityManager;
	@Autowired
	OrganisationController orgController;
	 
	public CareGiver create(CareGiver care) throws Exception {
		
		CareGiver careGiver = new CareGiver();
		careGiver.setId(care.getId());
		careGiver.setFirstName(care.getFirstName());
		careGiver.setLastname(care.getLastname());
		careGiver.setDateOfBirth(care.getDateOfBirth());
		careGiver.setEmail(care.getEmail());
		careGiver.setPassword(care.getPassword());
		
		User user=new User();
		user.setId(care.getUser().getId());
		user.setFirstName(care.getUser().getFirstName());
		user.setLastName(care.getUser().getLastName());
		user.setOldPassword(care.getUser().getOldPassword());
		user.setPassWord(care.getUser().getPassWord());
		user.setPhoneNumber(care.getUser().getPhoneNumber());
		user.setEmail(care.getUser().getEmail());
		user.setUserType(care.getUser().getUserType());
		
		Organisation org= orgController.createOrganisation(care.getUser().getOrganisation());
		user.setOrganisation(org);
		careGiver.setUser(user);
		
		careGiver.setYearOfExperience(care.getYearOfExperience());
		careGiver.setLanguageKnown(care.getLanguageKnown());
		careGiver.setDescription(care.getDescription());
		careGiver.setEducation(care.getEducation());
		careGiver.setWorkPermit(care.isWorkPermit());	 
		entityManager.persist(careGiver);
		entityManager.flush();
		
		return careGiver;
	}

	public CareGiver update(CareGiver careGiver) throws Exception {
		entityManager.merge(careGiver);
		entityManager.flush();
		return careGiver;
	}


	public CareGiver search(long id) throws Exception {
		ArrayList<CareGiver> list = new ArrayList<CareGiver>();
		CareGiver careGiver;
		careGiver =  (CareGiver) entityManager.find(CareGiver.class, id);
		return careGiver;
	}
}
