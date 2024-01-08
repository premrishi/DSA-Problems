package DP;

public class PrintLongestcommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "abcdfh";
		String y = "abcfeh";
		int n = x.length();
		int m = y.length();
		System.out.println(tab(x, y, n, m));

	}
	
	//Step 3: Tabulation
		public static String tab(String x, String y, int n, int m) {
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
			//return dp[n][m];
			int i = n;
	        int j = m;
	        String ans = "";

	        while (i > 0 && j > 0) {
	            if (x.charAt(i-1) == y.charAt(j-1)) {
	                // 1. Store the element in the output string.
	                // 2. Go to the digonal element.


	                //adding it to ans string
	                ans += x.charAt(i-1);
	                //backtracking to the diagonal element
	                i--;
	                j--;
	            } else {

	                // Going to the max out of top and left cell.
	                if (dp[i][j-1] > dp[i-1][j]) {
	                    //left value is greater
	                    j--;
	                } else {
	                    //top value is greater
	                    i--;
	                }
	            }
	        }
	      //reversing the obtained string
	        StringBuffer stringBuffer = new StringBuffer(ans);
	        stringBuffer.reverse();

	        return stringBuffer.toString();
		}

}
