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
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        int n=arr.length;
        int k=4;
        int[][] dp=new int[n][k+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(sum(n-1,k,arr,dp));
    }
}
