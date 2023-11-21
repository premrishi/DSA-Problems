package Practice;

public class Containsmostwater {
	public static void main(String[] args) {
		int[] arr = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(mostwaterarea(arr));

	}

	// optimal
	public static int mostwaterarea(int[] arr) {
		// Two pointer approach
		// Initialize l = 0 and r as arr.len-1
		int l = 0;
		int r = arr.length - 1;
		// Declare maxarea value
		int maxarea = Integer.MIN_VALUE;
		// now traverse through the array
		while (l < r) {
			// r-1 is the length and math min of those two values is the breadth
			// we are taking min value as breadth because only till that value watter can be
			// stored
			int currentarea = (r - l) * Math.min(arr[l], arr[r]);
			maxarea = Math.max(maxarea, currentarea);
			// after one pass through
			if (arr[l] < arr[r]) {
				l++;
			} else {
				r--;
			}
		}
		return maxarea;

	}

}
