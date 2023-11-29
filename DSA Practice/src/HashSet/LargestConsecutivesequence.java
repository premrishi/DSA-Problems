package HashSet;
import java.util.HashSet;
/* Problem: Longest Consecutive Sequence
 * Link: https://leetcode.com/problems/longest-consecutive-sequence/solution/
 */
public class LargestConsecutivesequence {
    public static void main(String[] args) {
        // Sample array of numbers
        int[] nums = {5, 4, 3, 2, 1};
        
        // HashSet to efficiently check for the existence of numbers
        HashSet<Integer> hashSet = new HashSet<>();

        // Populate the hashSet with all elements of the array
        for (int i = 0; i < nums.length; i++) {
            hashSet.add(nums[i]);
        }

        // Variable to store the length of the longest consecutive sequence
        int ans = 0;

        // Iterate through each number in the array
        for (int i = 0; i < nums.length; i++) {
            // Check if the current number is the start of a consecutive sequence
            if (!hashSet.contains(nums[i] - 1)) {
                int curr = nums[i];
                int currLen = 1;

                // Extend the consecutive sequence as long as possible
                while (hashSet.contains(curr + 1)) {
                    curr++;
                    currLen++;
                }

                // Update the length of the longest consecutive sequence
                ans = Math.max(ans, currLen);
            }
        }

        // Print the length of the longest consecutive sequence
        System.out.println("Length of the Longest Consecutive Sequence: " + ans);
    }
}

