import java.util.Arrays;

public class _25_Rod_Cutting_Problem {
    // Rod - Cutting problem --> https://takeuforward.org/data-structure/rod-cutting-problem-dp-24/
    // Top - Down Approach --> Memoization
    public static int count(int index,int capacity,int[] wt,int[] val,int[][] dp){
        if(index==0) return (capacity/wt[0])*val[0];
        if(dp[index][capacity]!=-1) return dp[index][capacity];
        int notTake=count(index-1,capacity,wt,val,dp);
        int take= Integer.MIN_VALUE;
        if(wt[index]<=capacity) take=val[index]+count(index,capacity-wt[index],wt,val,dp);
        return dp[index][capacity]=Math.max(notTake,take);
    }
    public static void main(String[] args) {
        int[] wt = { 2, 4, 6 };
        int[] val = { 5, 11, 13 };
        int capacity = 10;
        int n = wt.length;
        int[][] dp=new int[n][capacity+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(count(n-1,capacity,wt,val,dp));
    }
}
