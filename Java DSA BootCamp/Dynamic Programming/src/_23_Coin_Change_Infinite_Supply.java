import java.util.Arrays;

public class _23_Coin_Change_Infinite_Supply {
    // Coin Change With Infinite Supply of Coins --> https://takeuforward.org/data-structure/coin-change-2-dp-22/

    // Top - Down Approach --> Memoization
    public static int count(int index,int target,int[] arr,int[][] dp){
        if(index==0){
            if(target%arr[0]==0) return 1;
            else return 0;
        }
        if(dp[index][target]!=-1) return dp[index][target];
        int notTake=count(index-1,target,arr,dp);
        int take=0;
        if(arr[index]<=target) take=count(index,target-arr[index],arr,dp);
        return dp[index][target]=notTake+take;
    }
    // Bottom - Up Approach --> Tabulation
    public static int countTab(int index,int target,int[] arr,int[][] dp){
        if(index==0){
            if(target%arr[0]==0) return 1;
            else return 0;
        }
        if(dp[index][target]!=-1) return dp[index][target];
        for(int i=0;i<=index;i++){
            for(int T=1;T<target;T++){
                int notTake=dp[i-1][T];
                int take=0;
                if(arr[i]<=T) take=dp[i][T-arr[i]];
                dp[i][T]=notTake+take;
            }
        }
        return dp[index-1][target];
    }
    // Space Optimization
    public static int countSpace(int index,int target,int[] arr){
        int[] prev=new int[target+1];
        for(int i=0;i<=target;i++){
            if(i%arr[0]==0) prev[i]=1;
        }
        for(int i=1;i<index;i++){
            int[] curr=new int[target+1];
            for(int T=0;T<=target;T++){
                int notTake=prev[T];
                int take=0;
                if(arr[i]<=T) take=curr[T-arr[i]];
                curr[T]=notTake+take;
            }
            prev=curr;
        }
        return prev[target];
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int T = 4;
        int n = arr.length;
        int[][] dp = new int[n][T + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println(count(n-1,T,arr,dp));
        System.out.println(countTab(n-1,T,arr,dp));
        System.out.println(countSpace(n,T,arr));
    }
}
