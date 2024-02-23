import java.util.Arrays;

public class _36_Buy_and_Sell_Stocks_IV {
    // Buy and sell stocks with Cool Down --> https://takeuforward.org/data-structure/buy-and-sell-stocks-with-cooldown-dp-39/

    // Top - Down Approach --> Memoization
    public static long profit(int[] arr,int ind,int buy,int n,long[][] dp){
        if(ind>=n) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        long profit=0;
        if(buy==0) profit=Math.max(profit(arr,ind+1,0,n,dp), -arr[ind]+profit(arr,ind+1,1,n,dp));
        if(buy==1) profit=Math.max(profit(arr,ind+1,1,n,dp), arr[ind]+profit(arr,ind+2,0,n,dp));
        dp[ind][buy]=profit;
        return profit;
    }
    // Bottom - Up Approach --> Tabulation
    public static long profitTab(int[] arr, int n, long[][] dp) {
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) dp[ind][buy] = Math.max(dp[ind + 1][0], -arr[ind] + dp[ind + 1][1]);
                if (buy == 1) {
                    if (ind + 2 < n) dp[ind][buy] = Math.max(dp[ind + 1][1], arr[ind] + dp[ind + 2][0]);
                     else dp[ind][buy] = arr[ind];
                }
            }
        }
        return dp[0][0];
    }
    // Space Optimization
    public static int profitSpace(int[] arr){
        int n = arr.length;
        int[] cur = new int[2];
        int[] front1 = new int[2];
        int[] front2 = new int[2];
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 0) profit = Math.max(front1[0], -arr[ind] + front1[1]);
                if (buy == 1) profit = Math.max(front1[1], arr[ind] + front2[0]);
                cur[buy] = profit;
            }
            System.arraycopy(front1, 0, front2, 0, 2);
            System.arraycopy(cur, 0, front1, 0, 2);
        }
        return cur[0];
    }
    public static void main(String[] args) {
        int[] arr = {4, 9, 0, 4, 10};
        int n = arr.length;
        long[][] dp = new long[n + 1][2];
        for (long[] row : dp) Arrays.fill(row, -1);
        System.out.println(profit(arr,0,0, n, dp));
        System.out.println(profitTab(arr,n,dp));
        System.out.println(profitSpace(arr));
    }
}