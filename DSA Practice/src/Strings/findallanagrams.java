package Strings;

import java.util.ArrayList;

public class findallanagrams {
	public static void main(String[] args) {
		String s = "abcabd";
		String p = "ab";
		System.out.println(findanagrams(s, p));
	}
	
	public static ArrayList<Integer> findanagrams(String s, String p) {
		//declare window start and window end
		int i = 0;
		int j = 0;
		//declare a variable to count occurances
		int count = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		//find the window length
		int k = p.length();
		//declare two new arrays of size 26 for both strings
		int[] sarr = new int[26];
		int[] parr = new int[26];
		//Now fill the parr with frequency array for string p
		for(int l=0; l<p.length(); l++) {
			//we are going inside the parr array and getting the 0 index. to get 0 index, we are subracting
			//with a. parr[a - 'a'] = 0
			//parr[0] += 1
			parr[p.charAt(l) - 'a'] += 1;
		}
		
		//now enter the s with window end
		while(j<s.length()) {
			//now enter the sarr and create a frequency table
			sarr[s.charAt(j) - 'a'] += 1;
			//check if window size is reached
			if(j-i+1 == k) {
				//check if the anagram is true
				if(isAnagram(sarr, parr)) {
					//update count by adding 1;
					count++;
					ans.add(i);
				}
				//slide the window
				sarr[s.charAt(i) - 'a'] -= 1;
				i++;
			}
			j++;
		}
		return ans;

	}
	
	public static boolean isAnagram(int[] sarr, int[] parr) {
		for(int i=0; i<parr.length; i++) {
			if(parr[i] != sarr[i]) {
				return false;
			}
		}
		return true;
		
	}

}
