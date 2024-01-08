package DP;

import java.util.Arrays;

public class Fibonaccidp {

	public static void main(String[] args) {
		int n = 12;
		int [] dp = new int[n+1]; 
		Arrays.fill(dp, -1);
		
		System.out.println(fibMemoized(n, dp));
		System.out.println(fibtab(n));
	}
	
	public static int fibMemoized(int n, int[] dp) {
        // Base case: if n is 0 or 1, return n (F(0) = 0, F(1) = 1).
        if (n == 0 || n == 1) {
            return n;
        }

        // If the Fibonacci value for 'n' has already been computed, return it from the 'dp' array.
        if (dp[n] != -1) {
            return dp[n];
        }

        // Recursive calls to compute the (n-1)th and (n-2)th Fibonacci terms.
        int l = fibMemoized(n - 1, dp); // Compute F(n-1)
        int r = fibMemoized(n - 2, dp); // Compute F(n-2)

        // Calculate the nth Fibonacci term by summing the (n-1)th and (n-2)th terms.
        int ans = l + r;

        // Store the computed Fibonacci value for 'n' in the 'dp' array to avoid redundant computations.
        dp[n] = ans;

        // Return the computed Fibonacci value for 'n'.
        return ans;
    }
	
	public static int fibtab(int n) {
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2; i<=n; i++) {
			int l = dp[i-1];
			int r = dp[i-2];
			int ans = l+r;
			dp[i] = ans;
		}
		return dp[n];
	}

}
