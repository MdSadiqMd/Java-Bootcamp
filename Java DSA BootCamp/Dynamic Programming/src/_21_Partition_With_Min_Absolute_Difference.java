import java.util.ArrayList;
import java.util.Arrays;

public class _21_Partition_With_Min_Absolute_Difference {
    // Partition set into two subsets with Min Absolute Difference --> https://takeuforward.org/data-structure/partition-set-into-2-subsets-with-min-absolute-sum-diff-dp-16/

    // Top - Down Approach --> Memoization
    public static int partition(int n, ArrayList<Integer> arr){
        int sum=0;
        for(int i=0;i<n;i++) sum+=arr.get(i);
        boolean[][] dp=new boolean[n][sum+1];
        for(int i=0;i<=sum;i++) dp[0][i]=(i==arr.get(0));
        for(int index=1;index<n;index++){
            for(int target=0;target<=sum;target++){
                boolean notTaken=dp[index-1][target];
                boolean taken=false;
                if(arr.get(index)<=target) taken=dp[index-1][target-arr.get(index)];
                dp[index][target]=taken || notTaken;
            }
        }
        int min=Integer.MIN_VALUE;
        for(int i=0;i<=sum;i++) if(dp[n-1][i]) min=Math.min(min,Math.abs(i-(sum-i)));
        return min;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        int n = arr.size();
        System.out.println(partition(n,arr));
    }
}
