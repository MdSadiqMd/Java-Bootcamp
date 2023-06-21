public class _5_N_Queens_Problem {
    public static void printSolution(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check left side of the current row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on the left side
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static boolean solveNQueens(int[][] board, int col, int n) {
        // Base case: All queens are placed
        if (col >= n) {
            return true;
        }

        // Try placing the queen in each row of the current column
        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col, n)) {
                board[i][col] = 1; // Place the queen

                // Recursive call to place queens in the remaining columns
                if (solveNQueens(board, col + 1, n)) {
                    return true;
                }

                // If placing the queen leads to no solution, backtrack
                board[i][col] = 0; // Remove the queen
            }
        }

        // No solution found
        return false;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];

        if (solveNQueens(board, 0, n)) {
            printSolution(board, n);
        } else {
            System.out.println("Solution doesn't exist");
        }
    }
}
