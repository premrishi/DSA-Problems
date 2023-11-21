package Strings;

public class longestSubstringwithoutrepeating {
	public static void main(String[] args) {
		 String s = "abcdaabcdef";
		 System.out.println(longestsubstring(s));
	}
	
	public static int longestsubstring(String s) {
		//Sliding window + frequency distribution approach
		//declare window start and end
		int i=0;
		int j=0;
		//declare max value
		int maxval = Integer.MIN_VALUE;
		//declare new freq array sarr with 26
		int[] sarr = new int[26];
		//enter the array with the window
		while(j<s.length()) {
			//declare the index
			int index = s.charAt(j) - 'a';
			//increment freqindex if char is found
			sarr[index] += 1;
			//if u find duplicate value, shrink the window and move
			while(sarr[index]>1) {
				sarr[s.charAt(i) - 'a'] -= 1;
				i++;
			}
			//store the max value 
			maxval = Math.max(maxval, j-i+1);
			j++;
		}
		return maxval;
		
	}

}
