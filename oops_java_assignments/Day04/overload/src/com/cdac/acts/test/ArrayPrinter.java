package com.cdac.acts.test;



public class ArrayPrinter {
	    public static void printArray(int[] arr) {
	        System.out.print("Integer Array: ");
	        for (int num : arr) {
	            System.out.print(num + " ");
	        }
	        System.out.println();
	    }

	    public static void printArray(String[] arr) {
	        System.out.print("String Array: ");
	        for (String str : arr) {
	            System.out.print(str + " ");
	        }
	        System.out.println();
	    }
	}

