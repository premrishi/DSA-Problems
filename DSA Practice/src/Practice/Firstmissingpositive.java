package Practice;

public class Firstmissingpositive {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		System.out.println(missingPositive(arr));
	}

	// Bruteforce
	public static int missingPositive(int[] arr) {
		// The approach is similar to the frequency distribution
		// Initialize max value
		int maxvalue = Integer.MIN_VALUE;
		// Traverse throught the array to find max value of the array
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > maxvalue) {
				maxvalue = arr[i];
			}
		}
		// Create a new array of size max value+1(+1 is to fix outbound)
		int freqarr[] = new int[maxvalue + 1];
		// Traverse through the array and find index
		for (int i = 0; i < arr.length; i++) {
			// check negative numbers and ignore
			if (arr[i] > 0) {
				int index = arr[i];
				// Increment the value in the index when ever we get the values in main array
				freqarr[index]++;
			}
		}
		// Traverse through the updated fre array to find which element is the first 0
		// after normal 0
		for (int i = 1; i < freqarr.length; i++) {
			if (freqarr[i] == 0) {
				return i;
			}

		}
		// if not, then all the positive numbers are present, so return the max value +
		// 1
		return maxvalue + 1;

	}

}
