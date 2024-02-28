import java.util.Arrays;

public class _40_Longest_Bitonic_Subsequence {
    // Longest Bitonic Sub-Sequence --> https://takeuforward.org/data-structure/longest-bitonic-subsequence-dp-46/
    public static int bitonic(int[] arr,int n){
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        for (int i = 0; i < n; i++) {
            for (int prevIndex = 0; prevIndex < i; prevIndex++) {
                if (arr[prevIndex] < arr[i]) dp1[i] = Math.max(dp1[i], 1 + dp1[prevIndex]);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int prevIndex = n - 1; prevIndex > i; prevIndex--) {
                if (arr[prevIndex] < arr[i]) dp2[i] = Math.max(dp2[i], 1 + dp2[prevIndex]);
            }
        }
        int maxi = -1;
        for (int i = 0; i < n; i++) maxi = Math.max(maxi, dp1[i] + dp2[i] - 1);
        return maxi;
    }
    public static void main(String[] args) {
        int[] arr = {1, 11, 2, 10, 4, 5, 2, 1};
        int n = arr.length;
        System.out.println(bitonic(arr,n));
    }
}
