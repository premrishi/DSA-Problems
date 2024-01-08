package DP;

public class Subset_sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,3,1,2};
		int W = 11;
		int n = arr.length;
		
		System.out.println(ispresent(arr, W, n));
		
		boolean[][] dp = new boolean[n+1][W+1];
		for(int i=0; i<dp.length; i++) {
			for(int j=0; j<dp[0].length; j++) {
				dp[i][j] = false;
			}
		}
		
		System.out.println(ispresentmemo(arr, W, n, dp));
		System.out.println(tabulation(arr, W, n));

	}
	
	//Step 1: Recursive solution
	public static boolean ispresent(int[] arr, int W, int n) {
		//base conditions, 3 scenarios
		if(n == 0 && W == 0) {
			return true;
		}
		
		if(n == 0) {
			return false;
		}
		
		if(W == 0) {
			return true;
		}
		
		if(W>=arr[n-1]) {
			boolean include = ispresent(arr, W-arr[n-1], n-1);
			boolean exclude = ispresent(arr, W, n-1);
			boolean res = include || exclude;
			return res;
		} else {
			boolean exclude = ispresent(arr, W, n-1);
			return exclude;
		}
	}
	
	//Step 2: Memoization
	public static boolean ispresentmemo(int[] arr, int W, int n, boolean[][] dp) {
		//base conditions, 3 scenarios
		if(n == 0 && W == 0) {
			return true;
		}
		
		if(n == 0) {
			return false;
		}
		
		if(W == 0) {
			return true;
		}
		
		if(dp[n][W]!= false) {
			return dp[n][W];
		}
		
		if(W>=arr[n-1]) {
			boolean include = ispresentmemo(arr, W-arr[n-1], n-1, dp);
			boolean exclude = ispresentmemo(arr, W, n-1, dp);
			boolean res = include || exclude;
			dp[n][W] = res;
			return res;
		} else {
			boolean exclude = ispresentmemo(arr, W, n-1, dp);
			dp[n][W] = exclude;
			return exclude;
		}
	}
	
	//Step 3: tabulation
	public static boolean tabulation(int[] arr, int W, int n) {
		//create the dp
		boolean[][] dp = new boolean[n+1][W+1];
		//base condition iteratively
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<W+1; j++) {
				if(i == 0) {
					dp[i][j] = false;
				}
				
				if(j == 0) {
					dp[i][j] = true;
				}
			}
		}
		
		//iterate from 1
		for(int i=1; i<n+1; i++) {
			for(int j = 1; j<W+1; j++) {
				//decision
				if(j>= arr[i-1]) {
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
		return dp[n][W];
		
	}

}
