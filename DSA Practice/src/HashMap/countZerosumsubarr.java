package HashMap;

import java.util.HashMap;

public class countZerosumsubarr {

	public static void main(String[] args) {
		int[] arr = {2,8,-3,-5,2,-4,6,1,2,1,-3,4};
		System.out.println(countzerosub(arr));

	}
	
	public static int countzerosub(int[] arr) {
		int anscount = 0;
		HashMap<Integer, Integer> hMap = new HashMap<>();
		int sum = 0;
		int i = -1;
		hMap.put(0, 1);
		
		while(i<arr.length-1) {
			i++;
			sum += arr[i];
			
			if(!hMap.containsKey(sum)) {
				hMap.put(sum, 1);
			} else {
				anscount +=hMap.get(sum);
				hMap.put(sum, hMap.get(sum) + 1);
			}
		}
		
		return anscount;

	}

}
