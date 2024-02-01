import java.util.ArrayList;
import java.util.Arrays;

public class _21_Partition_With_Min_Absolute_Difference {
    // Partition set into two subsets with Min Absolute Difference --> https://takeuforward.org/data-structure/partition-set-into-2-subsets-with-min-absolute-sum-diff-dp-16/

    // Top - Down Approach --> Memoization, Tabulation
    public static int partition(int n, ArrayList<Integer> arr){
        int sum = 0;
        for(int i = 0; i < n; i++) sum += arr.get(i);
        boolean[][] dp = new boolean[n][sum + 1];
        for(int i = 0; i <= sum; i++) dp[0][i] = (i == 0 || i == arr.get(0));
        for(int index = 1; index < n; index++) {
            for(int target = 0; target <= sum; target++) {
                boolean notTaken = dp[index - 1][target];
                boolean taken = false;
                if(arr.get(index) <= target) taken = dp[index - 1][target - arr.get(index)];
                dp[index][target] = taken || notTaken;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <= sum; i++) if(dp[n - 1][i]) min = Math.min(min, Math.abs(i - (sum - i)));
        return min;
    }
    // Space Optimization
    public static int partitionSpace(int n, ArrayList<Integer> arr) {
        int sum = 0;
        for (int i = 0; i < n; i++) sum += arr.get(i);
        boolean[] prev = new boolean[sum + 1];
        prev[0] = true;
        if (arr.get(0) <= sum) prev[arr.get(0)] = true;
        for (int index = 1; index < n; index++) {
            boolean[] curr = new boolean[sum + 1];
            curr[0] = true;
            for (int target = 1; target <= sum; target++) {
                boolean notTaken = prev[target];
                boolean taken = false;
                if (arr.get(index) <= target) taken = prev[target - arr.get(index)];
                curr[target] = taken || notTaken;
            }
            prev = curr;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= sum; i++) if (prev[i]) min = Math.min(min, Math.abs(i - (sum - i)));
        return min;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int n = arr.size();
        System.out.println(partition(n,arr));
        System.out.println(partitionSpace(n,arr));
    }
}
