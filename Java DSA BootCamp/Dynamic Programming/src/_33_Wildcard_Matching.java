import java.util.Arrays;

public class _33_Wildcard_Matching {
    // Wildcard Matching --> https://takeuforward.org/data-structure/wildcard-matching-dp-34/

    // Bottom - Up Approach --> Memoization
    public static int match(int n, int m, String s1, String s2, int[][] dp) {
        if (n < 0 && m < 0) return 1;
        if (n < 0) return 0;
        if (m < 0) {
            for (int i = 0; i <= n; i++) if (s1.charAt(i) != '*') return 0;
            return 1;
        }
        if (dp[n][m] != -1) return dp[n][m];
        if (s1.charAt(n) == s2.charAt(m) || s1.charAt(n) == '?') return dp[n][m] = match(n - 1, m - 1, s1, s2, dp);
        if (s1.charAt(n) == '*') return dp[n][m] = Math.max(match(n - 1, m, s1, s2, dp), match(n, m - 1, s1, s2, dp));
        return 0;
    }
    // Top - Down Approach --> Tabulation
    public static int matchTab(int n, int m, String s1, String s2, int[][] dp) {
        if (n < 0 && m < 0) return 1;
        if (n < 0) return 0;
        if (m < 0) {
            for (int i = 0; i <= n; i++) if (s1.charAt(i) != '*') return 0;
            return 1;
        }
        if (dp[n][m] != -1) return dp[n][m];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                if (s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?') return dp[i-1][j-1];
                if (s1.charAt(i) == '*') return dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        String s1 = "ab*cd";
        String s2 = "abdefcd";
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println(match(n-1,m-1,s1,s2,dp));
        System.out.println(matchTab(n-1,m-1,s1,s2,dp));
    }
}
