package com.cdac.acts;

public class RevString {
    public static void main(String[] args) {
        String original = "Hello Paji";

        // inbuilt method
        String reversed = new StringBuilder(original).reverse().toString();
        System.out.println("Reversed using StringBuilder: " + reversed);
    }
}


