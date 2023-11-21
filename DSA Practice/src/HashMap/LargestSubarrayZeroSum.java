package HashMap;

import java.util.HashMap;

public class LargestSubarrayZeroSum {

	public static void main(String[] args) {
		int[] arr = {15,-2,2,-8,1,7,10,23};
		System.out.println(largestsubarraywithzerosum(arr));

	}
	
	public static int largestsubarraywithzerosum(int[] arr) {
		//create a hashmap
		int currsum = 0;
		int maxsubarr = 0;
		HashMap<Integer, Integer> hMap = new HashMap<>();
		hMap.put(0, -1);
		for(int i=0; i<arr.length; i++) {
			currsum += arr[i];
			if(hMap.containsKey(currsum)) {
				maxsubarr = Math.max(maxsubarr, i - hMap.get(currsum));
			} else {
				hMap.put(currsum, i);
			}
		}
		
		return maxsubarr;
	}

}
