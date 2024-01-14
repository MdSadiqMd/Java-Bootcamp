import java.util.Arrays;
// Here we can jump 1 or 2 jumps only and consume the least energy of frog
public class _9_Frog_Jump {
    // Top - Down Approach --> Memoization
    public static int cost(int index,int[] arr,int[] dp){
        if(index==0) return 0;
        if(dp[index]!=-1) return dp[index];
        // Here left and right are the recursion tree branches
        int right=Integer.MAX_VALUE;
        int left=cost(index-1,arr,dp)+Math.abs(arr[index]-arr[index-1]);
        if(index>1){
            right=cost(index-2,arr,dp)+Math.abs(arr[index]-arr[index-2]);
        }
        return dp[index]=Math.min(left,right);
    }
    // Bottom - up Approach --> Tabulation
    public static int costTab(int index,int[] arr,int[] dp){
        if(index==0) return 0;
        if(dp[index]!=-1) return dp[index];
        // Here left and right are the recursion tree branches
        int right=Integer.MAX_VALUE;
        int left=dp[index-1]+Math.abs(arr[index]-arr[index-1]);
        if(index>1){
            right=dp[index-2]+Math.abs(arr[index]-arr[index-2]);
        }
        return dp[index]=Math.min(left,right);
    }
    // Space Optimization
    public static int costSpace(int index,int[] arr,int[] dp){
        if(index==0) return 0;
        int prev1=0;
        int prev2=0;
        for(int i=1;i<index;i++){
            int left=prev1+Math.abs(arr[index]-arr[index-1]);
            int right=Integer.MAX_VALUE;
            if(index>1){
                right=prev2+Math.abs(arr[index]-arr[index-2]);
            }
            int curr=Math.min(left,right);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
    public static void main(String[] args) {
        int[] arr={30,10,60,10,60,50};
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        System.out.println(cost(n-1,arr,dp));
        System.out.println(costTab(n-1,arr,dp));
        System.out.println(costSpace(n-1,arr,dp));
    }
}
