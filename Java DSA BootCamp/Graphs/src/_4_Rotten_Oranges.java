/*
Given a matrix of dimension M * N where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:

0: Empty cell
1: Cells have fresh oranges
2: Cells have rotten oranges
Determine what is the minimum time required so that all the oranges become rotten. A rotten orange at index (i,j) can rot other fresh oranges which are its neighbours (up, down, left and right). If it is impossible to rot every orange then simply return -1.

Examples:

Input:  arr[][C] = { {2, 1, 0, 2, 1}, {1, 0, 1, 2, 1}, {1, 0, 0, 2, 1}};
Output: 2
Explanation: At 0th time frame:
{2, 1, 0, 2, 1}
{1, 0, 1, 2, 1}
{1, 0, 0, 2, 1}
At 1st time frame:
{2, 2, 0, 2, 2}
{2, 0, 2, 2, 2}
{1, 0, 0, 2, 2}
At 2nd time frame:
{2, 2, 0, 2, 2}
{2, 0, 2, 2, 2}
{2, 0, 0, 2, 2}
 */
import java.util.LinkedList;
import java.util.Queue;

public class _4_Rotten_Oranges {
    public int[][] rottenOranges(int[][] matrix, int row, int col, int[] delsr, int[] delsc) {
        int n = matrix.length;
        int m = matrix[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});

        while (!queue.isEmpty()) {
            int[] orange = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nrow = orange[0] + delsr[i];
                int ncol = orange[1] + delsc[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && matrix[nrow][ncol] == 1) {
                    matrix[nrow][ncol] = 2;
                    queue.offer(new int[]{nrow, ncol});
                }
            }
        }

        return matrix;
    }

    public int rottenOrangesTime(int[][] matrix, int row, int col, int[] delsr, int[] delsc) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nrow = row + delsr[i];
            int ncol = col + delsc[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && matrix[nrow][ncol] == 1) {
                count++;
            }
        }
        return count;
    }

    public int[][] Components(int[][] matrix, int row, int col) {
        int[] delsr = {-1, 0, 1, 0};
        int[] delsc = {0, 1, 0, -1};
        rottenOranges(matrix, row, col, delsr, delsc);
        return matrix;
    }

    public int ComponentsTime(int[][] matrix, int row, int col) {
        int[] delsr = {-1, 0, 1, 0};
        int[] delsc = {0, 1, 0, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col, 0}); // The third element of the array represents time

        int maxTime = 0; // Track the maximum time taken to rot all oranges

        while (!queue.isEmpty()) {
            int[] orange = queue.poll();
            int currentRow = orange[0];
            int currentCol = orange[1];
            int currentTime = orange[2];
            maxTime = currentTime;

            for (int i = 0; i < 4; i++) {
                int nrow = currentRow + delsr[i];
                int ncol = currentCol + delsc[i];
                if (nrow >= 0 && nrow < matrix.length && ncol >= 0 && ncol < matrix[0].length && matrix[nrow][ncol] == 1) {
                    matrix[nrow][ncol] = 2;
                    queue.offer(new int[]{nrow, ncol, currentTime + 1});
                }
            }
        }

        // Check if there are any fresh oranges left (value 1) after the BFS
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    return -1; // Not all oranges can be rotten
                }
            }
        }

        return maxTime;
    }

    public static void main(String[] args) {
        _4_Rotten_Oranges dfs = new _4_Rotten_Oranges();

        int[][] Box = {
                {2, 1, 1},
                {1, 2, 0},
                {1, 0, 1}
        };
        int sr = 1;
        int sc = 1;

        int[][] resultBox = dfs.Components(Box, sr, sc);

        // Printing the result image
        for (int i = 0; i < resultBox.length; i++) {
            for (int j = 0; j < resultBox[0].length; j++) {
                System.out.print(resultBox[i][j] + " ");
            }
            System.out.println();
        }

        int result = dfs.ComponentsTime(Box, sr, sc);
        System.out.println("The time taken to Rotten Oranges is " + result);
    }
}


