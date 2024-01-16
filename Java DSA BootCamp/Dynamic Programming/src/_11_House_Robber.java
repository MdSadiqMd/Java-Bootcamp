import java.util.ArrayList;
import java.util.Arrays;

public class _11_House_Robber {
    // Top - Down Approach --> Memoization
    public static int sum(int n, ArrayList<Integer> arr, int[] dp) {
        if (n == 0) {
            return arr.get(0);
        } if (n < 0) {
            return 0;
        } if (dp[n] != -1) {
            return dp[n];
        }
        int pickFirst = arr.get(n) + sum(n - 2, arr, dp);
        int pickLast = sum(n - 1, arr, dp);
        return dp[n] = Math.max(pickFirst, pickLast);
    }
    // Bottom - Up Approach --> Tabulation
    public static int sumTab(int n, ArrayList<Integer> arr, int[] dp) {
        if (n == 0) {
            return arr.get(0);
        } if (n < 0) {
            return 0;
        } if (dp[n] != -1) {
            return dp[n];
        }
        int pickFirst = arr.get(n) + dp[n-2];
        int pickLast = dp[n-1];
        return dp[n] = Math.max(pickFirst, pickLast);
    }
    // Space Optimization
    public static int sumSpace(int n, ArrayList<Integer> arr) {
        int prev1 = arr.get(0);
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int pickFirst = arr.get(i);
            if (i > 1) {
                pickFirst += prev2;
            }
            int pickLast = prev1;
            int curr = Math.max(pickFirst, pickLast);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public static long robStreet(int n, ArrayList<Integer> arr) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        if(n==1){
            return arr.get(0);
        }
        for (int i = 0; i < n; i++) {
            if (i != 0) arr1.add(arr.get(i));
            if (i != n - 1) arr2.add(arr.get(i));
        }
        long ans1 = sumSpace(n - 1, arr1);
        long ans2 = sumSpace(n - 1, arr2);
        return Math.max(ans1, ans2);
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1,5,1,2,6));
        int n = arr.size();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        System.out.println(robStreet(n,arr));
    }
}
