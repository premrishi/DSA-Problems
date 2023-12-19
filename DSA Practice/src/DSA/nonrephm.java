package DSA;

import java.util.HashMap;

public class nonrephm {

	public static void main(String[] args) {
		String s = "aabbxxccddee";
		System.out.println(nonrep(s));
	}
	
	public static char nonrep(String s) {
		HashMap<Character, Integer> hMap = new HashMap<>();
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(!hMap.containsKey(ch)) {
			hMap.put(ch, 1);
			} else {
				hMap.put(ch, hMap.get(ch) + 1);
			}
		}
		
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(hMap.get(ch) == 1) {
				return ch;
			}
		}
		char x = 'n';
		return x;
	}

}
