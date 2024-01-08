package DP;

public class coinChangeMaxWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub'
		int[] coins = {1,2,3};
		int sum = 5;
		int n = coins.length;
		int res = recursive(coins, sum, n);
		System.out.println(res);
		int[][] dp = new int[n+1][sum+1];
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<sum+1; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(memoization(coins, sum, n, dp));
		System.out.println(Tabulation(coins, sum, n));
	}
	
	//Step 1
	public static int recursive(int[] weight, int W, int n) {
		//base condition
		if(n == 0 && W == 0) {
			return 1;
		}
		 if(W == 0) {
			 return 1;
		 }
		 if(n == 0) {
			 return 0;
		 }
		 
		 //take decision
		 if(W>= weight[n-1]) {
			 int include = recursive(weight, W - weight[n-1], n);
			 int exclude = recursive(weight, W, n-1);
			 int ans = include+exclude;
			 return ans;
		 } else {
			 int exclude = recursive(weight, W, n-1);
			 return exclude;
		 }
	}
	
	public static int memoization(int[] weight, int W, int n, int dp[][]) {
		//base condition remains the same
		if(n == 0 && W == 0) {
			return 1;
		}
		if(W == 0) {
			return 1;
		}
		if(n == 0) {
			return 0;
		}
		
		//check for dp and update
		if(dp[n][W]!= -1) {
			return dp[n][W];
		}
		//decision
		if(W>= weight[n-1]) {
			 int include = memoization(weight, W - weight[n-1], n, dp);
			 int exclude = memoization(weight, W, n-1, dp);
			 int ans = include + exclude;
			 dp[n][W] = ans;
			 return ans;
		 } else {
			 int exclude = memoization(weight, W, n-1, dp);
			 dp[n][W] = exclude;
			 return exclude;
		 }
	}
	
	public static int Tabulation(int[] weight, int W, int n) {
		//create dp array
		int[][] dp = new int[n+1][W+1];
		//iterate through the array to fill it for base condition
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<W+1; j++) {
				//base coditioons
				if(i == 0 && j == 0) {
					dp[i][j] = 1;
				}
				if(j == 0) {
					dp[i][j] = 1;
				}
				if(i == 0) {
					dp[i][j] = 0;
				}
			}
		}
		
		//now iterate and take decision
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<W+1; j++) {
				//take decision
				if(j>=weight[i-1]) {
					int include = dp[i][j - weight[i-1]];
					int exclude = dp[i-1][j];
					int ans = include + exclude;
					dp[i][j] = ans;
				} else {
					int exclude = dp[i-1][j];
					dp[i][j] = exclude;
				}
			}
		}
		return dp[n][W];
		
	}

}
