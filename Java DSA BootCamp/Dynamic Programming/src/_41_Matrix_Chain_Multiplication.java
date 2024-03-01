import java.util.Arrays;

// Steps for Solving Partition DP
// 1. Start with Taking entire Block into Consideration
// 2. Run a Loop and try all Partitions
// 3. Return the Best two Partitions
public class _41_Matrix_Chain_Multiplication {
    // Matrix Chain Multiplication --> https://takeuforward.org/dynamic-programming/matrix-chain-multiplication-dp-48/ , https://takeuforward.org/data-structure/matrix-chain-multiplication-tabulation-method-dp-49/

    // Top - Down Approach --> Memoization
    public static int count(int[] arr,int i,int j,int[][] dp){
        if(i==j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int min=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int steps=(arr[i-1]*arr[k]*arr[j])+count(arr,i,k,dp)+count(arr,k+1,j,dp);
            min=Math.min(min,steps);
        }
        return dp[i][j]=min;
    }
    // Bottom - Up Approach --> Tabulation
    public static int countTab(int[] arr, int n, int[][] dp) {
        for (int i = 1; i <= n; i++) dp[i][i] = 0;
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int steps = (arr[i - 1] * arr[k] * arr[j]) + dp[i][k] + dp[k + 1][j];
                    dp[i][j] = Math.min(dp[i][j], steps);
                }
            }
        }
        return dp[1][n];
    }
    public static void main(String[] args) {
        int[] arr={10, 20, 30, 40, 50};
        int n=arr.length;
        int[][] dp=new int[n+1][n+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(count(arr,1,n-1,dp));
        System.out.println(countTab(arr,n-1,dp));
    }
}
