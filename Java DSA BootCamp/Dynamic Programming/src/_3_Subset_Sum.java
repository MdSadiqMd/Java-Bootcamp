public class _3_Subset_Sum {
    public static boolean subset(int[] arr, int n, int sum) {
        boolean subset[][] = new boolean[sum + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            subset[0][i] = true;
        }
        for (int i = 1; i <= sum; i++) {
            subset[i][0] = false;
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= arr[j - 1]) {
                    subset[i][j] = subset[i][j] || subset[i - arr[j - 1]][j - 1];
                }
            }
        }
        return subset[sum][n];
    }

    public static void main(String[] args) {
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        if (subset(arr, arr.length, sum)) {
            System.out.println("Subset Found");
        } else {
            System.out.println("Subset Not Found");
        }
    }
}
