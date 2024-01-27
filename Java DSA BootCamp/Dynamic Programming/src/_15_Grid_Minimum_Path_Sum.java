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
    // Bottom - Up Approach --> Tabulation
    public static int pathTab(int n,int m,int[][] arr,int[][] dp){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0) dp[i][j]=arr[i][j];
                else{
                    int up = arr[i][j];
                    if(i>0) up+=dp[i-1][j];
                    else up+=(int) Math.pow(10, 9);
                    int left=arr[i][j];
                    if(j>0) left+=dp[i][j-1];
                    else left+=(int) Math.pow(10, 9);
                    dp[i][j]=Math.min(up,left);
                }
            }
        }
        return dp[n-1][m-1];
    }
    // Space Optimization
    public static int pathSpace(int n, int m, int[][] arr) {
        int[] prev = new int[m];
        for (int i = 0; i < n; i++) {
            int[] temp = new int[m];
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) temp[j] = arr[i][j];
                else {
                    int up = arr[i][j] + (i > 0 ? prev[j] : (int) Math.pow(10, 9));
                    int left = arr[i][j] + (j > 0 ? temp[j - 1] : (int) Math.pow(10, 9));
                    temp[j] = Math.min(up, left);
                }
            }
            prev = temp.clone();
        }
        return prev[m - 1];
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
        System.out.println(path(n - 1,m - 1,arr,dp));
        System.out.println(pathTab(n,m,arr,dp));
        System.out.println(pathSpace(n,m,arr));
    }
}
