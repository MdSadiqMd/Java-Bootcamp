import java.util.Arrays;

public class _32_Edit_Distance_Insertion_Deletion_Replace_Character {
    // Edit Distance Insertion Deletion and Replace Character --> https://takeuforward.org/data-structure/edit-distance-dp-33/

    // Top - Down Approach --> Memoization
    public static int count(int n,int m,String s1,String s2,int[][] dp){
        if(n<0) return m+1;
        if(m<0) return n+1;
        if(dp[n][m]!=-1) return dp[n][m];
        if(s1.charAt(n)==s2.charAt(m)) return dp[n][m]=count(n-1,m-1,s1,s2,dp);
        else return dp[n][m]=Math.min(1+count(n-1,m-1,s1,s2,dp),Math.min(1+count(n-1,m,s1,s2,dp),1+count(n,m-1,s1,s2,dp)));
    }
    // Bottom - Up Approach --> Tabulation
    public static int countTab(int n,int m,String s1,String s2,int[][] dp){
        if(n<0) return m+1;
        if(m<0) return n+1;
        if(dp[n][m]!=-1) return dp[n][m];
        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) dp[i][j]=dp[i-1][j-1];
                else dp[i][j]=Math.min(1+dp[i-1][j-1],Math.min(1+dp[i-1][j],1+dp[i][j-1]));
            }
        }
        return dp[n][m];
    }
    // Space Optimization
    public static int countSpace(int n,int m,String s1,String s2){
        int[] prev=new int[m+1];
        int[] curr=new int[m+1];
        for (int i = 0; i <= m; i++) prev[i]= i;
        for(int i=1;i<=n;i++){
            curr[0]=i;
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)) curr[j]=prev[j-1];
                else curr[j]=1+Math.min(curr[j-1],Math.min(prev[j-1],prev[j]));
            }
            prev=curr.clone();
        }
        return prev[m];
    }
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println(count(n-1,m-1,s1,s2,dp));
        System.out.println(countTab(n,m,s1,s2,dp));
        System.out.println(countSpace(n,m,s1,s2));
    }
}
