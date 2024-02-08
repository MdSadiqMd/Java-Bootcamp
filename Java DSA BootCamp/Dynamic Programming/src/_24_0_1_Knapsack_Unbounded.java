import java.util.Arrays;

public class _24_0_1_Knapsack_Unbounded {
    public static void main(String[] args) {
        int[] wt = {2,4,6};
        int[] val = {5,11,13};
        int capacity = 10;
        int n = wt.length;
        int[][] dp=new int[n][capacity+1];
        for(int[] row:dp) Arrays.fill(row,-1);

    }
}
