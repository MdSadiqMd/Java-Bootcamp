import java.util.Arrays;

public class _3_Target_Sum {
    // Target Sum --> https://takeuforward.org/data-structure/target-sum-dp-21/

    // Top - Down Approach --> Memoization
    public static int sum(int index,int target,int[] arr,int[][] dp){
        if(index==0){
            if (target == 0 && arr[0] == 0) return 2;
            if (target == 0 || target == arr[0]) return 1;
            return 0;
        }
        if(dp[index][target]!=-1) return dp[index][target];
        int notTake=sum(index-1,target,arr,dp);
        int take = 0;
        if(arr[index]<=target) take=sum(index-1,target-arr[index],arr,dp);
        return dp[index][target]=notTake+take;
    }
    public static void main(String[] args) {
        int[] arr={1,2,3,1};
        int n=arr.length;
        int target=3;
        int sum=0;
        int[][] dp=new int[n][target+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        for(int val:arr) sum+=val;
        if(sum-target<0 || (sum-target)%2==1) System.out.println("Edge Case Bro");
        else{
            System.out.println(sum(n-1,target,arr,dp));
        }
    }
}
