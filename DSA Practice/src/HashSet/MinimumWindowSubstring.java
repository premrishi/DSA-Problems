package HashSet;
import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        // Input strings
        String s = "ADOBECODEBANC";
        String t = "ABC";

        // Find and print the minimum window substring
        String result = minWindowSubstring(s, t);
        System.out.println(result);
    }

    public static String minWindowSubstring(String s, String t) {
        // Map to store character frequencies of the target string
        HashMap<Character, Integer> targetMap = new HashMap<>();
        char[] chararr = t.toCharArray();

        // Initialize the targetMap with character frequencies of the target string
        for (int i = 0; i<chararr.length; i++) {
        	char c = chararr[i];
            targetMap.put(c, targetMap.getOrDefault(c, 0)+1);
        }

        // Pointers for the sliding window
        int i = 0, j = 0;

        // Count of characters to match in the target string
        int count = targetMap.size();

        // Variables to track the minimum window substring
        int minLen = Integer.MAX_VALUE;
        int windowStartAns = 0;

        // Loop through the input string using two pointers
        while (j < s.length()) {
            char q = s.charAt(j);

            // Update the targetMap and count for the j character
            if (targetMap.containsKey(q)) {
                targetMap.put(q, targetMap.get(q) - 1);
                if (targetMap.get(q) == 0) {
                    count--;
                }
            }

            // Check if all characters in the target string are matched
            while (count == 0) {
                // Shrink the window and check if a better answer can be obtained
                // Update the minimum window if the current window is smaller
                if (j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    windowStartAns = i;
                }

                // Contract the window from the left
                char iChar = s.charAt(i);
                if (targetMap.containsKey(iChar)) {
                    targetMap.put(iChar, targetMap.get(iChar) + 1);
                    if (targetMap.get(iChar) > 0) {
                        count++;
                    }
                }

                i++;
            }

            // Expand the window to the right
            j++;
        }

        // Return the minimum window substring or an empty string if no valid window is found
        if (minLen == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(windowStartAns, windowStartAns + minLen);
        }

    }
}

