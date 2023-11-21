package HashMap;
import java.util.Arrays;
import java.util.HashMap;

public class twoSum {
	public static void main(String[] args) {
		int[] arr = {1,4,5,6,9,10};
		int target = 11;
		System.out.println(Arrays.toString(twosum(arr, target)));
	}
	
	public static int[] twosum(int arr[], int target) {
		// Create a HashMap to store values from the array along with their indices.
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		// Create an array named "ans" to store the result, initialized with two zeros.
		int[] ans = new int[2];
		
		// Loop through each element in the array.
		for(int i = 0; i<arr.length; i++) {
			// Check if the complement (target - current element) is not present in the HashMap.
			if(!hashMap.containsKey(target - arr[i])) {
				// If not present, add the current element and its index to the HashMap.
				hashMap.put(arr[i], i);
			} else {
				// If the complement is present, set the first element of the result array to the index of the complement
				// and the second element to the current index.
				ans[0] = hashMap.get(target - arr[i]);
				ans[1] = i;
			}
		}
		
		// Return the result array containing two indices.
		return ans;
	}
}

