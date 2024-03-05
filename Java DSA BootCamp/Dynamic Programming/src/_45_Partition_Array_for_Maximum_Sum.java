import java.util.Arrays;

public class _45_Partition_Array_for_Maximum_Sum {
    // Partition Array for Maximum Sum --> https://takeuforward.org/data-structure/partition-array-for-maximum-sum-front-partition-dp-54/

    // Top - Down Approach --> Memoization
    public static int count(int[] arr,int n,int ind,int k,int[] dp){
        if(ind==n) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int len=0;
        int cost=Integer.MIN_VALUE;
        int ans=Integer.MIN_VALUE;
        for(int i=ind;i<Math.min(n,ind+k);i++){
            len++;
            cost=Math.max(cost,arr[i]);
            ans=Math.max(ans,len*cost+count(arr,n,ind+len,k,dp));
        }
        return dp[ind]=ans;
    }
    // Bottom - Up Approach --> Tabulation
    public static int countTab(int[] arr,int n,int ind,int k,int[] dp){
        if(ind==n) return 0;
        if(dp[ind]!=-1) return dp[ind];
        for(int j=n-1;j>=0;j--){
            int len=0;
            int cost=Integer.MIN_VALUE;
            int ans=Integer.MIN_VALUE;
            for(int i=ind;i<Math.min(n,ind+k);i++){
                len++;
                cost=Math.max(cost,arr[i]);
                ans=Math.max(ans,len*cost+dp[j+len]);
            }
            return dp[ind]=ans;
        }
        return dp[0];
    }
    public static void main(String[] args) {
        int[] arr={1, 15, 7, 9, 2, 5, 10};
        int n=arr.length;
        int k=3;
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(count(arr,n,0,k,dp));
        System.out.println(countTab(arr,n,0,k,dp));
    }
}
