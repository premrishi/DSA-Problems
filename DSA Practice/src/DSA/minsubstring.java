package DSA;  // This is a Java package declaration, specifying where the code is located.

public class minsubstring {
    public static void main(String[] args) {
        String s = "BABCDED";  // Define a string called 's' with the value "BABCDED".
        String t = "BD";  // Define another string called 't' with the value "BD".

        System.out.println(findMinWindow(s, t));  // Call the 'findMinWindow' function and print its result.
    }

    public static String findMinWindow(String s, String t) {
        // Define pointers for the window that helps find the minimum substring.
        int l = 0;  // 'l' is the left pointer.
        int r = 0;  // 'r' is the right pointer.

        // Define a variable to store the minimum window's length.
        int minvalue = Integer.MAX_VALUE;

        // Create an array to count the occurrences of characters in the 't' string.
        int[] arr = new int[128];

        // Define a string to store the answer (minimum substring).
        String anString = "";

        // Initialize a counter to keep track of characters we've matched.
        int matchcount = 0;

        // Convert both strings to character arrays for easier manipulation.
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();

        // Count and store the occurrences of characters from string 't' in the 'arr' table.
        for (int i = 0; i < t_arr.length; i++) {
            char cur = t_arr[i];
            arr[cur]++;
        }

        // Start a loop to find the minimum window.
        while (r < s_arr.length) {
            char currentchar = s_arr[r];

            // If the current character is in the 't' string, increase the counter.
            if (arr[currentchar] >= 1) {
                matchcount++;
            }

            // Decrease the count of the current character in the 'arr' table.
            arr[currentchar]--;

            // Check if we've matched all characters from 't'.
            while (matchcount == t_arr.length) {
                // Calculate the current window size.
                int curWindow = r - l + 1;

                // If the current window is smaller than the previous minimum, update the minimum values.
                if (curWindow < minvalue) {
                    minvalue = curWindow;
                    // Store the corresponding substring.
                    anString = s.substring(l, r + 1);
                }

                // Move the left pointer and update the 'arr' table.
                char charAtLeft = s_arr[l];
                arr[charAtLeft]++;

                // If the count of the character at the left pointer becomes greater than 0, decrease the counter.
                if (arr[charAtLeft] > 0) {
                    matchcount--;
                }

                // Move the left pointer to continue searching for the minimum window.
                l++;
            }

            // Move the right pointer to expand the window.
            r++;
        }

        // Return the minimum substring found.
        return anString;
    }
}
