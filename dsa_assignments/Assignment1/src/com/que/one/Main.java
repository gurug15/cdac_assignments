package com.que.one;

import java.util.Arrays;

public class Main  {

	public static void main(String[] args) {
		int size = 5;
		int arr[] = new int[size];
		int count = 5;
		for(int i=0;i<count;i++) {
			arr[i] = i*5+1;
		}
		System.out.println("Arr before removing: "+ Arrays.toString(arr));
		count = deleteFromPosition(arr, count, 3);
		System.out.print("Arr before removing: [");
		for(int i=0;i<count;i++) {
			System.out.print(arr[i]+ ", ");
		}
		System.out.println("]");
	}

	
	public static int deleteFromPosition(int[] arr, int n, int pos) {

		
		for(int i=pos;i<n-1;i++) {
			arr[i] = arr[i+1];
		}
		
		
		return n-1;
	}
	
	


}
