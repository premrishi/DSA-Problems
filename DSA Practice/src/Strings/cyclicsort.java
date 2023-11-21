package Strings;

import java.util.Arrays;

public class cyclicsort {
	public static void main(String[] args) {
		int[] arr = {4,5,6,7,0,2,1,3};
		System.out.println(Arrays.toString(cyclicsorted(arr)));
	}
	
	public static int[] cyclicsorted(int[] arr) {
		int i=0;
		while(i<arr.length) {
		int element = arr[i];
		int indexposition = element;
			if(arr[i]<arr.length && arr[indexposition] != element) {
				swap(arr, i, indexposition);
			} else {
				i++;
			}
		}
		return arr;
		
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
