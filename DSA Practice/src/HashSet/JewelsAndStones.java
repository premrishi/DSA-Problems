package HashSet;

import java.util.HashSet;

public class JewelsAndStones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jewel = "aA";
		String stones = "aAAbbbb";
		//System.out.println(brutejwell(jewel, stones));
		//System.out.println(hashwithextraspace(jewel, stones));
		System.out.println(withoutspace(jewel, stones));

	}
	
	public static int brutejwell(String j, String s) {
		int count = 0;
		for(int i = 0; i<s.length(); i++) {
			char stonechar = s.charAt(i);
			for(int x=0; x<j.length(); x++) {
				if(j.charAt(x) == stonechar) {
					count++;
				}
			}
		}
		return count;
	}
	
	
	public static int hashwithextraspace(String j, String s) {
		int count = 0;
		//iterate over the jwell and create hashset
		HashSet<Character> hasSet = new HashSet<>();
		for(int i =0; i<j.length(); i++) {
			char jwellc = j.charAt(i);
			hasSet.add(jwellc);
		}
		
		for(int x = 0; x<s.length(); x++) {
			char stonee = s.charAt(x);
			if(hasSet.contains(stonee)) {
				count++;
			}
		}
		
		return count;
	}
	
	public static int withoutspace(String j, String s) {
		int[] jwellfreqarray = new int[256];
		int count = 0;
		for(int i=0; i<j.length(); i++) {
			jwellfreqarray[j.charAt(i)] += 1;
		}
		
		for(int x = 0; x<s.length(); x++) {
			char stnc = s.charAt(x);
			if(jwellfreqarray[stnc] == 1) {
				count++;
			}
		}
		
		return count;
	}

}
