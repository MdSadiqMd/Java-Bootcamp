import java.util.Arrays;

public class _16_Triangle_Grid_Minimum_Path {
    // Minimum path sum in Triangular Grid  --> https://takeuforward.org/data-structure/minimum-path-sum-in-triangular-grid-dp-11

    // Top - Down Approach --> Memoization
    public static int sum(int i,int j,int n,int[][] arr,int[][] dp){
        if(i==n-1) return arr[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int down=arr[i][j]+sum(i+1,j,n,arr,dp);
        int diagonal=arr[i][j]+sum(i+1,j+1,n,arr,dp);
        return dp[i][j]=Math.min(down,diagonal);
    }
    // Bottom - Up Approach --> Tabulation
    public static int sumTab(int i,int j,int n,int[][] arr,int[][] dp){

    }
    public static void main(String[] args) {
        int[][] arr = {{1},
                {2, 3},
                {3, 6, 7},
                {8, 9, 6, 10}};
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println(sum(0,0,n,arr,dp));
    }
}
