package com.cdac.acts.jobboard.util;

public enum DegreeEnum {
	BTECH("BTECH"),
	BE("BE"),
	MCA("MCA"),
	BCA("BCA");
	private String str;
	private DegreeEnum(String str) {
		this.str = str;
	}
	
	
	public String getValue() {
		return str;
	}
}
