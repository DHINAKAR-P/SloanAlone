package com.sloan.model;

public enum Gender {

	MALE,FEMALE;
	
	public static Gender getUseType(String value) {
		return Gender.valueOf(value);
	}

	
}
