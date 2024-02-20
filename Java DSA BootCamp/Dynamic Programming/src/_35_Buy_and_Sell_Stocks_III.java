import java.util.Arrays;

public class _35_Buy_and_Sell_Stocks_III {
    // Buy and Sell Stocks III --> https://takeuforward.org/data-structure/buy-and-sell-stock-iii-dp-37/

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
    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 1, 4, 3, 1, 3};
        int n = arr.length;
        int k = 3;
        long[][] dp = new long[n + 1][k + 1];
        for (long[] row : dp) Arrays.fill(row, -1);
        System.out.println(profit(arr, n-1, k, dp));
    }
}
