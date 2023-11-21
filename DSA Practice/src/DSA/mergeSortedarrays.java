package DSA;

import java.util.Arrays;

public class mergeSortedarrays {

	public static void main(String[] args) {
		int[] arr1 = {1,3,5,7,9};
		int[] arr2 = {2,4,6,11,15};
		mergedans(arr1,arr2);

	}
	
	//Method to merge sorted arrays without using extra space
	public static void mergedans(int[] arr1, int[] arr2) {
		int i = arr1.length-1;
		int j = 0;
		while(i>=0 && j< arr2.length) {
		if(arr1[i]>arr2[j]) {
			int temp = arr1[i];
			arr1[i] = arr2[j];
			arr2[j] = temp;
			j++;
			i--;
		}else {
			break;
		}
			
		}
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
	}

}
