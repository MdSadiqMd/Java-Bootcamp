import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _43_Burst_Balloons {
    // Burst Balloons --> https://takeuforward.org/data-structure/burst-balloons-partition-dp-dp-51/

    // Top - Down Approach --> Memoization
    public static int count(List<Integer> arr, int n, int l, int r, int[][] dp){
        if(l>r) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        int ans=Integer.MIN_VALUE;
        for(int i=l;i<=r;i++){
            int cost=(arr.get(l-1)*arr.get(i)*arr.get(r+1))+count(arr,n,l,i-1,dp)+count(arr,n,i+1,r,dp);
            ans=Math.max(ans,cost);
        }
        return dp[l][r]=ans;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>(Arrays.asList(3,1,5,8));
        int n=arr.size();
        arr.add(0,1);
        arr.add(1); // Adding one at last index+1
        int[][] dp=new int[n+2][n+2];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(count(arr,n,1,n,dp));
    }
}
