import java.util.Arrays;

public class _37_Longest_Increasing_Subsequence {
    // Longest Increasing Sub-Sequence --> https://takeuforward.org/data-structure/longest-increasing-subsequence-dp-41/ ,

    // Top - Down Approach --> Memoization
    public static int count(int[] arr,int n,int curr_ind,int prev_ind,int[][] dp){
        if(curr_ind==n) return 0;
        if(dp[curr_ind][prev_ind+1]!=-1) return dp[curr_ind][prev_ind+1];
        int notTake=count(arr,n,curr_ind+1,prev_ind+1,dp);
        int take=0;
        if(prev_ind==-1 || arr[curr_ind]>arr[prev_ind]) take=Math.max(take,1+count(arr,n,curr_ind+1,curr_ind,dp)); // Here, prev_ind is the curr_ind as it is taken
        return dp[curr_ind][prev_ind+1]=Math.max(take,notTake);
    }
    public static void main(String[] args) {
        int[] arr={10, 9, 2, 5, 3, 7, 101, 18};
        int n=arr.length;
        int[][] dp=new int[n][n+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(count(arr,n,0,-1,dp));
    }
}
