package Practice;

public class MajorityElement {
	public static void main(String[] args) {
		int[] arr = { 5, 1, 4, 1, 1 };
		System.out.println(majorityelement(arr));

	}

	// Optimal
	public static int majorityelement(int[] arr) {
		// Declare ansIndex = 0 and count as 1
		int count = 1;
		int ansIndex = 0;
		// Taverse through the array with for loop from 1 and see if the adjacent values
		// are equal or not
		for (int i = 1; i < arr.length; i++) {
			// cehck if ansindex and arr[i] are equal. if equal, increment count. else
			// decrememt count
			if (arr[i] == arr[ansIndex]) {
				count++;
			} else {
				count--;
			}
			// If both values are diffrent count becomes 0
			// if count becomes zero, make ansindex = i and count = 1
			if (count == 0) {
				ansIndex = i;
				count = 1;
			}
		}
		// Now the value of ansindex should be the possible majority element
		// check if ans index is majority element or not
		// declare anscount = 0 and traverse through the array and find of majority
		// element is majority
		int ansCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[ansIndex] == arr[i]) {
				ansCount++;
			}
		}
		// now check if anscount is greater than n/2
		if (ansCount > (arr.length) / 2) {
			return arr[ansIndex];
		}
		return -1;
	}

}
