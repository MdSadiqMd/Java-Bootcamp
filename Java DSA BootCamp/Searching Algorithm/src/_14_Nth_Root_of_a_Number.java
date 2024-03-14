public class _14_Nth_Root_of_a_Number {
    // Nth Root of a Number --> https://takeuforward.org/data-structure/nth-root-of-a-number-using-binary-search/
    // The Cube will easily Overflow. So, we write the helper function to return the condition
    public static int helper(int mid, int n, int m) {
        long ans = 1;
        for(int i = 1; i <= n; i++) {
            ans = ans * mid;
            if(ans > m) return 2;
        }
        if(ans == m) return 1;
        return 0;
    }
    public static int search(int n, int m) {
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int val = helper(mid, n, m);
            if (val == 1) return mid;
            else if (val == 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(3,27));
    }
}
