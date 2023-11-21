package Practice;

public class EquilibriumofArray {
	public static void main(String[] args) {
		// int[] arr = {1,2,6,4,0,-1};
		// System.out.println(arrayequilib(arr));
		// System.out.println(optequi(arr));

	}

	// #Bruteforce
	public static int arrayequilib(int[] arr) {
		// Using 3 for loops, 2 for lsum and rsum and 1 for finding the ans
		// initialize 2 new arrays lsum and rsum
		int[] lsum = new int[arr.length];
		int[] rsum = new int[arr.length];
		// 1st value of lsum is equal to 1st value of arr
		lsum[0] = arr[0];
		// last value of rsum is equal to last value of arr
		rsum[rsum.length - 1] = arr[arr.length - 1];
		// Traverse through the array to fill lsum
		// Since we already found the 0th index value, start the index with 1
		for (int i = 1; i < arr.length; i++) {
			// lsum of i is equal to sum of it's previous value(i-1) and arr[i]
			lsum[i] = lsum[i - 1] + arr[i];
		}
		// Traverse through the array to fill rsum
		// since we already found the last index of rsum, start the index with its
		// before index.
		for (int i = arr.length - 2; i >= 0; i--) {
			// rsum of i is equal to sum of provious value rsum[len+1] and current arr[i]
			rsum[i] = rsum[i + 1] + arr[i];
		}
		// now traverse through the main array and find if lsum == rsum with if
		for (int i = 0; i < arr.length; i++) {
			if (lsum[i] == rsum[i]) {
				return i;
			}
		}
		return -1;
	}

	// #Optimal
	public static int optequi(int[] arr) {
		// Approach is we are finding rsum by subracting total with lsum
		// Initialize total sum and lef sum
		int totalsum = 0;
		int lsum = 0;
		// Traverse the array and find total sum
		for (int i = 0; i < arr.length; i++) {
			totalsum += arr[i];
		}
		// Traverse the array and find the lsum
		// Find if the lsum and rsum is equal in the same loop
		for (int i = 0; i < arr.length; i++) {
			// here arr[i] itself is the pivot element and that's why we are using
			if (lsum == totalsum - lsum - arr[i]) {
				return i;
			}
			lsum += arr[i];
		}
		return -1;
	}

}
