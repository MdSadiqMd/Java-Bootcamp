import java.util.Arrays;

public class _46_Count_Number_of_Square {
    // Count Number of Squares --> https://takeuforward.org/data-structure/count-square-submatrices-with-all-1s-dp-on-rectangles-dp-56/

    // Top - Down Approach --> Memoization
    public static int count(int[][] arr,int n,int m,int i,int j,int[][] dp){
        if(i>=n || j>=m || arr[i][j]==0) return 0;
        int right=count(arr,n,m,i,j+1,dp);
        int bottom=count(arr,n,m,i+1,j,dp);
        int bottomRight=count(arr,n,m,i+1,j+1,dp);
        int curr=1;
        int minAdjacent=Math.min(right,Math.min(bottom,bottomRight));
        return dp[i][j]=curr+minAdjacent;
    }
    // Bottom - Up Approach --> Tabulation
    public static void main(String[] args) {
        int[][] arr={{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        int n=3,m=4;
        int[][] dp=new int[n+1][m+1];
        for(int[] row:dp) Arrays.fill(row,0);
        int ans = 0;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                ans+=count(arr,n,m,i,j,dp);
            }
        }
        System.out.println(ans);
    }
}
