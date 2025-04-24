package com.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.validation.DateRelatedException;

public class DateUtils {

	private DateUtils() {

	}

	public  static Integer calcAge(LocalDate dob) throws DateRelatedException {
		if (dob == null) {
			throw new DateRelatedException("Date of birth is not valid.");
		}

		LocalDate today = LocalDate.now();
		if (dob.isAfter(today)) {
			throw new DateRelatedException("Date of birth is in the future.");
		}

		// Calculate age more accurately using dates
		int age = today.getYear() - dob.getYear();
		if (dob.plusYears(age).isAfter(today)) {
			age--; // Adjust if birthday hasn't occurred yet this year
		}

		return age;
	}


	public static  String dateToString(LocalDate date) throws DateRelatedException{

		if (date == null) {
			throw new DateRelatedException("Date is not valid.");
		}

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		String stringDate =  date.format(format);


		return stringDate;

	}
	
	public static LocalDate stringToDate(String strDate) throws DateRelatedException{

		if (strDate == null) {
			throw new DateRelatedException("Date is not valid.");
		}

		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		LocalDate date=  LocalDate.parse(strDate, format);


		return date;

	}
	
	public static String timeStamp() throws DateRelatedException {
        try {
            return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        } catch (Exception e) {
        	 e.printStackTrace();
            throw new DateRelatedException("Failed to format timestamp", e);
        }
    }


}
