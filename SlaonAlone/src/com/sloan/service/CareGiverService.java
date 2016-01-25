package com.sloan.service;

import com.sloan.model.CareGiver;

public interface CareGiverService {

	CareGiver create(CareGiver careGiver) throws Exception;

	CareGiver update(CareGiver careGiver) throws Exception;

	CareGiver search(long id) throws Exception; 

}
