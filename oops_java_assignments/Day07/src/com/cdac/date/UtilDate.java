package com.cdac.date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;



public class UtilDate {
	
	private static final String FORMAT = "yyyy/MM/dd";
//	private static final String result = "";
	private UtilDate() {
		// private ctor for not creating objects of this class;
	}
	
	public static String getFormattedDate(LocalDate date) { 
		//null check
		if ( null == date) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(FORMAT);
		return sdf.format(date); //is string
		
//		String formattedString = sdf.format(date);
//		return formattedString;
	};
}
