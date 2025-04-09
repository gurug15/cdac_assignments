package com.cdac.acts;

public class WordPresent {
	
    public static void main(String[] args) {
    	
        String text = "Hello, welcome to the world of programming!";
        String word = "world";

        //inbuilt method
        boolean isPresent = text.contains(word);

        if (isPresent) {
            System.out.println("The word \"" + word + "\" is present in the string.");
        } else {
            System.out.println("The word \"" + word + "\" is NOT present in the string.");
        }
    }
}
