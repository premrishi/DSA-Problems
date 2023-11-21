package Strings;


public class firstuniquecharinstring {
	public static void main(String[] args) {
		String s = "aaabbccddffg";
		System.out.println(firstunique(s));
	}
	
	public static char firstunique(String s) {
		int[] sarr = new int[26];
		
		for(int l=0; l<s.length(); l++) {
			//we are going inside the parr array and getting the 0 index. to get 0 index, we are subracting
			//with a. parr[a - 'a'] = 0
			//parr[0] += 1
			sarr[s.charAt(l) - 'a'] += 1;
		}
		for(int i = 0; i<sarr.length; i++) {
			if(sarr[i] == 1) {
				return(char) (i + 'a');
			}
		}
		return 'x';
		
	}

}
