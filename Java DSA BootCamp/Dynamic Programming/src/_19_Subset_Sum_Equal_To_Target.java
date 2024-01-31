import java.util.Arrays;

public class _19_Subset_Sum_Equal_To_Target {
    // SubsetSum Equal to Target --> https://takeuforward.org/data-structure/subset-sum-equal-to-target-dp-14/

    // Top - Down Approach --> Memoization
    public static boolean sum(int index,int target,int[] arr,int[][] dp){
        if(index==0) return arr[0]==target;
        if(target==0) return true;
        if(dp[index][target]!=-1) return dp[index][target] != 0;
        boolean notTake=sum(index-1,target,arr,dp);
        boolean take=false;
        if(arr[index]<=target) take=sum(index-1,target-arr[index],arr,dp);
        return take || notTake;
    }
    // Bottom - Up Approach --> Tabulation
    public static boolean sumTab(int n, int k, int[] arr) {
        boolean[][] dp = new boolean[n][k + 1];
        for (int i = 0; i < n; i++) dp[i][0] = true;
        if (arr[0] <= k) dp[0][arr[0]] = true;
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                boolean notTake = dp[ind - 1][target];
                boolean take = false;
                if (arr[ind] <= target) take = dp[ind - 1][target - arr[ind]];
                dp[ind][target] = notTake || take;
            }
        }
        return dp[n - 1][k];
    }
    // Space Optimization
    public static boolean sumSpace(int n,int k,int[] arr){
        boolean[] prev=new boolean[k+1];
        prev[0]=true;
        if(arr[0]<=k) prev[arr[0]]=true;
        for(int i=0;i<n;i++){
            boolean[] curr=new boolean[k+1];
            curr[0]=true;
            for(int target=0;target<=k;target++){
                boolean notTake=prev[target];
                boolean take=false;
                if(arr[i]<=target) take=prev[target-arr[i]];
                curr[target]=take || notTake;
            }
            prev=curr;
        }
        return prev[k];
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        int n=arr.length;
        int k=4;
        int[][] dp=new int[n][k+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(sum(n-1,k,arr,dp));
        System.out.println(sumTab(n-1,k,arr));
        System.out.println(sumSpace(n-1,k,arr));
    }
}
