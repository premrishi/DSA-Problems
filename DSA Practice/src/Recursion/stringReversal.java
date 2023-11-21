package Recursion;

public class stringReversal {
	public static void main(String[] args) {
		String s = "hello";
		System.out.println(reverseString(s));
	}
	
	public static String reverseString(String s) {
		
		//if the string length is 0, then return empty string
		if(s.length() == 0) {
			return "";
		}
		
		//delcare a new variable and get the substring excluding first character
		//if the input is hello, this line will store "ello"
		//this is a recursive call
		String l = reverseString(s.substring(1));
		//now declare another string and store the first character
		String r = String.valueOf(s.charAt(0));
		//add the left and right
		String ans = l+r;
		
		return ans;
		
	}

}
