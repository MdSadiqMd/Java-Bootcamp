class _5_Longest_Subsequence {

    //Top - Down Approach

    // Returns length of LCS for X[0..m-1], Y[0..n-1]
    static int lcs(String X, String Y, int m, int n,
                   int[][] dp)
    {

        if (m == 0 || n == 0)
            return 0;

        if (dp[m][n] != -1)
            return dp[m][n];

        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            dp[m][n] = 1 + lcs(X, Y, m - 1, n - 1, dp);
            return dp[m][n];
        }

        dp[m][n] = Math.max(lcs(X, Y, m, n - 1, dp),
                lcs(X, Y, m - 1, n, dp));
        return dp[m][n];
    }

    // Bottom - Down Approach

    int lcs1(String X, String Y, int m, int n)
    {
        int L[][] = new int[m + 1][n + 1];

        // Following steps build L[m+1][n+1] in bottom up
        // fashion. Note that L[i][j] contains length of LCS
        // of X[0..i-1] and Y[0..j-1]
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }
    // Utility function to get max of 2 integers
    int max(int a, int b) { return (a > b) ? a : b; }

    public static void main(String args[])
    {

        String X = "AGGTAB";
        String Y = "GXTXAYB";

        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("Length of LCS is "
                + lcs(X, Y, m, n, dp));

        _5_Longest_Subsequence LCS=new _5_Longest_Subsequence();
        System.out.println("Length of LCS is "
                + LCS.lcs1(X, Y, m, n));
    }
}

