package Sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {9,4,3,1,6,10};
		bubble(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void bubble(int[] arr) {
		int n = arr.length;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n-1; j++) {
				if(arr[j]>arr[j+1]) {
					swap(arr, j);
				}
			}
		}
	}
	
	public static void swap(int[] arr, int j) {
		int temp = arr[j];
		arr[j] = arr[j+1];
		arr[j+1] = temp;
	}

}
