import java.util.Arrays;

public class _13_Grid_Path {
    // Count all Possible ways --> https://takeuforward.org/data-structure/grid-unique-paths-dp-on-grids-dp8/

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
    // Space optimization
    public static int countSpace(int m,int n){ // *** Here we take a dummy 1-D array with the size of a row and storing the previous row values in it and swapping with next previous row when the computation is done this brings Space complexity to O(m)
        int[] prev=new int[n];
        for(int i=0;i<m;i++){
            int[] cur =new int[n];
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    cur[j]=1;
                    continue;
                }
                int up=0,left=0;
                if(i>0) up=prev[j];
                if(j>0) left= cur[j-1];
                cur[j]=up+left;
            }
            prev= cur;
        }
        return prev[n-1];
    }
    public static void main(String[] args) {
        int m=3,n=2;
        int[][] dp=new int[m][n];
        for(int[] row:dp) Arrays.fill(row,-1);

        // Count all Possible paths
        System.out.println(count(m-1,n-1,dp));
        System.out.println(countTab(m-1,n-1,dp));
        System.out.println(countSpace(m-1,n-1));
    }
}
