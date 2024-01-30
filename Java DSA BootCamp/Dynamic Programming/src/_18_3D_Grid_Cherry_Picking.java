import java.util.Arrays;
public class _18_3D_Grid_Cherry_Picking {
    // 3D Grid Problem --> https://takeuforward.org/data-structure/3-d-dp-ninja-and-his-friends-dp-13
    public static int path(int i,int j1,int j2,int n,int m,int[][] arr,int[][][] dp){
        if(j1<0 || j1>m-1 || j2<0 || j2>m-1) return Integer.MAX_VALUE;
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        if(i==n-1){
            if(j1==j2) return arr[i][j1];
            else return arr[i][j1]+arr[i][j2];
        }
        int ans=0,max=0;
        for(int di=-1;di<=+1;di++){ // [-1,0,+1] --> all possible paths of column change as row is same for both
            for(int dj=-1;dj<=+1;dj++){
                if(j1==j2) ans=arr[i][j1]+path(i+1,j1+di,j2+dj,n,m,arr,dp);
                else ans=arr[i][j1]+arr[i][j2]+path(i+1,j1+di,j2+dj,n,m,arr,dp);
                max=Math.max(ans,max);
            }
        }
        return dp[i][j1][j2]=max;
    }
    public static void main(String[] args) {
        int[][] arr = {{2, 3, 1, 2}, {3, 4, 2, 2}, {5, 6, 3, 5}};
        int n = arr.length;
        int m = arr[0].length;
        int[][][] dp = new int[n][m][m];
        for (int[][] row1 : dp) {
            for (int[] row2 : row1) {
                Arrays.fill(row2, -1);
            }
        }
        System.out.println(path(0,0,m-1,n,m,arr,dp));
    }
}
