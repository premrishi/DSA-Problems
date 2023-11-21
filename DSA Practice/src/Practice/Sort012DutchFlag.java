package Practice;

import java.util.Arrays;

public class Sort012DutchFlag {
	public static void main(String[] args) {
		int[] arr = { 0, 2, 2, 1, 1, 0, 0 };
		// System.out.println(Arrays.toString(sort012(arr)));
		System.out.println(Arrays.toString(sortedarray(arr)));

	}

	// Bruteforce
	public static int[] sort012(int[] arr) {
		// Initialize counters for each value (0, 1, and 2)
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;
		// Create a new array to store the sorted elements
		int[] ansarr = new int[arr.length];
		// Loop through the original array to count occurrences of 0, 1, and 2
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				count0++;
			} else if (arr[i] == 1) {
				count1++;
			} else if (arr[i] == 2) {
				count2++;
			}
		}
		// Fill the new array with 0s based on the count of 0s in the original array
		for (int i = 0; i < count0; i++) {
			ansarr[i] = 0;
		}
		// Fill the new array with 1s based on the count of 1s in the original array
		for (int i = count0; i < count0 + count1; i++) {
			ansarr[i] = 1;
		}
		// Fill the new array with 2s based on the count of 2s in the original array
		for (int i = count0 + count1; i < count0 + count1 + count2; i++) {
			ansarr[i] = 2;
		}
		return ansarr;

	}

	// Optimal
	public static int[] sortedarray(int[] arr) {
		// initialize low , high and i
		// i is to iterate through the array
		int low = 0;
		int i = 0;
		int high = arr.length - 1;
		// iterate untill i and high
		while (i < high) {
			// if the array is 1, then increment i
			if (arr[i] == 1) {
				i++;
			}
			// if arr is 0, the swap low with i and increment i and low
			else if (arr[i] == 0) {
				swap(arr, low, i);
				i++;
				low++;
			}
			// if arr i is 2, then swap high with 2 and decrement high
			else {
				swap(arr, high, i);
				high--;
			}
		}
		return arr;

	}

	// Swapping menthod
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;

	}

}
