import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _37_Longest_Increasing_Subsequence {
    // Longest Increasing Sub-Sequence --> https://takeuforward.org/data-structure/longest-increasing-subsequence-dp-41/, https://takeuforward.org/data-structure/printing-longest-increasing-subsequence-dp-42/, https://takeuforward.org/data-structure/longest-increasing-subsequence-binary-search-dp-43/

    // Top - Down Approach --> Memoization
    public static int count(int[] arr,int n,int curr_ind,int prev_ind,int[][] dp){
        if(curr_ind==n) return 0;
        if(dp[curr_ind][prev_ind+1]!=-1) return dp[curr_ind][prev_ind+1];
        int notTake=count(arr,n,curr_ind+1,prev_ind+1,dp);
        int take=0;
        if(prev_ind==-1 || arr[curr_ind]>arr[prev_ind]) take=Math.max(take,1+count(arr,n,curr_ind+1,curr_ind,dp)); // Here, prev_ind is the curr_ind as it is taken
        return dp[curr_ind][prev_ind+1]=Math.max(take,notTake);
    }
    // Bottom - Up Approach --> Tabulation
    public static int countTab(int[] arr,int n,int[][] dp){
        for(int i=n-1;i<=0;i--){
            for(int j=i-1;j<=-1;j--){
                int notTake=dp[i+1][j+1];
                int take=0;
                if(j==-1 || arr[i]>arr[j]) take=Math.max(take,1+dp[i+1][i]);
                return dp[i][j+1]=Math.max(take,notTake);
            }
        }
        return dp[0][0];
    }
    // Space Optimization
    public static int countSpace(int[] arr,int n){
        int[] next=new int[n+1];
        int[] curr=new int[n+1];
        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int notTake=next[j+1];
                int take=0;
                if(j==-1 || arr[i]>arr[j]) take=Math.max(take,1+next[i+1]);
                curr[j+1]=Math.max(take,notTake);
            }
            next = curr.clone();
        }
        return curr[0];
    }
    // Printing The Longest Increasing SubSequence
    public static int countPrint(int[] arr,int n){
        int[] dp=new int[n];
        Arrays.fill(dp,1);
        int[] hash=new int[n];
        Arrays.fill(hash,1);
        for(int i=0; i<=n-1; i++){
            hash[i] = i; // initializing with current index
            for(int prev_index = 0; prev_index <=i-1; prev_index ++){
                if(arr[prev_index]<arr[i] && 1 + dp[prev_index] > dp[i]){
                    dp[i] = 1 + dp[prev_index];
                    hash[i] = prev_index;
                }
            }
        }
        int ans = -1;
        int lastIndex =-1;
        for(int i=0; i<=n-1; i++){
            if(dp[i]> ans){
                ans = dp[i];
                lastIndex = i;
            }
        }
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(arr[lastIndex]);
        while(hash[lastIndex] != lastIndex){ // till not reach the initialization value
            lastIndex = hash[lastIndex];
            temp.add(arr[lastIndex]);
        }
        for(int i=temp.size()-1; i>=0; i--) System.out.print(temp.get(i)+" ");
        return ans;
    }
    // Patience Sorting
    public static List<Integer> countSortPrint(int[] arr, int n, List<Integer> ans) {
        for (int i = 0; i < n; i++) {
            int index = binarySearch(ans, arr[i]);
            if (index == ans.size()) ans.add(arr[i]);
            else ans.set(index, arr[i]);
        }
        return ans;
    }
    private static int binarySearch(List<Integer> ans, int target) {
        int left = 0, right = ans.size();
        int result = ans.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (ans.get(mid) < target) left = mid + 1;
            else {
                result = mid;
                right = mid;
            }
        }
        return result;
    }
    // Counting The Longest Increasing Sub-Sequence
    public static int countLIS(int[] arr,int n){
        int[] dp= new int[n];
        int[] ct= new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(ct,1);
        int maxi = 1;
        for(int i=0; i<=n-1; i++){
            for(int prev_index = 0; prev_index <=i-1; prev_index ++){
                if(arr[prev_index]<arr[i] && dp[prev_index]+1>dp[i]){
                    dp[i] = dp[prev_index]+1;
                    ct[i] = ct[prev_index]; // Inherit
                }
                else if(arr[prev_index]<arr[i] && dp[prev_index]+1==dp[i]) ct[i] = ct[i] + ct[prev_index];
            }
            maxi = Math.max(maxi,dp[i]);
        }
        int nos =0;
        for(int i=0; i<=n-1; i++){
            if(dp[i]==maxi) nos+=ct[i];
        }
        return nos;
    }
    public static void main(String[] args) {
        int[] arr={10, 9, 2, 5, 3, 7, 101, 18};
        int n=arr.length;
        int[][] dp=new int[n][n+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(count(arr,n,0,-1,dp));
        System.out.println(countTab(arr,n,dp));
        System.out.println(countSpace(arr,n));
        System.out.println(countPrint(arr,n));
        System.out.println(countSortPrint(arr,n,new ArrayList<>()));
        System.out.println(countLIS(arr,n));
    }
}
