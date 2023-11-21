package Strings;

import java.util.Arrays;

public class LongestCharacterReplacement {
	public static void main(String[] args) {
        String s = "ABABBA";
        int k = 2;

        int ansLongestCharacterReplacement = longestCharacterReplacement(s, k);
        System.out.println(ansLongestCharacterReplacement);
    }

    public static int longestCharacterReplacement(String s, int k) {
        int i=0;
        int j=0;
        int maxLength = Integer.MIN_VALUE;
        int[] sArr = new int[26];

        while (j < s.length()) {
            //initial work
            sArr[s.charAt(j) - 'A'] += 1;

            //breach of k, shrink the window => windowLength - max of frequency array
            while (j-i+1 - Arrays.stream(sArr).max().getAsInt() > k) {
                sArr[s.charAt(i) - 'A'] -= 1;
                i++;
            }

            maxLength = Math.max(maxLength, j-i+1);
            j++;
        }

        return maxLength;
    }

}
