import java.util.Arrays;

public class _31_Distinct_SubSequence {
    // Distinct SubSequence --> https://takeuforward.org/data-structure/distinct-subsequences-dp-32/

    // Top - Down Approach --> Memoization
    public static int count(int n,int m,String s1,String s2,int[][] dp){
        if(m<0) return 1;
        if(n<0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        if(s1.charAt(n)==s2.charAt(m)){
            int take=count(n-1,m-1,s1,s2,dp);
            int notTake=count(n-1,m,s1,s2,dp);
            return dp[n][m]=take+notTake;
        } else{
            return dp[n][m]=count(n-1,m,s1,s2,dp);
        }
    }
    // Bottom - Up Approach --> Tabulation
    public static int countTab(int n,int m,String s1,String s2,int[][] dp){
        if(m<0) return 1;
        if(n<0) return 0;
        for(int i=0;i<=n+1;i++) dp[i][0]=0;
        for(int j=0;j<=m+1;j++) dp[0][j]=0;
        for(int i=1;i<=n+1;i++){
            for(int j=0;j<=m+1;j++){
                if(s1.charAt(n)==s2.charAt(m)) dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][m];
    }
    // Space Optimization
    public static int countSpace(int n, int m, String s1, String s2) {
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];
        Arrays.fill(prev, 0);
        Arrays.fill(curr, 0);
        prev[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) curr[j] = prev[j - 1] + prev[j];
                else curr[j] = prev[j];
            }
            System.arraycopy(curr, 0, prev, 0, m + 1);
        }
        return prev[m];
    }
    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n][m];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(count(n-1,m-1,s1,s2,dp));
        System.out.println(count(n-1,m-1,s1,s2,dp));
        System.out.println(countSpace(n-1,m-1,s1,s2));
    }
}
