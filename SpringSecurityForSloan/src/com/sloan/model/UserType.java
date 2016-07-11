package com.sloan.model;

public enum UserType {

	CUSTOMER, CAREGIVER;

	public static UserType getUseType(String value) {
		return UserType.valueOf(value);
	}

}
