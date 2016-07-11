package com.sloan.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "caregiver")
@JsonIgnoreProperties(ignoreUnknown = true)
public class CareGiver {

	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastname;
	private Date dateOfBirth;
	private String email;
	private String password;	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User user;
	private int yearOfExperience;
	private String languageKnown;
	private String description;
	private String education;
	private boolean workPermit;
	
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public boolean isWorkPermit() {
		return workPermit;
	}
	public void setWorkPermit(boolean workPermit) {
		this.workPermit = workPermit;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getYearOfExperience() {
		return yearOfExperience;
	}
	public void setYearOfExperience(int yearOfExperience) {
		this.yearOfExperience = yearOfExperience;
	}
	public String getLanguageKnown() {
		return languageKnown;
	}
	public void setLanguageKnown(String languageKnown) {
		this.languageKnown = languageKnown;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "CareGiver [id=" + id + ", firstName=" + firstName + ", lastname=" + lastname + ", dateOfBirth="
				+ dateOfBirth + ", email=" + email + ", password=" + password + ", user=" + user + ", yearOfExperience="
				+ yearOfExperience + ", languageKnown=" + languageKnown + ", description=" + description
				+ ", education=" + education + ", workPermit=" + workPermit + "]";
	}
	 
}
