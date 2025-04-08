package com.cdac.acts;

import java.util.Scanner;

public class Number {
    private static final String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] scales = {"", "Thousand", "Lakh", "Crore"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();
        System.out.println("Number in words: " + convertToWords(number));
    }

    private static String convertToWords(long number) {
        if (number == 0) {
            return "Zero";
        }

        String result = "";

        long[] parts = new long[4];
        parts[0] = number % 1000;
        number /= 1000;
        parts[1] = number % 100;
        number /= 100;
        parts[2] = number % 100;
        number /= 100;
        parts[3] = number;

        for (int i = parts.length - 1; i >= 0; i--) {
            if (parts[i] != 0) {
                result += convertThreeDigits((int) parts[i]) + " " + scales[i] + " ";
            }
        }

        return result.trim();
    }

    private static String convertThreeDigits(int number) {
        String result = "";

        if (number >= 100) {
            result += units[number / 100] + " Hundred ";
            number %= 100;
        }

        if (number >= 10 && number <= 19) {
            result += teens[number - 10] + " ";
        } else if (number >= 20) {
            result += tens[number / 10] + " ";
            number %= 10;
        }

        if (number >= 1 && number <= 9) {
            result += units[number] + " ";
        }

        return result.trim();
    }
}
