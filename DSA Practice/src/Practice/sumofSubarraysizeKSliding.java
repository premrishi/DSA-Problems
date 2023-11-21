package Practice;

public class sumofSubarraysizeKSliding {
	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 2, 9, 7, 1 };
		int k = 3;
		sumofsubarrK(arr, k);

	}

	public static void sumofsubarrK(int[] arr, int k) {
		// declare window start and window end
		int i = 0;
		int j = 0;
		// declare current window sum
		// take the window and and enter the array
		int cws = 0;
		while (j < arr.length) {
			// calculate the current window sum by adding the values
			cws += arr[j];
			// now check if the window has reached the size of k
			if (j - i + 1 == k) {
				// if we got the window size, print the cws
				System.out.println(cws);
				// if the window reached the k size, slide the window
				// we already have cws, so remove the first value from it and slide
				cws -= arr[i];
				// now move the window start
				i++;
			}
			// move the window end
			j++;
		}

	}

}
