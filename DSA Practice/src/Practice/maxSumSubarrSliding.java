package Practice;

public class maxSumSubarrSliding {
	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 2, 9, 7, 1 };
		int k = 3;
		System.out.println(maxsumsbarrsliding(arr, k));
	}

	public static int maxsumsbarrsliding(int[] arr, int k) {
		// Declare the window start and window end
		int i = 0;
		int j = 0;
		// declare current window sum
		int cws = 0;
		// declare maxsum
		int maxsum = Integer.MIN_VALUE;
		// enter the array with window end
		while (j < arr.length) {
			// find the current window sum by adding values of j
			cws += arr[j];
			// check if it has reached the window size
			if (j - i + 1 == k) {
				// if it has reahced the window, find the max sum on the fly
				maxsum = Math.max(cws, maxsum);
				// Now slide the window
				// remove the first value from cws
				cws -= arr[i];
				// move the window start and slide
				i++;
			}
			j++;
		}
		return maxsum;

	}

}
