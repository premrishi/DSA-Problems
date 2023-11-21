package Practice;

public class TrappingRainwater {
	public static void main(String[] args) {
		int arr[] = { 6, 2, 0, 1, 4, 9 };
		// System.out.println(Trappedwater(arr));
		System.out.println(opttrapedwater(arr));

	}

	// Bruteforce
	public static int Trappedwater(int[] arr) {
		// Declare trapped water value as 0
		int trappedwater = 0;
		// Declare two arrays lmax and rmax with lenght of the given array
		int[] lmax = new int[arr.length];
		int[] rmax = new int[arr.length];
		// Now traverse through the array and find lmax and rmax and fill it
		// Declare lmax[0] = arr[0]
		// Declare rmax[rmax.len-1] = arr[len-2]
		lmax[0] = arr[0];
		rmax[rmax.length - 1] = arr[arr.length - 1];
		for (int i = 1; i < arr.length; i++) {
			lmax[i] = Math.max(lmax[i - 1], arr[i]);
		}

		for (int i = arr.length - 2; i >= 0; i--) {
			rmax[i] = Math.max(rmax[i + 1], arr[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			trappedwater += (Math.min(lmax[i], rmax[i])) - arr[i];
		}
		return trappedwater;
	}

	// Optimal
	public static int opttrapedwater(int[] arr) {
		// Declare the trapped water as 0
		int trapedwater = 0;
		// We are finding lmax and lmax values for the i. so declare initially to 0
		int lmax = 0;
		int rmax = 0;
		// We are using two variables l and h to traverse through the array
		int l = 0;
		int h = arr.length - 1;
		// If the value at the left pointer is less than the value at the right pointer,
		while (l < h) {
			// process from the left
			if (arr[l] < arr[h]) {
				// update the left max value if the current value is greater than lmax
				if (lmax < arr[l]) {
					lmax = arr[l];
				}
				// Calculate traped water by subracting lmax from current value
				trapedwater += lmax - arr[l];
				l++;
			} else {
				// Process from the right
				if (rmax < arr[h]) {
					rmax = arr[h];
				}
				// Calculate traped water by subracting Rmax from current value
				trapedwater += rmax - arr[h];
				h--;
			}
		}
		return trapedwater;

	}

}
