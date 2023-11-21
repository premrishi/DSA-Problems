package Recursion;

public class SubsequenceofString {
	public static void main(String[] args) {
		String s = "abc";
		subsequence(s, 0, "");
	}
	
	public static void subsequence(String s, int index, String newString) {
		//This is the stopping condition
		//check if the incremented index reaches the length of the string
		//if so, print the value
		if(index == s.length()) {
			System.out.println(newString);
			return;
		}
		//The approcch is we are taking the value in one branch and not taking the value in othe branch
		//store the current value at index
		char current = s.charAt(index);
		
		// The approach is to create two branches in the recursion tree:
		//call the function and pass incremented index, and call the left branch
		//that is, add the current value to the string
		//to be included
		// 1. Include the current character and move to the next index.
		subsequence(s, index+1, newString+current);
		
		//here call the function and pass incremented value 
		//call the function without adding current value
		//to not include
		// 2. Exclude the current character and move to the next index.
		subsequence(s, index+1, newString);
		
	}

}
