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
    public static long profitTab(int index, int n, boolean buy, long[] arr, long[][] dp){
        dp[n][0]=dp[n][1]=0;
        long profit = 0;
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=1;j++){
                if (buy) profit = Math.max(-arr[i] + dp[i+1][1],dp[i+1][0]);
                else profit = Math.max(arr[i] + dp[i+1][0],dp[i+1][1]);
            }
        }
        return dp[index][buy ? 1 : 0] = profit;
    }
    public static void main(String[] args) {
        int n = 6;
        long[] arr = {7, 1, 5, 3, 6, 4};
        long[][] dp = new long[n + 1][2];
        for (long[] row : dp) Arrays.fill(row, -1);
        System.out.println(profit(0, n, true, arr, dp));
        System.out.println(profitTab(0, n, true, arr, dp));
    }
}
