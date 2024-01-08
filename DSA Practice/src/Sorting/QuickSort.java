package Sorting;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,5,77,1,0};
		quicksort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void quicksort(int[] arr, int l, int h) {
		if(l<h) {
			int q = partition(arr, l, h);
			quicksort(arr, l, q-1);
			quicksort(arr, q+1, h);
		}
	}
	
	public static int partition(int[] arr, int l, int h) {
		int pivot = arr[h];
		
		int i = l-1;
		
		for(int j=l; j<h; j++) {
			if(arr[j] <= pivot) {
				i++;
				
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		
		int temp = arr[i+1];
		arr[i+1] = arr[h];
		arr[h] = temp;
		
		return i+1;
	}

}
