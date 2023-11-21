package Practice;

public class maxsubarrayofSumK {
	public static void main(String[] args) {
		int[] arr = {4,1,1,1,2,3,5};
		int sum = 8;
		System.out.println(maxSubarrSumK(arr, sum));
	}
	public static int maxSubarrSumK(int[] arr, int sum) {
		//declare window start and window end
		int i = 0;
		int j = 0;
		//declare current window sum
		int cws = 0;
		//declare maxwindowlength
		int maxwinlen = Integer.MIN_VALUE;
		//enter the array with window end
		while(j<arr.length) {
			//calculate the current window sum
			cws += arr[j];
			//check if current window sum is equal to sum
			if(cws == sum) {
				//if it is equal, then find the max window length
				//j-i+1 is the window length
				maxwinlen = Math.max(maxwinlen, j-1+1);
			} else {
				//if its not equal to sum and while it's greater than sum
				while(cws>sum) {
					//shrink the window and slide the window
					cws -= arr[i];
					i++;
					//now after sliding, again check if the cws is equal to sum
					if(cws == sum) {
						//check the max and return
						maxwinlen = Math.max(maxwinlen, j-i+1);
					}
					
				}
			}
			j++;
		}
		return maxwinlen;
		
	}

}
