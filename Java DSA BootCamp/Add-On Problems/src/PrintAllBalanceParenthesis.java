// Approach --> Recursive Tree which go along splitting with respect to conditions and backtrack with answers --> Watch Tap academy Video
public class PrintAllBalanceParenthesis {
    public static void balanceParams(char[] arr, int n, int i, int open, int close) {
        if (i == arr.length) {
            System.out.println(new String(arr));
            return;
        }
        if (open < n) {
            arr[i] = '(';
            balanceParams(arr, n, i + 1, open + 1, close);
        }
        if (close < open) {
            arr[i] = ')';
            balanceParams(arr, n, i + 1, open, close + 1);
        }
    }
    public static void main(String[] args) {
        int n = 5;
        char[] arr = new char[n * 2];
        balanceParams(arr, n, 0, 0, 0);
    }
}
