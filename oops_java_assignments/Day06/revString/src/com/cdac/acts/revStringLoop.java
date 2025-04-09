package com.cdac.acts;

public class RevStringLoop {

	public static void main(String[] args) {
		//original string
		String original = "Hello CDAC ACTS";
        //string to store reversed
		String reversed = "";

        //loop
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed = reversed + original.charAt(i);
        }

        System.out.println("Reversed using loop: " + reversed);

	}

}



