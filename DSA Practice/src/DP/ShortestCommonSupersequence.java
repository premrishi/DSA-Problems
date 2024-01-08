package DP;

public class ShortestCommonSupersequence {
	public static void main(String[] args) {
        String x = "AGGTAB";
        String y = "GXTXAYB";

        /*
        Intuition

        // Common elements between the strings we will write only once.
        // Calculate the LCS of these strings and use it once, and write the remaining letters

         */

        /*
        Add both the string and remove LCS from that string, because LCS will be coming twice

        return n+m+LCS(a,b,n,m)
         */

        int ansShortestCommonSupersequence = shortestCommonSupersequence(x, y, x.length(), y.length());
        System.out.println(ansShortestCommonSupersequence);
    }

    public static int shortestCommonSupersequence(String X, String Y, int n, int m) {
        return n + m - lcsTabulation(X, Y, n, m);
    }



    public static int lcsTabulation(String X, String Y, int n, int m) {
        int[][] dp = new int[n+1][m+1];

        //Step - 1 => initialisation, same as base case of recurive implementation
        for (int i=0; i<n+1; i++) {
            for (int j=0; j<m+1; j++) {
                if (i==0 || j==0) {
                    dp[i][j] = 0;
                }
            }
        }

        //Step - 2, Change recursive calls to iterative implementation
        //keep inside loop and change n -> i, capacity -> j

        for (int i=1; i<n+1; i++) {
            for (int j=1; j<m+1; j++) {
                if (X.charAt(i-1) == Y.charAt(j-1)) {
                    int ansLC = dp[i-1][j-1];
                    int ans = 1 + ansLC;
                    dp[i][j] = ans;
                    //return ans;
                } else {
                    int removeFromFirst = dp[i-1][j];
                    int removeFromSecond = dp[i][j-1];
                    int ans = Math.max(removeFromFirst, removeFromSecond);
                    dp[i][j] = ans;
                    //return ans;
                }
            }
        }

        return dp[n][m];
    }
}
