import java.util.Arrays;

public class _34_Buy_and_Sell_Stocks_II {
    // Buy and Sell Stocks II --> https://takeuforward.org/data-structure/buy-and-sell-stock-ii-dp-36/

    // Top - Down Approach --> Memoization
    public static long profit(int index, int n, boolean buy, long[] arr, long[][] dp) {
        if (index == n || n == 0) return 0;
        if (dp[index][buy ? 1 : 0] != -1) return dp[index][buy ? 1 : 0];
        long profit = 0;
        if (buy) profit = Math.max(-arr[index] + profit(index + 1, n, false, arr, dp), profit(index + 1, n, true, arr, dp));
        else profit = Math.max(arr[index] + profit(index + 1, n, true, arr, dp), profit(index + 1, n, false, arr, dp));
        return dp[index][buy ? 1 : 0] = profit;
    }
    // Bottom - Up Approach --> Tabulation
    public static long profitTab(int index, int n, long[] arr, long[][] dp) {
        dp[n][0] = dp[n][1] = 0;
        long profit=0;
        for (int i = n - 1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 1) profit = Math.max(dp[i + 1][0] - arr[i], dp[i + 1][1]);
                if (buy == 0) profit = Math.max(dp[i + 1][0], dp[i + 1][1] + arr[i]);
                else dp[i][buy] = profit;
            }
        }
        return Math.max(dp[index][0], dp[index][1]);
    }
    // Space Optimization
    public static long profitSpace(int n,long[] arr) {
        long[] ahead = new long[2];
        long[] cur = new long[2];
        ahead[0] = ahead[1] = 0;
        long profit = 0;
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) profit = Math.max(ahead[0], -arr[ind] + ahead[1]);
                if (buy == 1) profit = Math.max(ahead[1], arr[ind] + ahead[0]);
                cur[buy] = profit;
            }
            System.arraycopy(cur, 0, ahead, 0, 2);
        }
        return cur[0];
    }
    public static void main(String[] args) {
        int n = 6;
        long[] arr = {7, 1, 5, 3, 6, 4};
        long[][] dp = new long[n + 1][2];
        for (long[] row : dp) Arrays.fill(row, -1);
        System.out.println(profit(0, n, true, arr, dp));
        System.out.println(profitTab(0, n, arr, dp));
        System.out.println(profitSpace(n,arr));
    }
}
