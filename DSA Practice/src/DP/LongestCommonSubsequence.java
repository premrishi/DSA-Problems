package DP;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "abcd";
		String y = "abc";
		int n = x.length();
		int m = y.length();
		System.out.println(recursive(x, y, n, m));
		int[][] dp = new int[n+1][m+1];
		for(int i=0; i<n+1; i++) {
			for(int j=0; j<m+1; j++) {
				dp[i][j] = -1;			
			}
		}
		System.out.println(memo(x, y, n, m, dp));
		System.out.println(tab(x, y, n, m));
	}
	
	//Step 1 recursive
	public static int recursive(String x, String y, int n, int m) {
		//base comdition
		if(n == 0 || m == 0) {
			return 0;
		}
		
		//take decison
		if(x.charAt(n-1) == y.charAt(m-1)) {
			int ans = 1 + recursive(x, y, n-1, m-1);
			return ans;
		} else {
			int removefirst = recursive(x, y, n-1, m);
			int removesecond = recursive(x, y, n, m-1);
			int ans = Math.max(removefirst, removesecond);
			return ans;
		}
	}
	
	//Step 2: Memoization
	public static int memo(String x, String y, int n, int m, int[][] dp) {
		//base comdition
				if(n == 0 || m == 0) {
					return 0;
				}
				
				if(dp[n][m] != -1) {
					return dp[n][m];
				}
				
				//take decison
				if(x.charAt(n-1) == y.charAt(m-1)) {
					int ans = 1 + memo(x, y, n-1, m-1, dp);
					dp[n][m] = ans;
					return ans;
				} else {
					int removefirst = memo(x, y, n-1, m, dp);
					int removesecond = memo(x, y, n, m-1, dp);
					int ans = Math.max(removefirst, removesecond);
					dp[n][m] = ans;
					return ans;
				}
	}
	
	//Step 3: Tabulation
	public static int tab(String x, String y, int n, int m) {
		//create dp
		int[][] dp = new int[n+1][m+1];
		//fill the dp with base comdition
		for(int i=0; i<n+1; i++) {
			for(int j=0; j>m+1; j++) {
				if(i == 0 || j == 0) {
					dp[i][j] = 0;
				}
			}
		}
		
		//iterate from 1 
		for(int i=1; i<n+1; i++) {
			for(int j = 1; j<m+1; j++) {
				if(x.charAt(i-1) == y.charAt(j-1)){
					int ans = 1 + dp[i-1][j-1];
					dp[i][j] = ans;
				} else {
					int removefst = dp[i-1][j];
					int removescnd = dp[i][j-1];
					int ans = Math.max(removefst, removescnd);
					dp[i][j] = ans;
				}
			}
		}
		return dp[n][m];
	}

}
