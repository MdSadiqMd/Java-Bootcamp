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
    // Bottom - Up Approach --> Tabulation
    public static int countTab(int index,int capacity,int[] wt,int[] val,int[][] dp){
        if(index==0) return (capacity/wt[0])*val[0];
        if(dp[index][capacity]!=-1) return dp[index][capacity];
        for(int ind=1;ind<index;ind++){
            for(int T=0;T<=capacity;T++){
                int notTake=dp[index-1][capacity];
                int take= Integer.MIN_VALUE;
                if(wt[ind]<=T) take=val[ind]+dp[ind][T-wt[ind]];
                dp[ind][T]=Math.max(notTake,take);
            }
        }
        return dp[index-1][capacity];
    }
    // Space Optimization
    public static int countSpace(int index,int capacity,int[] wt,int[] val){
        int[] curr=new int[capacity+1];
        for (int i = wt[0]; i <= capacity; i++) {
            curr[i] = ((int) i / wt[0]) * val[0];
        }
        for (int ind = 1; ind < index; ind++) {
            for (int cap = 0; cap <= capacity; cap++) {
                int notTaken = curr[cap];
                int taken = Integer.MIN_VALUE;
                if (wt[ind] <= cap) taken = val[ind] + curr[cap - wt[ind]];
                curr[cap] = Math.max(notTaken, taken);
            }
        }
        return curr[capacity];
    }
    public static void main(String[] args) {
        int[] wt = { 2, 4, 6 };
        int[] val = { 5, 11, 13 };
        int capacity = 10;
        int n = wt.length;
        int[][] dp=new int[n][capacity+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(count(n-1,capacity,wt,val,dp));
        System.out.println(countTab(n-1,capacity,wt,val,dp));
        System.out.println(countSpace(n-1,capacity,wt,val));
    }
}
