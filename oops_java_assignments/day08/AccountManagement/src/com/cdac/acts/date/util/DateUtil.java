package com.cdac.acts.date.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
	
	public static final String  DD_MM_YYYY = "dd/MM/yyyy";
	public static final String  MM_DD_YYYY = "MM/dd/yyyy";
	
	private DateUtil() {
		//DO nothing Ctor
	}
	
	public static String dateToString(LocalDate date,String format) {
		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        String formattedDate = date.format(formatter);
        
        return formattedDate;
	}
	public static LocalDate textToDate(String date,String format) {
		
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        
        LocalDate formatedDate = LocalDate.parse(date, formatter);
        
        
        return formatedDate;
	}


}
