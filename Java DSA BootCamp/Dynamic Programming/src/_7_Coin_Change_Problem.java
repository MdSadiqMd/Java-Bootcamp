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
    // Bottom - Up Approach --> Tabulation
    public static int countTab(int[] arr, int ind, int T, int[][] dp) {
        if (ind == 0) {
            if (T % arr[0] == 0) return T / arr[0];
            else return (int) Math.pow(10, 9);
        }
        if (dp[ind][T] != -1) return dp[ind][T];
        for (int i = 0; i <= ind; i++) {
            for (int target = 0; target <= T; target++) {
                int notTaken = dp[i][target];
                int taken = (int) Math.pow(10, 9);
                if (arr[ind] <= target) taken = 1 + dp[i][target - arr[ind]];
                dp[ind][T] = Math.min(notTaken, taken);
            }
        }
        return dp[ind][T];
    }
    // Space Optimization
    public static int countSpace(int[] arr, int n, int T) {
        int[] prev = new int[T + 1];
        int[] cur = new int[T + 1];
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0) prev[i] = i / arr[0];
            else prev[i] = (int) Math.pow(10, 9);
        }
        for (int ind = 0; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                int notTake = prev[target];
                int take = (int) Math.pow(10, 9);
                if (arr[ind] <= target) take = 1 + cur[target - arr[ind]];
                cur[target] = Math.min(notTake, take);
            }
            prev = cur.clone();
        }
        int ans = prev[T];
        if (ans >= (int) Math.pow(10, 9)) return -1;
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int T = 7;
        int n = arr.length;
        int[][] dp = new int[n][T + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println(count(arr,n-1,T,dp));
        System.out.println(countTab(arr,n-1,T,dp));
        System.out.println(countSpace(arr,n-1,T));
    }
}
