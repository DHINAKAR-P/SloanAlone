package com.sloan.interfaces.dao;

import java.util.Set;

import com.sloan.model.GpAuthority;
import com.sloan.model.GpUser;



public interface IGpUserDao {

	public abstract GpUser findUser(String userName);

	public abstract Set<GpAuthority> getRolesForGpUser(GpUser user);

	public abstract GpUser insert(GpUser gpUser) throws Exception;
		
	public abstract void Update_docker_json(GpUser gpUser) throws Exception;

}
