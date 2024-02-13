public class _30_Longest_Common_Super_Sequence {
    // Longest Common Super Sequence --> https://takeuforward.org/data-structure/shortest-common-supersequence-dp-31/

    // Bottom - Up Approach --> Tabulation
    public static int count(int n,int m,String s1,String s2){
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][0]=0;
        for(int j=0;j<=m;j++) dp[0][j]=0;
        for(int ind=1;ind<=n;ind++){
            for(int ind1=1;ind1<=m;ind1++){
                if(s1.charAt(ind-1)==s2.charAt(ind1-1)) dp[ind][ind1]=1+dp[ind-1][ind1-1];
                else dp[ind][ind1]=Math.max(dp[ind-1][ind1],dp[ind][ind1-1]);
            }
        }
        return n+m-dp[n][m];
    }
    // Bottom - Up Approach --> Tabulation
    public static String print(int n,int m,String s1,String s2){

    }
    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";
        int n=s1.length();
        int m=s2.length();
        System.out.println(count(n,m,s1,s2));
    }
}
