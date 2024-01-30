import java.util.Arrays;
public class _18_3D_Grid_Cherry_Picking {
    // 3D Grid Problem --> https://takeuforward.org/data-structure/3-d-dp-ninja-and-his-friends-dp-13

    // Top - Down Approach --> Memoization
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
    // Bottom - Up Approach --> Tabulation
    public static int pathTab(int n, int m, int[][] arr, int[][][] dp) {
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2) dp[n - 1][j1][j2] = arr[n - 1][j2];
                else dp[n - 1][j1][j2] = arr[n - 1][j1] + arr[n - 1][j2];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int max = Integer.MIN_VALUE;
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;

                            if (j1 == j2) ans = arr[i][j1];
                            else ans = arr[i][j1] + arr[i][j2];

                            if (j1 + di >= 0 && j1 + di < m && j2 + dj >= 0 && j2 + dj < m) {
                                ans += dp[i + 1][j1 + di][j2 + dj];
                                max = Math.max(max, ans);
                            }
                        }
                    }
                    dp[i][j1][j2] = max;
                }
            }
        }
        return dp[0][0][m - 1];
    }
    // Space Optimization
    public static int pathSpace(int n,int m,int[][] arr){
        int[][] front=new int[m][m];
        int[][] curr=new int[m][m];
        for(int j1=0;j1<m;j1++){
            for(int j2=0;j2<m;j2++){
                if(j1==j2) front[j1][j2]=arr[n-1][j1];
                else front[j1][j2]=arr[n-1][j1]+arr[n-1][j2];
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int max = Integer.MIN_VALUE;
                    for (int di = -1; di <= 1; di++) {
                        for (int dj = -1; dj <= 1; dj++) {
                            int ans;
                            if (j1 == j2) ans = arr[i][j1];
                            else ans = arr[i][j1] + arr[i][j2];
                            if (j1 + di >= 0 && j1 + di < m && j2 + dj >= 0 && j2 + dj < m) {
                                ans +=front[j1+di][j2+dj];
                                max = Math.max(max, ans);
                            }
                        }
                    }
                    curr[j1][j2]=max;
                }
            }
            for(int k=0;k<m;k++){
                front[k]=curr[k].clone();
            }
        }
        return front[0][m-1];
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
        System.out.println(pathTab(n,m,arr,dp));
        System.out.println(pathSpace(n,m,arr));
    }
}
