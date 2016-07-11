package com.sloan.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Dan Castillo
 * @since Januaray 2010</p>
 * 
 * 
 *        The purpose of this class serve as the OO representation for a user in
 *        the system</p>
 *
 *        Date Updated: 02/02/2011</br> Updated By: Daniel Castillo</p>
 * 
 *        added the "languagepreferencename" field to hold the long name for a
 *        language this is a bit of a hack as did not want to do looks up in the
 *        language table when I needed the long name for a language </p>
 *
 *        Modified Date: 09/07/2012</br> Modified By: Dan Castillo </p>
 * 
 *        started to use it in version .35 switched to using annotations and JPA
 *        </p>
 *
 *        Modified Date: 09/14/2012</br> Modified By: Dan Castillo</p>
 * 
 *        added newuser boolean </p>
 *
 *        Gpuser class modified.
 *
 *        Profile class created to hold user profile details
 */
/*
 * @Entity
 * 
 * @Table(name = "users")
 * 
 * @NamedQuery(name="Users.findAll", query="select c from User c")
 * 
 * @SqlResultSetMapping( name="userResult",
 * entities=@EntityResult(entityClass=GpUser.class) )
 */
@Entity
@Table(name="user")
public class GpUser implements Serializable, UserDetails {

	private static final long serialVersionUID = -1160102300273815295L;

	public GpUser() {

	}

	@Id
	@GeneratedValue
	private Long id = 0L;
	@Override
	public String toString() {
		return "GpUser [id=" + id + ", username=" + username + ", password="
				+ password + ", languagepreference=" + languagepreference
				+ ", screenname=" + screenname + ", startdate=" + startdate
				+ ", licenseid=" + licenseid + ", lastaccess=" + lastaccess
				+ ", mustresetpassword=" + mustresetpassword + ", accestype="
				+ accestype + ", roles=" + roles + ", newuser=" + newuser + "]";
	}

	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String languagepreference;
	@Column
	private String screenname; // used for display only
	@Column
	private Date startdate;
	@Column
	private String licenseid;
	@Column
	private Date lastaccess;
	@Column
	private String mustresetpassword;
	@Column
	private String accestype; // used to disable access
	
	@OneToMany
	private Set<GpAuthority> roles;
	@Column
	private boolean newuser; // typically used for registration

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<GpAuthority> getRoles() {
		return roles;
	}

	public void setRoles(Set<GpAuthority> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLanguagepreference() {
		return languagepreference;
	}

	public void setLanguagepreference(String languagepreference) {
		this.languagepreference = languagepreference;
	}

	public String getScreenname() {
		return screenname;
	}

	public void setScreenname(String screenname) {
		this.screenname = screenname;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public String getLicenseid() {
		return licenseid;
	}

	public void setLicenseid(String licenseid) {
		this.licenseid = licenseid;
	}

	public Date getLastaccess() {
		return lastaccess;
	}

	public void setLastaccess(Date lastaccess) {
		this.lastaccess = lastaccess;
	}

	public String getMustresetpassword() {
		return mustresetpassword;
	}

	public void setMustresetpassword(String mustresetpassword) {
		this.mustresetpassword = mustresetpassword;
	}

	public String getAccestype() {
		return accestype;
	}

	public void setAccestype(String accestype) {
		this.accestype = accestype;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		for (GpAuthority role : roles) {
			System.out.println("The roles is: " + role.getAuthority());
			list.add(new SimpleGrantedAuthority(role.getAuthority()));
		}

		return list;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean isNewuser() {
		return newuser;
	}

	public void setNewuser(boolean newuser) {
		this.newuser = newuser;
	}

}
