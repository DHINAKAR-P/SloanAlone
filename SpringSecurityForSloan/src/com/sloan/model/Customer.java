package com.sloan.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="customer")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

	@Id
	@GeneratedValue
	private Long id;
	@OneToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER)
	private User user;
	private String name;
	
	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private Gender gender;
	private String details;

	public Gender getGender() {
		return gender;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", user=" + user + ", name=" + name + ", gender=" + gender + ", details="
				+ details + "]";
	}

}
