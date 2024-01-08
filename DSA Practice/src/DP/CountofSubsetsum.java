package DP;

public class CountofSubsetsum {

	public static void main(String[] args) {
		int[] arr = {1,5,11,5, 10};
		System.out.println(tabulation(arr, 10, arr.length));

	}
	
	public static int tabulation(int[] arr, int W, int n) {
		//create the dp
		int [][] dp = new int[n+1][W+1];
		//base condition iteratively
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<W+1; j++) {
				if(i == 0) {
					dp[i][j] = 0;
				}
				
				if(j == 0) {
					dp[i][j] = 1;
				}
			}
		}
		
		//iterate from 1
		for(int i=1; i<n+1; i++) {
			for(int j = 1; j<W+1; j++) {
				//decision
				if(j>= arr[i-1]) {
					int include = dp[i-1][j-arr[i-1]];
					int exclude = dp[i-1][j];
					int res = include + exclude;
					dp[i][j] = res;
				} else {
					int exclude = dp[i-1][j];
					dp[i][j] = exclude;
				}
			}
		}
		return dp[n][W];
		
	}

}
