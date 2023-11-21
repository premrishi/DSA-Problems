package HashMap;

import java.util.HashMap;

public class IsoMorphicString {
    public static void main(String[] args) {
        // Example strings
//        String s = "egg";
//        String t = "add";

        // Example strings with different lengths
        String s = "foo";
        String t = "bar";

        // Check if the strings are isomorphic
        boolean ansIsIsomorphic = isIsomorphic(s, t);
        System.out.println(ansIsIsomorphic);
    }

    // Function to check if two strings are isomorphic
    public static boolean isIsomorphic(String s, String t) {
        // HashMaps to store the mapping of characters from s to t and vice versa
        HashMap<Character, Character> hashMapStoT = new HashMap<>();
        HashMap<Character, Character> hashMapTtoS = new HashMap<>();

        // Iterate through each character in the strings
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Check if the current characters violate the isomorphism
            if ((hashMapStoT.containsKey(c1) && hashMapStoT.get(c1) != c2) ||
                (hashMapTtoS.containsKey(c2) && hashMapTtoS.get(c2) != c1)) {
                // If a violation is found, the strings are not isomorphic
                return false;
            }

            // Update the mapping in both directions
            hashMapStoT.put(c1, c2);
            hashMapTtoS.put(c2, c1);
        }

        // If the loop completes without returning false, the strings are isomorphic
        return true;
    }
}
