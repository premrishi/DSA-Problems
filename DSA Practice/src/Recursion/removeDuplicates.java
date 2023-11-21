package Recursion;

public class removeDuplicates {
	public static void main(String[] args) {
		String s = "aabccqwwer";
		boolean[] freq = new boolean[26];
		removeduplicates(s, freq, "", 0);
		
		
	}
	
	public static void removeduplicates(String s, boolean[] freq, String ans, int index) {
		//this is the stopping condition for recursion
		if(index == s.length()) {
			System.out.println(ans);
			return;
		}
		
		//fetch the character at index
		char ch = s.charAt(index);
		//check if boolean array is false and enter
		if(freq[ch - 'a'] == false) {
			//now store that character in ans
			ans += ch;
			//now make that characters value as true so that next time it wont go there
			freq[ch - 'a'] = true;
		}
		
		//call the fuction recursively so that it acts like iteration
		//pass the values except for the index, incrememnt by 1
		removeduplicates(s, freq, ans, index+1);
		
	}
	

}
