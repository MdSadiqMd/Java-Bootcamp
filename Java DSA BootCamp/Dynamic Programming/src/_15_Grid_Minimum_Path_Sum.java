import java.util.Arrays;
public class _15_Grid_Minimum_Path_Sum {
    // Minimum Path Sum in a Grid --> https://takeuforward.org/data-structure/minimum-path-sum-in-a-grid-dp-10/

    // Top - Down Approach --> Memoization
    public static int path(int i, int j, int[][] arr, int[][] dp) {
        if (i == 0 && j == 0) return arr[0][0];
        if (i < 0 || j < 0) return (int) Math.pow(10, 9);
        if (dp[i][j] != -1) return dp[i][j];
        int up = arr[i][j] + path(i - 1, j, arr, dp);
        int left = arr[i][j] + path(i, j - 1, arr, dp);
        return dp[i][j] = Math.min(up, left);
    }
    public static void main(String[] args) {
        int[][] arr= {
                {5, 9, 6},
                {11, 5, 2}
        };
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println(path(n - 1, m - 1, arr, dp));
    }
}
