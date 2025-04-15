package com.cdac.acts.dateutils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtils {
	public final static String INPUT_FORMAT = "dd-MM-yyyy";
	public final static String OUTPUT_FORMAT = "yyyy/MM/dd";
	private DateUtils() {
		
	}
	
	// Method to convert a string to a LocalDate
    public static LocalDate stringToDate(String dateInput) {
        try {
            // Define the input date format
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(INPUT_FORMAT);
            // Parse the input string to LocalDate
            return LocalDate.parse(dateInput, inputFormatter);
        } catch (DateTimeParseException e) {
            System.err.println("Error: Invalid date or format. Please check your inputs.");
            return null;
        }
    }

    // Method to convert a LocalDate to a string
    public static String dateToString(LocalDate date) {
        try {
            // Define the output date format
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(OUTPUT_FORMAT);
            // Format the LocalDate to string
            return date.format(outputFormatter);
        } catch (Exception e) {
            System.err.println("Error: Unable to format the date. Please check the inputs.");
            return null;
        }
    }
}
