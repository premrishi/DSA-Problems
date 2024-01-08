package DP;

public class coinsMinimumcoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1,2,3};
		int n = coins.length;
		int sum = 5;
		System.out.println(name(coins, sum, n));
		int[][] dp = new int[n+1][sum+1];
		for(int i=0; i<n+1; i++) {
			for(int j = 0; j<sum+1; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(memoization(coins, sum, n, dp));
		System.out.println(tabulation(coins, sum, n));
	}
	
	//Step 1: Recursive
	public static int name(int[] weight, int W, int n) {
		//base condition
		if(W == 0) {
			return 0;
		}
		
		if(n == 0) {
			return Integer.MAX_VALUE;
		}
		
		//TAKE DECISION
		if(W>=weight[n-1]) {
			int include = 1 + name(weight, W-weight[n-1], n);
			int exclude = name(weight, W, n-1);
			int ans = Math.min(include, exclude);
			return ans;
		} else {
			int exclude = name(weight, W, n-1);
			return exclude;
		}
	}
	
	public static int memoization(int[] weight, int W, int n, int[][] dp) {
		//iterate and add base comditions
		if(W == 0) {
			return 0;
		}
		
		if(n == 0) {
			return Integer.MAX_VALUE;
		}
		
		if(dp[n][W]!=-1) {
			return dp[n][W];
		}
		
		if(W>=weight[n-1]) {
			int include = 1 + memoization(weight, W-weight[n-1], n, dp);
			int exclude = memoization(weight, W, n-1, dp);
			int ans = Math.min(include, exclude);
			dp[n][W] = ans;
			return ans;
		} else {
			int exclude = memoization(weight, W, n-1, dp);
			dp[n][W] = exclude;
			return exclude;
		}
		
	}
	
	public static int tabulation(int[] weight, int W, int n) {
		//create dp
		int[][] dp = new int[n+1][W+1];
		//iterate through the dp and enter the base comdition
		for(int i = 0; i<n+1; i++) {
			for(int j = 0; j<W+1; j++) {
				//base condition
				if(j == 0) {
					dp[i][j] = 0;
				}
				if(i == 0) {
					dp[i][j] = Integer.MAX_VALUE -1;
				}
			}
		}
		
		//iterate and decide
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<W+1; j++) {
				//decide
				if(j>=weight[i-1]) {
					int include = 1 + dp[i][j - weight[i-1]];
					int exclude = dp[i-1][j];
					int ans = Math.min(include, exclude);
					dp[i][j] = ans;
				} else {
					int exclude = dp[i-1][j];
					dp[i][j] = exclude;
				}
			}
		}
		
		if(dp[n][W] == Integer.MAX_VALUE -1) {
			return -1;
		} else {
			return dp[n][W];
		}
		
	}

}
