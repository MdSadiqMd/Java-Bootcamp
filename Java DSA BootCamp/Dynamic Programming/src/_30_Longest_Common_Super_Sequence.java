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
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++) dp[i][0]=0;
        for(int j=0;j<=m;j++) dp[0][j]=0;
        for(int ind=1;ind<=n;ind++){
            for(int ind1=1;ind1<=m;ind1++){
                if(s1.charAt(ind-1)==s2.charAt(ind1-1)) dp[ind][ind1]=1+dp[ind-1][ind1-1];
                else dp[ind][ind1]=Math.max(dp[ind-1][ind1],dp[ind][ind1-1]);
            }
        }
        int i=n,j=m;
        StringBuilder ans= new StringBuilder(" ");
        while(i>0 && j>0){
            if(s1.charAt(i-1)==s2.charAt(j-1)){
                ans.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if(dp[i-1][j]>dp[i][j-1]){
                ans.append(s1.charAt(i - 1));
                i--;
            } else{
                ans.append(s2.charAt(j - 1));
                j--;
            }
        }
        while(i>0) {
            ans.append(s1.charAt(i - 1));
            i--;
        }
        while(j>0) {
            ans.append(s2.charAt(j - 1));
            j--;
        }
        return ans.reverse().toString();
    }
    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";
        int n=s1.length();
        int m=s2.length();
        System.out.println(count(n,m,s1,s2));
        System.out.println(print(n,m,s1,s2));
    }
}
