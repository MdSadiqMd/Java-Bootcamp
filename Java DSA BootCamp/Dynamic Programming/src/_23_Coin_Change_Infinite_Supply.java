import java.util.Arrays;

public class _23_Coin_Change_Infinite_Supply {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int T = 7;
        int n = arr.length;
        int[][] dp = new int[n][T + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
    }
}
