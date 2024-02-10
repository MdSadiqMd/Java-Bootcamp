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
    public static void main(String[] args) {
        String s1 = "acd";
        String s2 = "ced";
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n][m];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(count(n-1,m-1,s1,s2,dp));
    }
}
