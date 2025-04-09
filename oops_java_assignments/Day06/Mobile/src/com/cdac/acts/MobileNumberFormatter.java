package com.cdac.acts;

public class MobileNumberFormatter {
    public static String formatMobileNumber(String number) {
    	//replace non number
        number = number.replaceAll("[^0-9]", "");

        //10 numbers only
        if (number.length() < 10) {
            return "Error: Number must be at least 10 digits.";
        }

        // country code +91
        if (number.length() == 10) {
            number = "+91" + number;
        } else if (number.length() == 12 && number.startsWith("91")) {
            number = "+" + number;
        }

        //format number as +91-XXX-XXX-XXXX
        return number.replaceFirst("([+91]{3})(\\d{3})(\\d{3})(\\d{4})", "$1-$2-$3-$4");
    }

    public static void main(String[] args) {
        String[] testNumbers = {"+91-988-162-8598", "+919881628598", "9881628598", "988162859"};
        
        for (String number : testNumbers) {
            System.out.println("Input: " + number);
            System.out.println("Formatted: " + formatMobileNumber(number));
            System.out.println("----------------------------------");
        }
    }
}
