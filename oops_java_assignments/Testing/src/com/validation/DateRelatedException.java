package com.validation;

public class DateRelatedException extends  Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2490231974798640002L;

	public DateRelatedException(String message) {
		super(message);
	}
	
	public DateRelatedException(String message, Throwable cause) {
        super(message, cause);
    }
}
