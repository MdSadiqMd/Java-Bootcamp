import java.util.Arrays;

public class _13_Grid_Path {
    // Count all Possible ways

    // Top - Down Approach
    public static int count(int m,int n,int[][] dp){ // Here we are starting from last end point we can also do it from start
        if(m==0 && n==0) return 1; // Exists a path
        if(m<0 || n<0) return 0; // Path not exist
        if(dp[m][n]!=-1) return dp[m][n];
        int up=count(m-1,n,dp);
        int left=count(m,n-1,dp);
        return dp[m][n]=up+left;
    }
    // Bottom - Up Approach
    public static int countTab(int m,int n,int[][] dp){
        if(m==0 && n==0) return 1; // Exists a path
        if(m<0 || n<0) return 0; // Path not exist
        if(dp[m][n]!=-1) return dp[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int up=0;
                int right=0;
                if(i>0) up=dp[i-1][j];
                if(j>0) right=dp[i][j-1];
                dp[i][j]=up+right;
            }
        }
        return dp[m-1][n-1];
    }
    public static void main(String[] args) {
        int m=3,n=2;
        int[][] dp=new int[m][n];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(count(m-1,n-1,dp));
        System.out.println(countTab(m-1,n-1,dp));
    }
}
