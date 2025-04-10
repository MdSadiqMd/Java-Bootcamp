import java.util.Arrays;

public class _35_Buy_and_Sell_Stocks_III {
    // Buy and Sell Stocks with K Transactions --> https://takeuforward.org/data-structure/buy-and-sell-stock-iv-dp-38/ , https://youtu.be/oDhu5uGq_ic?si=8kEF7Dkz5WKNfIgC

    // Top - Down Approach --> Memoization
    public static long profit(int[] arr, int n, int k, long[][] dp) {
        if (n <= 0 || k <= 0) return 0;
        if (dp[n][k] != -1) return dp[n][k];
        long maxProfit = 0;
        for (int i = 1; i <= n; i++) {
            long currentProfit = arr[n] - arr[i - 1] + profit(arr, i - 1, k - 1, dp);
            if (currentProfit > 0) maxProfit = Math.max(maxProfit, currentProfit);
        }
        maxProfit = Math.max(maxProfit, profit(arr, n - 1, k, dp));
        return dp[n][k] = maxProfit;
    }
    // Bottom - Up Approach
    public static long profitTab(int[] arr, int n, int k, long[][] dp) {
        if (n <= 0 || k <= 0) return 0;
        if (dp[n][k] != -1) return dp[n][k];
        long maxProfit = 0;
        for (int i = 1; i <= n; i++) {
            long currentProfit = arr[n] - arr[i - 1] + dp[i - 1][k - 1];
            if (currentProfit > 0) maxProfit = Math.max(maxProfit, currentProfit);
        }
        maxProfit = Math.max(maxProfit, dp[n - 1][k]);
        return dp[n][k] = maxProfit;
    }
    // Space Optimization
    public static int profitSpace(int[] arr, int n, int k) {
        if (n <= 0 || k <= 0) return 0;
        int[] dp = new int[k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = k; j >= 1; j--) {
                int currDiff = arr[i] - arr[i - 1];
                dp[j] = Math.max(dp[j], dp[j - 1] + currDiff);
            }
        }
        return dp[k];
    }
    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 1, 4, 3, 1, 3};
        int n = arr.length;
        int k = 3;
        long[][] dp = new long[n + 1][k + 1];
        for (long[] row : dp) Arrays.fill(row, -1);
        System.out.println(profit(arr, n - 1, k, dp));
        System.out.println(profitTab(arr, n - 1, k, dp));
        System.out.println(profitSpace(arr, n - 1, k));
    }
}
