package DP;

import java.util.Arrays;

public class MaxSumNonAdj_HouseRob {

	public static void main(String[] args) {
		int [] arr = {9,3,2,1};
		int n = 3;
		System.out.println(Recursive_adj(arr, n));
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		System.out.println(memoized(arr, n, dp));
		System.out.println(tabulation(arr));

	}
	
	//Step 1: Recursive
	public static int Recursive_adj(int[] arr, int n) {
		//base condition
		if(n<0) {
			return 0;
		}
		
		//include number
		int included = Recursive_adj(arr, n-2) + arr[n];
		int excluded = Recursive_adj(arr, n-1);
		int ans = Math.max(included, excluded);
		
		return ans;
	}
	
	//Step 2: Memoization
	public static int memoized(int[] arr, int n, int[] dp) {
		if(n<0) {
			return 0;
		}
		
		if(dp[n]!=-1) {
			return dp[n];
		}
		
		int included = memoized(arr, n-2, dp) + arr[n];
		int excluded = memoized(arr, n-1, dp);
		int ans = Math.max(included, excluded);
		dp[n] = ans;
		return ans;
	}
	
	//Step 3: Tabulation
	public static int tabulation(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		if(arr.length>1) {
			dp[1] = Math.max(arr[0], arr[1]);
		}
		for(int i=2; i<arr.length; i++) {
			int include = dp[i-2] + arr[i];
			int exclude = dp[i-1];
			int ans = Math.max(include, exclude);
			dp[i] = ans;
		}
		return dp[arr.length-1];
	}

}
