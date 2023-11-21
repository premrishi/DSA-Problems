package DSA;

import java.util.Arrays;

public class cycl {

	public static void main(String[] args) {
		int arr[] = {2,5,1,3,4,0};
		System.out.println(Arrays.toString(cyclesort(arr)) );

	}
	
	public static int[] cyclesort(int arr[]) {
		//declare pointer i
		int i=0;
		while(i<arr.length) {
		int element = arr[i];
		int indexposition = element;
		if(arr[i]<arr.length && arr[indexposition] != indexposition) {
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
