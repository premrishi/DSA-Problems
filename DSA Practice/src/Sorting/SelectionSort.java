package Sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,2,16,1,5,9};
		selectsort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void selectsort(int[] arr) {
		int n = arr.length;
		int minindex = -1;
		for(int i=0; i<n-1; i++) {
			minindex = i;
			for(int j=i+1; j<n; j++) {
				if(arr[minindex]>arr[j]) {
				minindex = j;
				}
			}
			swap(arr, minindex, i);
		}
		
	}
	
	public static void swap(int[] arr, int minindex, int i) {
		int temp = arr[minindex];
		arr[minindex] = arr[i];
		arr[i] = temp;
	}

}
