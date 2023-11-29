package HashSet;

import java.util.HashSet;

public class HappyNumber {

	public static void main(String[] args) {
		System.out.println(happynum(19));
		// TODO Auto-generated method stub

	}
	
	public static boolean happynum(int num) {
		HashSet<Integer> hsett = new HashSet<>();
		while(!hsett.contains(num)) {
			hsett.add(num);
			num = sumofsquare(num);
			if(num == 1) {
				return true;
			}
		}
		return false;
		
	}
	
	public static int sumofsquare(int num) {
		int result = 0;
		while(num>0) {
			int unitplace = num%10;
			result += unitplace*unitplace;
			num = num/10;
		}
		return result;
		
	}

}
