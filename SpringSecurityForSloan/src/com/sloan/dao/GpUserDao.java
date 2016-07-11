package com.sloan.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.usertype.UserVersionType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sloan.interfaces.dao.IGpUserDao;
import com.sloan.model.GpAuthority;
import com.sloan.model.GpUser;



@Repository
@Transactional
public class GpUserDao implements IGpUserDao {

	private Log log = LogFactory.getLog(getClass());
	
	@Value("${findUser.sql}")
	private String findUser;

	@Value("${findRole.sql}")
	private String findRole;

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override

	public GpUser findUser(String userName) {

		System.out.println("UserName is:" + userName);
		Query result = entityManager.createNativeQuery(findUser).setParameter("userName", userName);
		List<Object[]> user_list = (ArrayList<Object[]>) result.getResultList();
		int i = 0;
		GpUser user = new GpUser();
		List<GpUser> newarray = new ArrayList<GpUser>();

		for (Object[] myuser : user_list) {
			long id = Long.parseLong(myuser[0].toString());
			user.setId(id);
			user.setUsername(myuser[1].toString());
			user.setPassword(myuser[2].toString());
			System.out.println("username:" + user.getUsername());
			System.out.println("user id:" + user.getId());
			newarray.add(user);
		}
		System.out.println("Size of user:" + newarray.size());
		if (newarray.size() != 0) {
			System.out.println("User found:" + newarray.get(0).getUsername());
			Set<GpAuthority> authorties = getRolesForGpUser(newarray.get(0));
			newarray.get(0).setRoles(authorties);
		} else {
			log.debug("No roles found for this user:" + newarray.get(0).getId());
			// returning set as null
			newarray.get(0).setRoles(null);
		}
		return newarray.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override

	public Set<GpAuthority> getRolesForGpUser(GpUser user) {
		System.out.println("user Id:" + user.getId());
		String userId = user.getId().toString();
		Query result = entityManager.createNativeQuery(findRole).setParameter(
				"userId", userId);
		List<Object[]> authorities = (ArrayList<Object[]>) result
				.getResultList();
		List<GpAuthority> hashSetArray = new ArrayList<GpAuthority>();
		GpAuthority auth_man = new GpAuthority();
		int i = 0;

		System.out.println("object size:" + authorities.size());
		for (Object[] myuser : authorities) {
			Long userid = Long.parseLong(myuser[0].toString());
			auth_man.setId(userid);
			auth_man.setUsername(myuser[1].toString());
			auth_man.setAuthority(myuser[2].toString());
			hashSetArray.add(auth_man);
		}

		Set<GpAuthority> auth = new HashSet<GpAuthority>(hashSetArray);
		System.out.println("Role:" + auth.size());
		return auth;

	}

	@Override
	public GpUser insert(GpUser gpUser) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void Update_docker_json(GpUser gpUser) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
