package DP;

import java.util.Arrays;

//Step 1: Write the normal Recursive solution
//Step 2: Convert it into Memoization
//Step 3: Convert it into tabulation
public class ClimbingStairs {

	public static void main(String[] args) {
		//number of stairs
		int n = 5;
		//dp array
		int[] dp = new int[n+1];
		Arrays.fill(dp, -1);
		System.out.println(recursive_num_ways(n));
		System.out.println(memoized(n, dp));
		System.out.println(Tabulation(n, dp));
		System.out.println(spaceoptimized(n));

	}
	//Step 1: Recursive solution
	public static int recursive_num_ways(int n) {
		//base condition
		if(n == 0 || n == 1) {
			return 1;
		}
		int l = recursive_num_ways(n-1);
		int r = recursive_num_ways(n-2);
		int ans = l+r;
		return ans;
	}
	
	//Step 2: Memoized
	public static int memoized(int n, int[] dp) {
		//base condition remains the same
		if(n == 0 || n == 1) {
			return 1;
		}
		//check if the dp array has the calculate value, if so retrurn it
		if(dp[n]!=-1) {
			return dp[n];
		}
		
		int l = memoized(n-1, dp);
		int r = memoized(n-2, dp);
		int ans = l+r;
		dp[n] = ans;
		return ans;
	}
	
	//Step 3: Tabulation
	public static int Tabulation(int n, int[] dp) {
		dp[0] = 1;
		dp[1] = 1;
		//now iterate the dp array from 2
		for(int i=2; i<=n; i++) {
			int l = dp[i-1];
			int r = dp[i-2];
			int ans = l+r;
			dp[i] = ans;
		}
		return dp[n];
	}
	
	//more space optimized
	public static int spaceoptimized(int n) {
		int first = 1;
		int second = 1;
		
		for(int i=2; i<=n; i++) {
			int temp = first+second;
			first = second;
			second = temp;
		}
		return second;
	}

}
