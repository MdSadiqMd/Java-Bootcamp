import java.util.Arrays;

public class _5_Longest_Common_Subsequence {
    // Longest Common Subsequence --> https://takeuforward.org/data-structure/longest-common-subsequence-dp-25/

    // Top - Down Approach --> Memoization
    public static int count(int n,int m,String s1,String s2,int[][] dp){
        if(n<0 || m<0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        if(s1.charAt(n)==s2.charAt(m)) return dp[n][m]=1+count(n-1,m-1,s1,s2,dp);
        else return dp[n][m]=Math.max(count(n-1,m,s1,s2,dp),count(n,m-1,s1,s2,dp));
    }
    // Bottom - Up Approach --> Tabulation
    public static int countTab(int n,int m,String s1,String s2,int[][] dp){
        if(n<0 || m<0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        for (int i = 0; i <= n; i++) dp[i][0] = 0;
        for (int i = 0; i <= m; i++) dp[0][i] = 0;
        for(int ind=1;ind<=n;ind++){
            for(int ind1=1;ind1<=m;ind1++){
                if(s1.charAt(ind)==s2.charAt(ind1)) dp[ind][ind1]=1+dp[ind-1][ind1-1];
                else dp[ind][ind1]=Math.max(dp[ind-1][ind1],dp[ind][ind1-1]);
            }
        }
        return dp[n][m];
    }
    // Space Optimization
    public static int countSpace(int n,int m,String s1,String s2){
        int[] prev=new int[m+1];
        int[] curr=new int[m+1];
        for(int ind=1;ind<=n;ind++){
            for(int ind1=1;ind1<=m;ind1++){
                if(s1.charAt(ind)==s1.charAt(ind1)) curr[ind1]=1+prev[ind1];
                else curr[ind1]=Math.max(prev[ind1],curr[ind1-1]);
            }
            prev=curr.clone();
        }
        return prev[m];
    }
    public static void main(String[] args) {
        String s1 = "acd";
        String s2 = "ced";
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n][m];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(count(n-1,m-1,s1,s2,dp));
        System.out.println(countTab(n-1,m-1,s1,s2,dp));
        System.out.println(countSpace(n-1,m-1,s1,s2));
    }
}
