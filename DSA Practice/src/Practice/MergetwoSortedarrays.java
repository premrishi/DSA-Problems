package Practice;


import java.util.Arrays;

public class MergetwoSortedarrays {
	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7, 9 };
		int[] arr2 = { 2, 4, 6, 8, 10 };
		// System.out.println(Arrays.toString(ans1(arr1, arr2)));
		ans2(arr1, arr2);

	}

	// #Bruteforce
	public static int[] ans1(int[] arr1, int[] arr2) {
		// Create a global array of length arr1 and arr2
		int[] garray = new int[arr1.length + arr2.length];
		// initialize 3 pointers for 3 arrays
		int i = 0;
		int j = 0;
		int k = 0;
		// enter the loop if the size is always greater than 0
		while (i < arr1.length && j < arr2.length) {
			// check which value is smaller and insert to global array
			if (arr1[i] < arr2[j]) {
				garray[k] = arr1[i];
				i++;
				k++;
			} else {
				garray[k] = arr2[j];
				j++;
				k++;
			}
		}
		// if the given array size is not equal
		// if the 1st array is larger than 2nd
		// put all the rest values to garray
		while (i < arr1.length) {
			garray[k] = arr1[i];
			i++;
			k++;
		}
		// if the 2nd array is larger than 1st
		// put all the rest values to garray
		while (j < arr2.length) {
			garray[k] = arr2[j];
			j++;
			k++;
		}
		return garray;
	}

	// #Optimal
	public static void ans2(int[] arr1, int[] arr2) {
		// initialize 2 pointers for arr1 and arr2
		int i = arr1.length - 1;
		int j = 0;
		// enter while i>=0 and j<arr2.length
		while (i >= 0 && j < arr2.length) {
			// check if the element in 1st array end with element in 2nd array
			if (arr1[i] > arr2[j]) {
				// Swap
				int temp = arr1[i];
				arr1[i] = arr2[j];
				arr2[j] = temp;
				i--;
				j++;
			} else {
				break;
			}
		}
		// Sort both arrays
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
	}

}
