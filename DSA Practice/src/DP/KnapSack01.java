package DP;

public class KnapSack01 {

	public static void main(String[] args) {
		int n = 3;
		int W = 4;
		int values[] = {1,2,3};
		int weight[] = {4,5,1};
		
		int ans = knapSack(weight, values, W, n);
		System.out.println(ans);
		int[][] dp  =new int[n+2][W+1];
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		System.out.println(ks(weight, values, W, n, dp));
		System.out.println(kstab(weight, values, W, n));
	}
	
	//Step 1: Recursive solution
	public static int knapSack(int[] weight, int[] values, int W, int n) {
		//base condition
		//either the array can be empty or the sack capacity can be empty
		if(n == 0 || W == 0) {
			return 0;
		}
		
		//take the decision, euther to include or exclude
		//if the weight is less than W, do solething, else do something
		if(weight[n-1]<= W) {
			//now include and exclude
			int include = values[n-1] + knapSack(weight, values, W - weight[n-1], n-1);
			int exclude = knapSack(weight, values, W, n-1);
			int res = Math.max(include, exclude);
			return res;
		} else {
			int exclude = knapSack(weight, values, W, n-1);
			return exclude;
		}
	}
	
	//Step 2: Convert it into memoization by introducing dp
	public static int ks(int[] weight, int[] values, int W, int n, int[][] dp) {
		//base condition
		//either the array can be empty or the sack capacity can be empty
		if(n == 0 || W == 0) {
			return 0;
		}
		
		if(dp[n][W]!=-1) {
			return dp[n][W];
		}
		
		//take the decision, euther to include or exclude
		//if the weight is less than W, do solething, else do something
		if(weight[n-1]<= W) {
			//now include and exclude
			int include = values[n-1] + ks(weight, values, W - weight[n-1], n-1, dp);
			int exclude = ks(weight, values, W, n-1, dp);
			int res = Math.max(include, exclude);
			dp[n][W] = res;
			return res;
		} else {
			int exclude = ks(weight, values, W, n-1, dp);
			return exclude;
		}
	}
	
	//Tabulation
	public static int kstab(int[] weight, int[] values, int W, int n) {
		//in tabulation, "n" becomes "i" and "W" becomes "j".
		int[][] dp = new int[n+1][W+1];
		//base condition
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<W+1; j++) {
				if(i == 0 || j == 0) {
					dp[i][j] = 0;
				}
			}
		}
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<W+1; j++) {
				if(weight[i-1]<= j) {
					int include = values[i-1] + dp[i-1][j - weight[i-1]];
					int exclude = dp[i-1][j];
					int res = Math.max(include, exclude);
					dp[i][j] = res;
				} else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][W];
	}

}
