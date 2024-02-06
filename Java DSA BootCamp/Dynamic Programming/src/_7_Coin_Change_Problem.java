import java.util.Arrays;

public class _7_Coin_Change_Problem {
    // Coin Change Problem ( Minimum Coins ) --> https://takeuforward.org/data-structure/minimum-coins-dp-20/

    // Top - Down Approach --> Memoization
    static int count(int[] arr, int ind, int T, int[][] dp) {
        if (ind == 0) {
            if (T % arr[0] == 0) return T / arr[0];
            else return (int) Math.pow(10, 9);
        }
        if (dp[ind][T] != -1) return dp[ind][T];
        int notTaken =count(arr, ind - 1, T, dp);
        int taken = (int) Math.pow(10, 9);
        if (arr[ind] <= T) taken = 1 + count(arr, ind, T - arr[ind], dp);
        return dp[ind][T] = Math.min(notTaken, taken);
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int T = 7;
        int n = arr.length;
        int[][] dp = new int[n][T + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println(count(arr,n-1,T,dp));
    }
}
