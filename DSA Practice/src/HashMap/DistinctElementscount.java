package HashMap;

import java.util.ArrayList;
import java.util.HashMap;

public class DistinctElementscount {

	public static void main(String[] args) {
		int[] arr = {2,5,5,6,3,2,5};
		int k = 4;
		System.out.println(distinctelements(arr, k));

	}
	
	public static ArrayList<Integer> distinctelements(int[] arr, int k) {
	    // HashMap to store the count of each element in the current subarray
	    HashMap<Integer, Integer> hMap = new HashMap<>();

	    // ArrayList to store the result (distinct elements count for each subarray)
	    ArrayList<Integer> ans = new ArrayList<>();

	    // Pointers i and j for the start and end of the current subarray
	    int i = 0;
	    int j = 0;

	    // Iterate through the array
	    while (j < arr.length) {
	        // Update the count of the current element in the HashMap
	        if (!hMap.containsKey(arr[j])) {
	            // If the element is not in the HashMap, add it with count 1
	            hMap.put(arr[j], 1);
	        } else {
	            // If the element is already in the HashMap, increment its count
	            hMap.put(arr[j], hMap.get(arr[j]) + 1);
	        }

	        // Check if the current subarray has reached length k
	        if (j - i + 1 == k) {
	            // Add the count of distinct elements in the current subarray to the result
	            ans.add(hMap.size());

	            // Update the HashMap and pointers for the next subarray
	            if (hMap.get(arr[i]) == 1) {
	                // If the count of the element at the start of the subarray is 1, remove it
	                hMap.remove(arr[i]);
	            } else {
	                // If the count is greater than 1, decrement the count
	                hMap.put(arr[i], hMap.get(arr[i]) - 1);
	            }

	            // Move the start pointer to the next element
	            i++;
	        }

	        // Move the end pointer to the next element
	        j++;
	    }

	    return ans;
	}

}
