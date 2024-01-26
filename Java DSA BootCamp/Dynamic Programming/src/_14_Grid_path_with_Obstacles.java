import java.util.Arrays;

public class _14_Grid_path_with_Obstacles {
    // Count Grid Path with Obstacles --> https://takeuforward.org/data-structure/grid-unique-paths-2-dp-9/

    // Top - Down Approach
    public static int count(int i,int j,int[][] arr,int[][] dp){
        if(i>=0 && j>=0 && arr[i][j]==-1) return 0;
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=count(i-1,j,arr,dp);
        int left=count(i,j-1,arr,dp);
        return up+left;
    }
    // Bottom - Up Approach
    public static int countTab(int n,int m,int[][] arr,int[][] dp){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i>0 && j>0 && arr[i][j]==0){
                    dp[i][j]=0;
                    continue;
                }
                else if(i==0 && j==0){
                    dp[i][j]=1;
                    continue;
                }
                else{
                    int up=0,down=0;
                    if(i>0) up=dp[i-1][j];
                    if(j>0) down=dp[i][j-1];
                    dp[i][j]=up+down;
                }
            }
        }
        return dp[n-1][m-1];
    }
    // Space Optimization
    public static int countSpace(int n, int m, int[][] arr) {
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            int[] temp = new int[m];
            for (int j = 0; j < m; j++) {
                if (i > 0 && j > 0 && arr[i][j] == -1) {
                    temp[j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }
                int up = 0, left = 0;
                if (i > 0) up = prev[j];
                if (j > 0) left = temp[j - 1];
                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[n - 1];
    }
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}
        };
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp=new int[n][m];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(count(n-1,m-1,arr,dp));
        System.out.println(countTab(n-1,m-1,arr,dp));
        System.out.println(countSpace(n-1,m-1,arr));
    }
}
