package HashMap;

import java.util.HashMap;

public class LargestSubarrwithequal0and1 {
    public static void main(String[] args) {
        // Example arrays to test different cases
        // int[] arr = {0, 1, 0, 1};
        // int[] arr = {0, 0, 1, 1};
        // int[] arr = {1, 1, 0, 0, 1, 1, 1, 0, 0};
        int[] arr = {0, 1};
        // int[] arr = {0, 1, 0, 1, 0, 1};

        // HashMap to store the cumulative sum and its corresponding index
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1); // Initialize the map with 0 sum at index -1

        int sum = 0; // Variable to store the cumulative sum
        int ans = 0; // Variable to store the length of the largest subarray with equal 0s and 1s

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // Update the cumulative sum based on the current element
            if (arr[i] == 0) {
                sum += -1;
            } else {
                sum += arr[i];
            }

            // Check if the current cumulative sum is already in the map
            if (!hashMap.containsKey(sum)) {
                // If not, add the current sum and its index to the map
                hashMap.put(sum, i);
            } else {
                // If yes, calculate the length of the subarray with equal 0s and 1s
                // and update the maximum length if needed
                int index = hashMap.get(sum);
                int len = i - index;
                ans = Math.max(ans, len);
            }
        }

        // Print the length of the largest subarray with equal 0s and 1s
        System.out.println(ans);
    }
}

