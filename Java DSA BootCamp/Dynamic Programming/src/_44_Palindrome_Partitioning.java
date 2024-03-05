import java.util.Arrays;

public class _44_Palindrome_Partitioning {
    // Palindrome Partitioning II --> https://takeuforward.org/data-structure/palindrome-partitioning-ii-front-partition-dp-53/

    // Top - Down Approach --> Memoization
    public static int count(String str,int ind ,int n,int[] dp){
        if(ind==n) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int cost=Integer.MAX_VALUE;
        for(int i=ind;i<n;i++){
            if(isPalindrome(str,ind,i)){
                cost=Math.min(cost,1+count(str,i+1,n,dp));
            }
        }
        return dp[ind]=cost;
    }
    // Bottom - Up Approach --> Tabulation
    public static int countTab(String str,int ind ,int n,int[] dp){
        if(ind==n) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int cost=Integer.MAX_VALUE;
        for(int i=ind;i<n;i++){
            for(int j=i;j>=0;j--){
                if(isPalindrome(str,ind,i)){
                    cost=Math.min(cost,1+dp[j+1]);
                }
            }
        }
        return dp[ind]=cost;
    }
    public static boolean isPalindrome(String str,int i,int j){
        while(i<j){
            if(str.charAt(i)!=str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "BABABCBADCEDE";
        int n=str.length();
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(count(str,0,n,dp)-1); // "-1" is to remove the last partition at the end
        System.out.println(countTab(str,0,n,dp)-1);
    }
}
