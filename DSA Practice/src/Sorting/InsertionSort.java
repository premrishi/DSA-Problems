package Sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,1,5,2,9,8};
		insertsort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void insertsort(int[] arr) {
		//start from 1
		for(int i=1; i<arr.length; i++) {
			int j = i-1;
			int key = arr[i];
			
			while(j>=0 && arr[j]>key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
		
	}

}
