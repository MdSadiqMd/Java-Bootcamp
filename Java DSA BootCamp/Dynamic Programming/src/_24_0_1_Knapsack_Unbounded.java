import java.util.Arrays;
import java.util.concurrent.LinkedBlockingDeque;

public class _24_0_1_Knapsack_Unbounded {
    public static int knapsack(int index,int capacity,int[] wt,int[] val,int[][] dp){
        if(index==0) return (capacity/wt[0])*val[0];
        if(dp[index][capacity]!=-1) return dp[index][capacity];
        int notTake=knapsack(index-1,capacity,wt,val,dp);
        int take= (wt[index]<=capacity) ? val[index]+knapsack(index,capacity-wt[index],wt,val,dp) : 0;
        return dp[index][capacity]=Math.max(notTake,take);
    }
    public static void main(String[] args) {
        int[] wt = {2,4,6};
        int[] val = {5,11,13};
        int capacity = 10;
        int n = wt.length;
        int[][] dp=new int[n][capacity+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(knapsack(n-1,capacity,wt,val,dp));
    }
}
