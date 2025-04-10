import java.util.Arrays;

public class _24_0_1_Knapsack_Unbounded {
    // 0/1 Knapsack Unbounded --> https://takeuforward.org/data-structure/unbounded-knapsack-dp-23/

    // Top - Down Approach --> Memoization
    public static int knapsack(int index,int capacity,int[] wt,int[] val,int[][] dp){
        if(index==0) return (capacity/wt[0])*val[0];
        if(dp[index][capacity]!=-1) return dp[index][capacity];
        int notTake=knapsack(index-1,capacity,wt,val,dp);
        int take= (wt[index]<=capacity) ? val[index]+knapsack(index,capacity-wt[index],wt,val,dp) : 0;
        return dp[index][capacity]=Math.max(notTake,take);
    }
    // Bottom - Up Approach --> Tabulation
    public static int knapsackTab(int index,int capacity,int[] wt,int[] val,int[][] dp){
        if(index==0) return (capacity/wt[0])*val[0];
        if(dp[index][capacity]!=-1) return dp[index][capacity];
        for(int ind=1;ind<index;ind++){
            for(int T=0;T<=capacity;T++){
                int notTake=dp[ind-1][T];
                int take= (wt[ind]<=T) ? val[ind]+dp[ind][T-wt[ind]] : 0;
                dp[index][capacity]=Math.max(notTake,take);
            }
        }
        return dp[index-1][capacity];
    }
    // Space Optimization
    public static int knapsackSpace(int index,int capacity,int[] wt,int[] val){
        int[] curr=new int[capacity+1];
        for(int i=wt[0];i<=capacity;i++){
            curr[i]=((int)i/wt[0])*val[0];
        }
        for(int ind=1;ind<index;ind++){
            for(int cap=0;cap<=capacity;cap++){
                int notTake=curr[cap];
                int take=0;
                if(wt[ind]<=cap) take=val[ind]+curr[cap-wt[ind]];
                curr[cap]=Math.max(notTake,take);
            }
        }
        return curr[capacity];
    }
    public static void main(String[] args) {
        int[] wt = {2,4,6};
        int[] val = {5,11,13};
        int capacity = 10;
        int n = wt.length;
        int[][] dp=new int[n][capacity+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(knapsack(n-1,capacity,wt,val,dp));
        System.out.println(knapsackTab(n-1,capacity,wt,val,dp));
        System.out.println(knapsackSpace(n-1,capacity,wt,val));
    }
}
