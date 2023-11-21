package Practice;

public class Kadanemaxsumsubarray {
	public static void main(String[] args) {
		int[] arr = { -5, 4, 6, -3, 4, 1 };
		System.out.println(kadane(arr));
		System.out.println(kadaneopt(arr));

	}

	// #Bruteforce
	public static int kadane(int[] arr) {
		// Nested loops approach, declare maxsum and current sum
		int maxsum = Integer.MIN_VALUE;
		int currentsum = 0;
		// To get all the subarrays, use nested loops
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				// add the current sum from two loops
				currentsum = arr[i] + arr[j];
				// Find the maximum with math.max function
				maxsum = Math.max(currentsum, maxsum);
			}
		}
		return maxsum;

	}

	// #Optimal
	public static int kadaneopt(int[] arr) {
		// Using only one loop
		// Max so-far approach
		// Declare max sum and current sum
		int maxsum = Integer.MIN_VALUE;
		int currentsum = 0;
		// Find current sum so far and find max of it
		for (int i = 0; i < arr.length; i++) {
			currentsum += arr[i];
			maxsum = Math.max(currentsum, maxsum);
			// if current sum is negative, make current sum as 0.
			if (currentsum < 0) {
				currentsum = 0;
			}
		}
		return maxsum;

	}

}
