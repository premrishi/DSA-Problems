package Strings;

public class reverseString {
	public static void main(String[] args) {
		String s1 = "hello";
		System.out.println(reverse(s1));
	}
	
	public static char[] reverse(String s1) {
		//create new char array by converting the string to character array
		char[] ans = s1.toCharArray();
		//declare two pointers l and r
		int l = 0;
		int r = ans.length-1;
		//enter the array
		while(l<r) {
			//swap elements
			char temp = ans[l];
			ans[l] = ans[r];
			ans[r] = temp;
			//after 1 swap. increment and decrement the pointers
			l++;
			r--;
		}
		return ans;
		
	}

}
