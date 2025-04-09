package com.cdac.acts;

public class WordOccurrence {
	public static void main(String[] args) {
		String text = "Java is powerful. Java is popular. Java is fun.";
		String word = "Java";

		//lowercase
		String[] words = text.toLowerCase().split("\\s+");

		int count = 0;
		for (String w : words) {
			if (w.equals(word.toLowerCase())) {
				count++;
			}
		}

		System.out.println("The word \"" + word + "\" appears " + count + " times in the string.");
	}
}
