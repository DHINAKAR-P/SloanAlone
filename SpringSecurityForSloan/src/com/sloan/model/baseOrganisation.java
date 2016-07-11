package com.sloan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "base_organisation")
@JsonIgnoreProperties(ignoreUnknown = true)
public class baseOrganisation {

	@Id
	@GeneratedValue
	private Long id;

	//@Transient
	@Column(name="organisation_name")
	private String organisation_name;
	//@Transient
	@Column(name="organisation_location")
	private String organisation_location;
	//@Transient
	@Column(name="organisation_phonenumber")
	private String organisation_phonenumber;

	public Long getId() {
		return id;
	}

	public String getOrganisation_name() {
		return organisation_name;
	}

	public void setOrganisation_name(String organisation_name) {
		this.organisation_name = organisation_name;
	}

	public String getOrganisation_location() {
		return organisation_location;
	}

	public void setOrganisation_location(String organisation_location) {
		this.organisation_location = organisation_location;
	}

	public String getOrganisation_phonenumber() {
		return organisation_phonenumber;
	}

	public void setOrganisation_phonenumber(String organisation_phonenumber) {
		this.organisation_phonenumber = organisation_phonenumber;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "baseOrganisation [id=" + id + ", organisation_name=" + organisation_name + ", organisation_location="
				+ organisation_location + ", organisation_phonenumber=" + organisation_phonenumber + "]";
	}

}
