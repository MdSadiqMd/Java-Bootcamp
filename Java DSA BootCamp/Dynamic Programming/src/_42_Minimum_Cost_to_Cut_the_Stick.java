import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _42_Minimum_Cost_to_Cut_the_Stick {
    // Minimum Cost to cut the Stick --> https://takeuforward.org/data-structure/minimum-cost-to-cut-the-stick-dp-50/

    // Top - Down Approach --> Memoization
    public static int count(List<Integer> arr, int l, int r,int[][] dp){
        if(l>=r-1) return 0;
        if(dp[l][r]!=-1) return dp[l][r];
        int min=Integer.MAX_VALUE;
        for(int i=l+1;i<r;i++){
            int ans=(arr.get(r)-arr.get(l))+count(arr,l,i,dp)+count(arr,i,r,dp);
            min=Math.min(min,ans);
        }
        return dp[l][r]=min;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3, 5, 1, 4));
        int n=7;
        arr.add(0,0);
        arr.add(arr.size(),n);
        Collections.sort(arr);
        int[][] dp=new int[arr.size()+1][arr.size()+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(count(arr,0,arr.size()-1,dp));
    }
}
