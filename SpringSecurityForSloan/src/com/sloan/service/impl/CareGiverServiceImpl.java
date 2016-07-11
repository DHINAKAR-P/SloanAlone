package com.sloan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sloan.dao.CareGiverDao;
import com.sloan.model.CareGiver;
import com.sloan.service.CareGiverService;

@Service
@Transactional
public class CareGiverServiceImpl implements CareGiverService {

	@Autowired
	CareGiverDao careDao;
	
	@Override
	public CareGiver create(CareGiver careGiver) throws Exception {
		return careDao.create(careGiver);
	}

	@Override
	public CareGiver update(CareGiver careGiver) throws Exception {
		return careDao.update(careGiver);
	}

	@Override
	public CareGiver search(long id) throws Exception {
		return careDao.search(id);
	}

}
