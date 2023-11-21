package Practice;

public class BuyandSellstock {
	public static void main(String[] args) {
		int[] arr = { 5, 7, 8, 3, 6, 10 };
		// System.out.println(brutebuysell(arr));
		System.out.println(buysell(arr));

	}

	// #Bruteforce
	public static int brutebuysell(int[] arr) {
		// The approach includes more space
		// find the minimum on each day and then subract to get the profit
		// declare min value
		int minval = Integer.MAX_VALUE;
		int maxvalue = Integer.MIN_VALUE;
		// create a new array to store minsofor values
		int[] minsofor = new int[arr.length];
		// create a new profit array to store the profit on each days
		int[] profit = new int[arr.length];
		// traverse through the array and store the value
		for (int i = 0; i < arr.length; i++) {
			// if the current value is less than min value, then that is min
			if (arr[i] < minval) {
				minval = arr[i];
			}
			// store the minsofor array with min value
			minsofor[i] = minval;
		}

		// Traverse through the profit array
		for (int i = 0; i < profit.length; i++) {
			// now find the difference between stock price with its minsofor array and store
			// it
			profit[i] = arr[i] - minsofor[i];
		}
		// Now find the maximum value in the profit array
		for (int i = 0; i < profit.length; i++) {
			if (profit[i] > maxvalue) {
				maxvalue = profit[i];
			}
		}
		return maxvalue;

	}

	// #Optimal
	public static int buysell(int[] arr) {
		// Declare initial profit as 0
		int profit = 0;
		// start the array from index 1
		// Traverse through the array
		for (int i = 1; i < arr.length; i++) {
			// if index 1 is greater than index 0 (index - 1)
			if (arr[i] > arr[i - 1]) {
				// subract index 1 with index -1 and add it to the profit
				profit += arr[i] - arr[i - 1];
			}
		}
		return profit;

	}
}
