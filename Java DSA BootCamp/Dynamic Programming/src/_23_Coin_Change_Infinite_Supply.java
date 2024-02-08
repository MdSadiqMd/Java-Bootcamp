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
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int T = 4;
        int n = arr.length;
        int[][] dp = new int[n][T + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        System.out.println(count(n-1,T,arr,dp));
    }
}
