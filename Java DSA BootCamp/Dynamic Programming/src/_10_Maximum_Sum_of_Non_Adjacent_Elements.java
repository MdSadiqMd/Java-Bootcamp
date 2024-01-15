import java.util.Arrays;

public class _10_Maximum_Sum_of_Non_Adjacent_Elements {
    // Top - Down Approach --> Memoization
    public static int sum(int index,int[] arr,int[] dp){
        if(index==0){
            return arr[0];
        } if(index<0){
            return 0;
        } if(dp[index]!=-1){
            return dp[index];
        }
        // Draw the recursive tree with negative index and do it to understand
        int pick=arr[index]+sum(index-2,arr,dp);
        int notPick= sum(index-1,arr,dp);
        return Math.max(pick,notPick);
    }
    // Bottom - Up Approach --> Tabulation
    public static int sumTab(int index,int[] arr,int[] dp){
        dp[0]=arr[0];
        for(int i=1;i<index;i++){
            int pick=arr[index];
            if(i>1){
                pick+=dp[i-2];
            }
            int notPick=dp[i-1];
            dp[i]=Math.max(pick,notPick);
        }
        return dp[index-1];
    }
    // Space Optimization
    public static int sumSpace(int index,int[] arr,int[] dp){
        dp[0]=arr[0];
        for(int i=1;i<index;i++){
            int pick=arr[index];
            if(i>1){
                pick+=dp[i-2];
            }
            int notPick=dp[i-1];
            dp[i]=Math.max(pick,notPick);
        }
        return dp[index-1];
    }
    public static void main(String[] args) {
        int[] arr={2, 1, 4, 9};
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        System.out.println(sum(n-1,arr,dp));
        System.out.println(sumTab(n-1,arr,dp));
    }
}
