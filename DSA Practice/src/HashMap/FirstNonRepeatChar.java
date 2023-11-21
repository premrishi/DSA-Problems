package HashMap;

import java.util.HashMap;

public class FirstNonRepeatChar {
    public static void main(String[] args) {
        // Input string
        String s = "zzabbcaddecfab";

        // HashMap to store the frequency of each character in the string
        HashMap<Character, Integer> hashMap = new HashMap<>();

        // Step 1: Count the frequency of each character in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If the character is not in the HashMap, add it with a count of 1
            if (!hashMap.containsKey(ch)) {
                hashMap.put(ch, 1);
            } else {
                // If the character is already in the HashMap, increment its count
                hashMap.put(ch, hashMap.get(ch) + 1);
            }
        }

        // Print the frequency map of characters
        System.out.println("Frequency Map: " + hashMap);

        // Step 2: Find the first non-repeating character in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Check if the frequency of the character is 1 (non-repeating)
            if (hashMap.get(ch) == 1) {
                // Print and break when the first non-repeating character is found
                System.out.println("First Non-Repeating Character: " + ch);
                break;
            }
        }
    }
}

