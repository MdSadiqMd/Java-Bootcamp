import java.util.Arrays;

public class _20_Partition_Equal_Subset_Sum {
    // Partition Equal Subset Sum --> https://takeuforward.org/data-structure/partition-equal-subset-sum-dp-15/

    // Top - Down Approach --> Memoization
    public static boolean helper(int n,int[] arr){
        int sum=0;
        for(int i=0;i<=arr.length-1;i++) sum+=arr[i];
        if(sum%2!=0) return false;
        int k=sum/2;
        boolean[][] dp=new boolean[n][k+1];
        for(boolean[] row:dp) Arrays.fill(row,false);
        return partition(n-1,k,arr,dp);
    }
    public static boolean partition(int index, int target, int[] arr, boolean[][] dp){
        if(target==0) return true;
        if(index==0) return arr[0]==target;
        if(dp[index][target]) return true;
        boolean notTake=partition(index-1,target,arr,dp);
        boolean take=false;
        if(arr[index]<=target) take=partition(index-1,target-arr[index],arr,dp);
        return dp[index][target]=take || notTake;
    }
    // Bottom - Up Approach --> Tabulation
    public static boolean partitionTab(int n,int[] arr){
        int sum=0;
        for(int i=0;i<=arr.length-1;i++) sum+=arr[i];
        if(sum%2!=0) return false;
        else{
            int k=sum/2;
            boolean[][] dp=new boolean[n][k+1];
            for(boolean[] row:dp) Arrays.fill(row,false);
            for(int i=0;i<n;i++) dp[i][0]=true;
            if(arr[0]<=k) dp[0][arr[0]]=true;
            for(int index=1;index<n;index++){
                for(int target=0;target<=k;target++){
                    boolean notTake=dp[index-1][target];
                    boolean take=false;
                    if(arr[index]<=target) take=dp[index-1][target-arr[index]];
                    dp[index][target]=take || notTake;
                }
            }
            return dp[n-1][k];
        }
    }
    // Space Optimization
    public static boolean partitionSpace(int n,int[] arr){
        boolean[] prev=new boolean[n];

    }
    public static void main(String[] args) {
        int[] arr={2,3,3,3,4,5};
        int n=arr.length;
        System.out.println(helper(n-1,arr));
        System.out.println(partitionTab(n,arr));
    }
}
