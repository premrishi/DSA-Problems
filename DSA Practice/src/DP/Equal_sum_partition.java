package DP;

public class Equal_sum_partition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,5,11,5};
		System.out.println(equalpartition(arr));

	}
	
	public static boolean equalpartition(int[] arr) {
		int sum = 0;
		int n = arr.length;
		for(int i=0; i<n; i++) {
			sum+= arr[i];
		}
		if(sum % 2 != 0) {
			return false;
		} else {
			boolean ans = subset(arr, sum/2, n);
			return ans;
		}
	}
	
	public static boolean subset(int[] arr, int sum, int n) {
		//create dp
		boolean[][] dp = new boolean[n+1][sum+1];
		//iteratively place base condition
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<sum+1; j++) {
				if(i == 0) {
					dp[i][j] = false;
				}
				
				if(j == 0) {
					dp[i][j] = true;
				}
			}
		}
		
		//now iterate and take decision
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<sum+1; j++) {
				//take decision
				if(j>=arr[i-1]) {
					boolean include = dp[i-1][j-arr[i-1]];
					boolean exclude = dp[i-1][j];
					boolean res = include || exclude;
					dp[i][j] = res;
				} else {
					boolean exclude = dp[i-1][j];
					dp[i][j] = exclude;
				}
			}
		}
		return dp[n][sum];
	}

}
