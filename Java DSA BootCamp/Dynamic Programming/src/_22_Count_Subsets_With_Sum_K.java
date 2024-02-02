import java.util.Arrays;

public class _22_Count_Subsets_With_Sum_K {
    // Count SubSets With Sum K --> https://takeuforward.org/data-structure/count-subsets-with-sum-k-dp-17/

    // Top - Down Approach --> Memoization
    public static int count(int index,int target,int[] arr,int[][] dp){
        if(target==0) return 1;
        if(index==0) return arr[0]==target?1:0;
        if(dp[index][target]!=-1) return dp[index][target];
        int notTake=count(index-1,target,arr,dp);
        int take=0;
        if(arr[index]<=target) take+=count(index-1,target-arr[index],arr,dp);
        return dp[index][target]=notTake+take;
    }
    public static int countTab(int index,int target,int[] arr,int[][] dp){
        if(target==0) return 1;
        if(index==0) return arr[0]==target?1:0;
        if(dp[index][target]!=-1) return dp[index][target];
        int notTake=dp[index-1][target];
        int take=0;
        if(arr[index]<=target) take+=dp[index-1][target-arr[index]];
        return dp[index][target]=notTake+take;
    }
    public static int countSpace(int n,int k,int[] arr){
        int[] prev=new int[k+1];
        prev[0]=1;
        if(arr[0]<=k) prev[arr[0]]=1;
        for(int index=1;index<=n-1;index++){
            int[] curr=new int[k+1];
            curr[0]=1;
            for(int target=1;target<=k;target++){
                int notTake=prev[target];
                int take=0;
                if(arr[index]<=target) take=prev[target-arr[index]];
                curr[target]=take+notTake;
            }
            prev=curr;
        }
        return prev[k];
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        int n=arr.length;
        int k=5;
        int[][] dp=new int[n][k+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(count(n-1,k,arr,dp));
        System.out.println(countTab(n-1,k,arr,dp));
        System.out.println(countSpace(n-1,k,arr));
    }
}
