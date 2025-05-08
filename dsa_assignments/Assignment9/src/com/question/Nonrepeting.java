package com.question;

import java.util.LinkedHashMap;
import java.util.Map;

public class Nonrepeting {

	public static char nonRepeting(String str) {

		for(int i=0;i<str.length();i++) {
			boolean nonRepeating = true;
			for(int j=0;j<str.length();j++) {
				if(str.charAt(i)==str.charAt(j) && i!=j) {
					nonRepeating = false;
					break;
				}
			}
			if(nonRepeating) {
				return str.charAt(i);
			}

		}

		return '\0';
	}
	public static char nonRepetingUsingMap(String str) {
		Map<Character, Integer> count = new LinkedHashMap<Character, Integer>();
		for(int i=0;i<str.length();i++) {
			count.put(str.charAt(i), count.getOrDefault(str.charAt(i), 0)+1);
		}

		for(Map.Entry<Character, Integer> entry: count.entrySet()) {
			if(entry.getValue() == 1) {
				return entry.getKey();
			}
		}

		return '\0';
	}


	public static void main(String[] args) {
		System.out.println(nonRepeting("abcabdc"));
		System.out.println(nonRepetingUsingMap("abcabdc"));

	}

}
