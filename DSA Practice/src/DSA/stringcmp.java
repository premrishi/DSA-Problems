package DSA;

public class stringcmp {

	public static void main(String[] args) {
		String s = "aaabbbbbbaccdeee";
		System.out.println(compress(s));

	}
	
	public static String compress(String s) {
		String ans = s.charAt(0)+ "";
		
		for(int i=1; i<s.length(); i++) {
			char curr = s.charAt(i);
			char prev = s.charAt(i-1);
			if(curr != prev) {
				ans += curr;
			}
			
		}
		
		return ans;
	}

}
