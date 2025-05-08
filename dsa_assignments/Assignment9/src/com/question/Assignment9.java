package com.question;

import java.util.Arrays;

public class Assignment9 {


	public static boolean findUsingLinearSearch(int[] arr, int element) {

		for(int i=0;i<arr.length;i++) {
			if(arr[i]== element) {
				return true;
			}
		}

		return false;
	}

	public static boolean findUsingBinarySearch(int[] arr, int element) {
		int low = 0;
		int high = arr.length-1;

		while(high>=low) {
			int mid = low + (high-low)/2;
			if(arr[mid] == element) {
				return true;
			}

			if(arr[mid]>element) {
				high = mid-1;
			}else {
				low = mid + 1;
			}
		}


		return false;
	}

	public static void bubbleSort(int[] arr) {
		int loopcount = 0;
		boolean swaps = false;
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-i-1;j++) {
				++loopcount;
				if(arr[j]<arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swaps = true;
				}
				if(!swaps) break;
			}
		}
		System.out.println(loopcount);
	}
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] < key) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = key;
		}
	}

	public static boolean isArraySorted(int[] arr) {

		if(arr.length < 2) {
			return true;
		}
		boolean flag =false;
		for(int i=0 ;i< arr.length ; i++) {
			for(int j=0 ; j<arr.length-1 ; j++) {
				if(arr[j]<arr[j+1]) {
					flag = true;
				}else {
					return false;
				}
			}

		}

		return flag;	
	}

	public static void main(String[] args) {
		int unSortedArr[] = new int[] {1,6,3,5,9,5,4,2,2,7,21,56};
		int sortedArr[] = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,15,17};
		int bubbleSort[] =  new int[] {1,6,3,5,9,5,4,2,2,7,21,56};
		System.out.println(findUsingLinearSearch(unSortedArr, 10));
		System.out.println(findUsingBinarySearch(sortedArr, 14));
		System.out.println("bulbule sort");
		System.out.println("before sort: " + Arrays.toString(bubbleSort));
		bubbleSort(bubbleSort);
		System.out.println("after sort: " + Arrays.toString(bubbleSort));
		bubbleSort(bubbleSort);
		System.out.println("after sort: " + Arrays.toString(bubbleSort));
		System.out.println("Before sorting: " + Arrays.toString(unSortedArr));
		insertionSort(unSortedArr);
		System.out.println("After sorting in descending order: " + Arrays.toString(unSortedArr));
		System.out.println(isArraySorted(bubbleSort));
	}

}
