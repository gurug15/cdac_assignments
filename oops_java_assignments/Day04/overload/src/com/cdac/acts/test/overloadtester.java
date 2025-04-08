package com.cdac.acts.test;
import com.cdac.acts.test.ArrayPrinter;
public class overloadtester {

	public static void main(String[] args) {
		ArrayPrinter AP = new ArrayPrinter();
		int arr[] = new int[] {1,2,3,4};
		AP.printArray(arr);
		String str[] = new String[] {"adi","atul"};	
		AP.printArray(str);
	}
}
