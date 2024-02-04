import java.util.Arrays;

public class _4_0_1_Knapsack {
    // 0/1 Knapsack --> https://takeuforward.org/data-structure/0-1-knapsack-dp-19/

    // Top - Down Approach --> Memoization
    public static int knapsack(int capacity,int index,int[] wt,int[] val,int[][] dp){
        if(index==0) return  (wt[0]<=capacity) ? val[0] : 0;
        if(dp[index][capacity]!=-1) return dp[index][capacity];
        int notTake = knapsack(capacity, index - 1, wt, val, dp);
        int take = (wt[index] <= capacity) ? val[index] + knapsack(capacity - wt[index], index - 1, wt, val, dp) : 0;
        return dp[index][capacity]=Math.max(notTake,take);
    }
    // Bottom - Up Approach --> Tabulation
    public static int knapsackTab(int capacity,int index,int[] wt,int[] val,int[][] dp){
        if(index==0) return  (wt[0]<=capacity) ? val[0] : 0;
        if(dp[index][capacity]!=-1) return dp[index][capacity];
        int notTake=dp[index-1][capacity];
        int take=(wt[0]<=capacity) ? val[index]+dp[index-1][capacity-wt[index]] :0;
        return dp[index][capacity]=Math.max(notTake,take);
    }
    // Space Optimization
    public static int knapsackSpace(int capacity, int index, int[] wt, int[] val) {
        int[] prev = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) prev[i] = (wt[0] <= i) ? val[0] : 0;
        for (int i = 1; i < index; i++) {
            for (int cap = capacity; cap >= 0; cap--) {
                int notTaken = prev[cap];
                int taken = (wt[i] <= cap) ? val[i] + prev[cap - wt[i]] : 0;
                prev[cap] = Math.max(notTaken, taken);
            }
        }
        return prev[capacity];
    }
    public static void main(String[] args) {
        int[] wt = {1, 2, 4, 5};
        int[] val = {5, 4, 8, 6};
        int capacity = 5;
        int n = wt.length;
        int[][] dp=new int[n][capacity+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(knapsack(capacity,n-1,wt,val,dp));
        System.out.println(knapsackTab(capacity,n-1,wt,val,dp));
        System.out.println(knapsackSpace(capacity,n-1,wt,val));
    }
}
