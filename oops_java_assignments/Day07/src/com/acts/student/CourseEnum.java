package com.acts.student;

public enum CourseEnum {
	DAC("Post Graduation in DAC"), 
	DESD("Post Graduation in DESD"),
	DVLSI("Post Graduation in DVLSI");
	
	
	private String str = "";
	private CourseEnum(String str) {
		this.str = str;
	}
	
	public String getValue() {
		return str;
	}
	
}
