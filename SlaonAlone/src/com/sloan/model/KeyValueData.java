package com.sloan.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="key_db")
@JsonIgnoreProperties(ignoreUnknown = true)
public class KeyValueData {

	@Id
	@GeneratedValue
	private Long id;
	private String key1;
	private String value1;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKey1() {
		return key1;
	}
	public void setKey1(String key1) {
		this.key1 = key1;
	}
	public String getValue1() {
		return value1;
	}
	public void setValue1(String value1) {
		this.value1 = value1;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
