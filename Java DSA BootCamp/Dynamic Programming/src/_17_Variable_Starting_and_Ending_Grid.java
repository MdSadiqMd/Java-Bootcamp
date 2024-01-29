import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class _17_Variable_Starting_and_Ending_Grid {
    // Variable Starting and Ending Grid Problem --> https://takeuforward.org/data-structure/minimum-maximum-falling-path-sum-dp-12

    // Top - Down Approach --> Memoization
    public static int path(int i, int j, int m, int[][] arr, int[][] dp) {
        if (j < 0 || j >= m) return (int) Math.pow(-10, 9);
        if (i == 0) return arr[0][j];
        if (dp[i][j] != -1) return dp[i][j];
        int up = arr[i][j] + path(i - 1, j, m, arr, dp);
        int leftDiagonal = arr[i][j] + path(i - 1, j - 1, m, arr, dp);
        int rightDiagonal = arr[i][j] + path(i - 1, j + 1, m, arr, dp);
        return dp[i][j] = Math.max(up, Math.max(leftDiagonal, rightDiagonal));
    }
    // Bottom - Up Approach --> Tabulation
    public static int pathTab(int n,int m,int[][] arr,int[][] dp){
        for(int j=0;j<m-1;j++) dp[0][j]=arr[0][j];
        for(int i=1;i<=n-1;i++){
            for(int j=0;j<=m-1;j++){
                int up=arr[i][j]+dp[i-1][j];
                int leftDiagonal=arr[i][j];
                if(j-1>=0) leftDiagonal+=dp[i-1][j-1];
                else leftDiagonal+=Integer.MIN_VALUE;
                int rightDiagonal=arr[i][j];
                if(j+1<m) rightDiagonal+=dp[i-1][j+1];
                else rightDiagonal+=Integer.MIN_VALUE;
                dp[i][j]=Math.max(up,Math.max(leftDiagonal,rightDiagonal));
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int j=0;j<m;j++){
            ans=Math.max(ans,dp[n-1][j]);
        }
        return ans;
    }
    // Space Optimization
    public static int pathSpace(List<List<Integer>> array) {
        int n = array.size();
        int m = array.get(0).size();
        List<Integer> prev = new ArrayList<>(Collections.nCopies(m, 0));
        List<Integer> cur = new ArrayList<>(Collections.nCopies(m, 0));
        for (int j = 0; j < m; j++) prev.set(j, array.get(0).get(j));
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up = array.get(i).get(j) + prev.get(j);
                int leftDiagonal = array.get(i).get(j);
                if (j - 1 >= 0) leftDiagonal += prev.get(j - 1);
                else leftDiagonal += -1e9;
                int rightDiagonal = array.get(i).get(j);
                if (j + 1 < m) rightDiagonal += prev.get(j + 1);
                else rightDiagonal += -1e9;
                cur.set(j, Math.max(up, Math.max(leftDiagonal, rightDiagonal)));
            }
            prev = new ArrayList<>(cur);
        }
        int ans = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) {
            ans = Math.max(ans, prev.get(j));
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] arr= {{1, 2, 10, 4}, {100, 3, 2, 1}, {1, 1, 20, 2}, {1, 2, 2, 1}};
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        for (int[] row : dp) Arrays.fill(row, -1);
        int ans = Integer.MIN_VALUE;
        for (int j = 0; j < m; j++) ans = Math.max(ans,path(n - 1, j, m, arr, dp));
        System.out.println(ans);
        System.out.println(pathTab(n,m,arr,dp));
        List<List<Integer>> array = new ArrayList<>();
        array.add(Arrays.asList(1, 2, 10, 4));
        array.add(Arrays.asList(100, 3, 2, 1));
        array.add(Arrays.asList(1, 1, 20, 2));
        array.add(Arrays.asList(1, 2, 2, 1));
        System.out.println(pathSpace(array));
    }
}