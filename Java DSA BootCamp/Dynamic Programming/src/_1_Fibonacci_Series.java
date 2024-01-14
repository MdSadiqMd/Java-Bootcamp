import java.util.Arrays;

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
