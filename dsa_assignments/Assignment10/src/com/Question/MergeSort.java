
package com.Question;

import java.util.Arrays;

public class MergeSort {
	public static void mergeSort(int[] arr,int start, int end) {
		if(start>=end){
			return;
		}
		int mid = start + (end-start)/2;
		mergeSort(arr, start, mid);
		mergeSort(arr, mid+1, end);
		merge(arr, start, mid, end);
		
	}
	
	public static void merge(int arr[] , int start,int mid,int end) {
		int first = start;
		int second = mid+1;
		int idx = 0;
		int mergedArr[] = new int[arr.length];
		while(first <= mid && second <=end) {
			if(arr[first]<arr[second]) {
				mergedArr[idx] = arr[second];
				idx++;
				second++;
			}else {
				mergedArr[idx] = arr[first];
				idx++;
				first++;
			}
		}
		
		
		while(first<=mid) {
			mergedArr[idx] = arr[first];
			idx++;
			first++;
		}
		while(second<=end) {
			mergedArr[idx] = arr[second];
			idx++;
			second++;
		}
		
		int i = start;
		int j = 0;
		while(j<idx) {
			arr[i] = mergedArr[j];
			i++;
			j++;
		}
	
	}
	
	
	public static void main(String[] args) {
		int []arr = new int[]{1,2,3,4,5,3,2,451,21,4,12};
		System.out.println(arr[arr.length/2]);
		System.out.println(Arrays.toString(arr));
		//merge(arr, 0, arr.length/2, arr.length);
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}



