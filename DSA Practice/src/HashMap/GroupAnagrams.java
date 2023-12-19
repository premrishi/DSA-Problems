// Import necessary classes for HashMap, ArrayList
package HashMap;
import java.util.ArrayList;
import java.util.HashMap;

// Class to group anagrams from an array of strings
public class GroupAnagrams {

    public static void main(String[] args) {
        // Array of strings containing words
        String[] strs = {"abcd", "bacd", "abbc", "acbb", "abdd"};

        // Global HashMap to store anagrams grouped by their character frequencies
        HashMap<HashMap<Character, Integer>, ArrayList<String>> globalHashMap = new HashMap<>();

        // Iterate through each word in the array
        for (int index = 0; index < strs.length; index++) {
            // Get the current word from the array
            String str = strs[index];

            // HashMap to store the frequency of each character in the current word
            HashMap<Character, Integer> frequencyHashMap = new HashMap<>();

            // Calculate the frequency of each character in the current word
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (!frequencyHashMap.containsKey(ch)) {
                    frequencyHashMap.put(ch, 1);
                } else {
                    frequencyHashMap.put(ch, frequencyHashMap.get(ch) + 1);
                }
            }

            // Print the frequency HashMap for the current word
            System.out.println(frequencyHashMap);

            // Check if the globalHashMap already contains the frequency HashMap
            if (!globalHashMap.containsKey(frequencyHashMap)) {
                // If not, create a new ArrayList and add the current word
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(str);
                globalHashMap.put(frequencyHashMap, arrayList);
            } else {
                // If yes, get the existing ArrayList and add the current word
                ArrayList<String> arrayList = globalHashMap.get(frequencyHashMap);
                arrayList.add(str);
            }
        }


        // Convert the values of globalHashMap to an ArrayList of ArrayLists
        ArrayList<ArrayList<String>> arrayLists = new ArrayList<>();
        
        for (ArrayList<String> val: globalHashMap.values()) {
            arrayLists.add(val);
        }

        // Print the final result, which is an ArrayList of groups of anagrams
        System.out.println(arrayLists);
    }
}
