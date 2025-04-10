package com.cdac.acts.employee;

public enum Deptenum {
	
	RND("Research And Development"),
	IT("Information Technology"),
	MRT("Marketing Department"),
	HR("Human Resource");
	
	
	private String str ="";
	private Deptenum(String str) {
		this.str = str;
	}
	
	public String getValue() {
		return str;
	}

}

