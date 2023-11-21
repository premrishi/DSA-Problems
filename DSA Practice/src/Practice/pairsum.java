package Practice;

import java.util.Arrays;

public class pairsum {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6 };
		int target = 7;
		System.out.println(Arrays.toString(sumpair(arr, target)));

	}

	public static int[] sumpair(int[] arr, int target) {
		// Two pointer approach
		// Initialize i=0 and j at the last point of array
		int i = 0;
		int j = arr.length - 1;
		int sum;
		int paris[] = new int[2];
		// enter condition if i < j
		while (i < j) {
			// calculate the sum by adding both values
			sum = arr[i] + arr[j];
			// if target is found, return the arrays
			if (sum == target) {
				paris[0] = arr[i];
				paris[1] = arr[j];
				i++;
				j--;
			}
			// if target is less than sum, move the right pointer to left and vice versa
			if (sum > target) {
				j--;
			} else if (sum < target) {
				i++;
			}
		}

		return paris;

	}

}
