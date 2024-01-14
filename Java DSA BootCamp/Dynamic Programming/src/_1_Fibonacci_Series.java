import java.util.Arrays;
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
public class _1_Fibonacci_Series {
    // Top - Down Approach --> Memoization --> Time and Space Complexity --> O(N)
    public static int fibonacci(int n,int[] dp){
        if(n==0 || n==1){
            return n;
        } else if (dp[n]!=-1) {
            return dp[n];
        } else {
            return fibonacci(n-1,dp)+fibonacci(n-2,dp);
        }
    }
    public static void main(String[] args) {
        int n=7;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println("Top - Down Approach --> Memoization "+fibonacci(n,dp));

        // Bottom - Up Approach --> Tabulation --> Here we already hard-code the base case condition and reduce the base case condition computation time --> Time and Space Complexity --> O(N)
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        System.out.println("Bottom - Up Approach --> Tabulation "+dp[n]);

        // Space Optimization --> If we see we only need the value of prev two and for the next the prev two will be updated
        int prev2=0;
        int prev1=1;
        for(int i=2;i<=n;i++){
            int curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        System.out.println("Space Optimization Approach "+prev1);

    }
}
