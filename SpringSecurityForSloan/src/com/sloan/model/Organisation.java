package com.sloan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "organisation")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Organisation {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "organisation_name")
	private String organisationName;

	@Column(name = "organisation_location")
	private String organisationLocation;

	@Column(name = "organisation_phonenumber")
	private String organisationPhoneNumber;

	private String base_organisation_id;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrganisationName() {
		return organisationName;
	}

	public void setOrganisationName(String organisationName) {
		this.organisationName = organisationName;
	}

	public String getOrganisationLocation() {
		return organisationLocation;
	}

	public void setOrganisationLocation(String organisationLocation) {
		this.organisationLocation = organisationLocation;
	}

	public String getOrganisationPhoneNumber() {
		return organisationPhoneNumber;
	}

	public void setOrganisationPhoneNumber(String organisationPhoneNumber) {
		this.organisationPhoneNumber = organisationPhoneNumber;
	}

	public String getBase_organisation_id() {
		return base_organisation_id;
	}

	public void setBase_organisation_id(String base_organisation_id) {
		this.base_organisation_id = base_organisation_id;
	}

	@Override
	public String toString() {
		return "Organisation [id=" + id + ", organisationName=" + organisationName + ", organisationLocation="
				+ organisationLocation + ", organisationPhoneNumber=" + organisationPhoneNumber
				+ ", base_organisation_id=" + base_organisation_id + "]";
	}
	
	

}
