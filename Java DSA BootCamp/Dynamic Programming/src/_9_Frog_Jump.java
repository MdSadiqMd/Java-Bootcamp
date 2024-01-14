/*
If the Question is given like to find the no.of ways ,min way,max way,best way,.... you possibly use recursion and to write recursion we need to write recurrence relation
To write recurrence relation follow the below steps
1. Try to represent the problem in terms of index
2. write all the test cases possible or the series of test cases possible
3. compress result according to the problem , if it asks to count then count, if it asks to find min element then find the min element,...
Now after finding the recurrence relation, and we write the code using recursion it may run or return time limit exceeded error. So, now let's apply DP
1. Top - Down Approach --> Memoization --> Here we take an array of the size of the output needed and try to store the values in that array that required for computation, Here the time complexity will be decreased but the space complexity *** might remain same
2. Bottom - Up Approach --> Tabulation --> Here we replace the recursion part and try to replace it with index based which we memoized before, Here it will decrease the recursion stack space that took in before Approach
3. Space Optimization --> Here we take the advantage that we don't need to store the whole array we just need to store few set of previous computed values, and we just store them for computation and garbage collector will clean it after computation, this approach reduces the space complexity by large extent this also has some limitations so see the countKSpace Method in Frog Jump problem
 */
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
    // Top - Down Approach --> Memoization
    public static int costK(int index,int k,int[] arr,int[] dp){
        if(arr.length==0) return 0;
        if(dp[index]!=0) return dp[index];
        int right=Integer.MAX_VALUE;
        int left=costK(index-1,k,arr,dp)+Math.abs(arr[index]-arr[index-1]);
        for(int j=1;j<=k;j++){
            if(index-j>1) { // for tackling negative index
                right = costK(index - j, k, arr, dp) + Math.abs(arr[index] - arr[index - j]);
            }
        }
        return dp[index]=Math.min(left,right);
    }
    // Bottom - Up Approach --> Tabulation
    public static int costKTab(int index,int k,int[] arr,int[] dp){
        if(arr.length==0) return 0;
        if(dp[index]!=-1) return dp[index];
        int right=Integer.MAX_VALUE;
        int left=dp[index-1]+Math.abs(arr[index]-arr[index-1]);
        for(int j=1;j<=k;j++){
            right=dp[index-j]+Math.abs(arr[index]-arr[index-j]);
        }
        return dp[index]=Math.min(left,right);
    }
    // Space Optimization
    public static int costKSpace(int index,int k,int[] arr,int[] dp){
        if(arr.length==0) return 0;
        if(dp[index]!=-1) return dp[index];
        int prev1=0;
        int prev2=0;
        int left=prev1+Math.abs(arr[index]-arr[index-1]);
        int right=Integer.MAX_VALUE;
        for(int j=1;j<=k;j++){
            if(right>1){
                right=prev2+Math.abs(arr[index]-arr[index-j]);
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

        // If Given K number of Jumps
        int k=3;
        System.out.println(costK(n-1,k,arr,dp));
        System.out.println(costKTab(n-1,k,arr,dp));
        System.out.println(costKSpace(n-1,k,arr,dp)); // *** Here it won't Optimise the space as if in the worst case k=N and the space complexity will be O(N)
    }
}
