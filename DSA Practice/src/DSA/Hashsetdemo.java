package DSA;

import java.util.HashSet;

public class Hashsetdemo {

	public static void main(String[] args) {
		HashSet<Integer> hSet = new HashSet<>();
		int[] arr = {1,2,3,4,4,4,4,6};
		for(int i = 0; i<arr.length; i++) {
			hSet.add(arr[i]);
		}
		
		for(int nums : hSet) {
			System.out.println(nums);
		}
		
		System.out.println(hSet);
		

	}

}
