import java.util.*;

public class _4_Rat_in_a_Maze_Problem {
    static final int MAX = 5;

    static void getallpath(int[][] matrix, int n, int row,
                           int col, List<String> ans,
                           String cur)
    {
        if (row >= n || col >= n || row < 0 || col < 0
                || matrix[row][col] == 0) {
            return;
        }

        if (row == n - 1 && col == n - 1) {
            ans.add(cur);
            return;
        }

        matrix[row][col] = 0;

        getallpath(matrix, n, row - 1, col, ans, cur + "U");
        getallpath(matrix, n, row, col + 1, ans, cur + "R");
        getallpath(matrix, n, row, col - 1, ans, cur + "L");
        getallpath(matrix, n, row + 1, col, ans, cur + "D");

        matrix[row][col] = 1;

        return;
    }

    static List<String> findPath(int[][] matrix, int n)
    {
        List<String> ans = new ArrayList<>();
        getallpath(matrix, n, 0, 0, ans, "");
        return ans;
    }

    public static void main(String[] args)
    {
        int[][] m = { { 1, 0, 0, 0, 0 },
                { 1, 1, 1, 1, 1 },
                { 1, 1, 1, 0, 1 },
                { 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 1 } };
        int n = m.length;
        List<String> ans = findPath(m, n);
        for (String i : ans) {
            System.out.println(i + " ");
        }
    }
}
