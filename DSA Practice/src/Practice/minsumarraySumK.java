package Practice;

public class minsumarraySumK {
	public static void main(String[] args) {
		int[] arr = {4,1,1,2,0,3,5};
		int sum = 8;
		System.out.println(minsubarrSumK(arr, sum));
	}
	public static int minsubarrSumK(int[] arr, int sum) {
		//This problem, we have to find subarray whose sum is > or = sum
		//declare window start and end
		int i = 0;
		int j = 0;
		//declare current window sum
		int cws = 0;
		//declare minimum window length
		int minwinlen = Integer.MAX_VALUE;
		//enter the array with window end
		while(j<arr.length) {
			//calculate the current sum
			cws += arr[j];
			//check if current window sum is greater than or equal to sum
			while(cws >= sum) {
				//if so, the find the minimum window length
				minwinlen = Math.min(j-i+1, minwinlen);
				//now shrink the window and slide the window
				cws -= arr[i];
				i++;
			}
			j++;
		}
		return minwinlen;
	}

}
