import java.util.Arrays;

public class _27_Longest_Palindromic_Subsequence {
    // Longest Palindromic Subsequence --> https://takeuforward.org/data-structure/longest-palindromic-subsequence-dp-28/

    // Top - Down Approach --> Memoization
    public static int count(int i, int j, String s1, String s2, int[][] dp) {
        if (i == 0 || j == 0) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) return 1 + count(i - 1, j - 1, s1, s2, dp);
        else return Math.max(count(i - 1, j, s1, s2, dp), count(i, j - 1, s1, s2, dp));
    }
    // Bottom - Up Approach --> Tabulation
    public static int countTab(String s1, String s2, int[][] dp) {
        int maxLen = 0;
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return maxLen;
    }
    // Space Optimization
    public static int countSpace(int n,int m,String s1, String s2) {
        int[] prev = new int[n+ 1];
        int[] curr = new int[m + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                    ans = Math.max(ans, curr[j]);
                } else {
                    curr[j] = Math.max(curr[j - 1], prev[j]);
                }
            }
            prev = curr.clone();
            Arrays.fill(curr, 0);
        }
        return ans;
    }
    public static void helper(String s1) {
        String s2 = new StringBuilder(s1).reverse().toString();
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];
        System.out.println(count(n, m, s1, s2, dp));
        System.out.println(countTab(s1, s2, dp));
        System.out.println(countSpace(n,m,s1, s2));
    }
    public static void main(String[] args) {
        String s1 = "bbabcbcab";
        helper(s1);
    }
}
