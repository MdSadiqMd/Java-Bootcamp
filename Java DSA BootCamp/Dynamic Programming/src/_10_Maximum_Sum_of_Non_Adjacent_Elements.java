import java.util.Arrays;
// Definitely draw recursion tree
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
    public static int sumSpace(int index,int[] arr){
        int prev1=arr[0];
        int prev2=0;
        for(int i=1;i<index;i++){
            int pick=arr[index]+prev2;
            int notPick=prev1;
            int curr=Math.max(pick,notPick);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
    public static void main(String[] args) {
        int[] arr={2, 1, 4, 9};
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        System.out.println(sum(n-1,arr,dp));
        System.out.println(sumTab(n-1,arr,dp));
        System.out.println(sumSpace(n-1,arr));
    }
}
