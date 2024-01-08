package DP;

public class UnboundedKnapsacl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		int W = 6;
		int values[] = {10, 12, 28};
		int weight[] = {1, 2, 4};
		int[][] dp = new int[n+1][W+1];
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<W+1; j++) {
				dp[i][j] = -1;
			}
		}
		
		System.out.println(KS(values, weight, W, n));
		System.out.println(KSmemo(values, weight, W, n, dp));
		System.out.println(KStab(values, weight, W, n));
	}
	
	//Step 1: Recursive
	public static int KS(int[] values, int[] weight, int W, int n) {
		//base condition
		if( n==0 || W == 0) {
			return 0;
		}
		
		//take decision
		if(W>= weight[n-1]) {
			int include = values[n-1] + KS(values, weight, W-weight[n-1], n);
			int exclude = KS(values, weight, W, n-1);
			int ans = Math.max(include, exclude);
			return ans;
		} else {
			int exclude = KS(values, weight, W, n-1);
			return exclude;
		}
	}
	
	//Step 2: Memoization
	public static int KSmemo(int[] values, int[] weight, int W, int n, int[][] dp) {
		//base condition remains same
		if(n == 0 || W == 0) {
			return 0;
		}
		
		if(dp[n][W] != -1) {
			return dp[n][W];
		}
		
		//take decision
		if(W>= weight[n-1]) {
			int include = values[n-1] + KSmemo(values, weight, W - weight[n-1], n, dp);
			int exclude = KSmemo(values, weight, W, n-1, dp);
			int ans = Math.max(include, exclude);
			dp[n][W] = ans;
			return ans;
		} else {
			int exclude = KSmemo(values, weight, W, n-1, dp);
			dp[n][W] = exclude;
			return dp[n][W];
		}
	}
	
	//Step 3: Tabulation
	public static int KStab(int[] values, int[] weight, int W, int n) {
		//create dp array
		int[][] dp = new int[n+1][W+1];
		//iterate and fill with base conditions
		//here n is i and W is j
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<W+1; j++) {
				if(i == 0 || j == 0) {
					dp[i][j] = 0;
				}
			}
		}
		
		//npw iterate from 1 and take decisions
		for(int i=1; i<n+1; i++) {
			for(int j=1; j<W+1; j++) {
				//teake decision
				if(j>=weight[i-1]) {
					int include = values[i-1] + dp[i][j-weight[i-1]];
					int exclude = dp[i-1][j];
					int ans = Math.max(include, exclude);
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
