package Strings;

import java.util.Arrays;

public class countstringfrequency {
	public static void main(String[] args) {
		String s = "aaabcdf";
		System.out.println(Arrays.toString(stringfreq(s)));
	}
	
	public static int[] stringfreq(String s) {
		int[] sarr = new int[26];
		
		for(int l=0; l<s.length(); l++) {
			//we are going inside the parr array and getting the 0 index. to get 0 index, we are subracting
			//with a. parr[a - 'a'] = 0
			//parr[0] += 1
			sarr[s.charAt(l) - 'a'] += 1;
		}
		return sarr;
		
	}

}
