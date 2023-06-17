/*
The rat Should move from start to last of the maze.
Maze is represented as a 2D Array , Suppose element "0" in the maze is represented as clear path
                                    element "-1" is represented as an obstacle
Source -> arr[0][0]
Destination -> arr[n-1][n-1]
Moving Up -> i-1
Moving Down -> i+1
Moving Right -> j+1
Moving Left -> j-1
 */
public class _4_Rat_in_a_Maze_Problem {
    public static int Direction(int[][] arr, int n) {
        if (arr[0][0] == -1) { // No entry point
            return 0;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i][0] == 0) {
                arr[i][0] = 1;
            } else {
                break;
            }
        }

        for (int j = 0; j < n; j++) {
            if (arr[0][j] == 0) {
                arr[0][j] = 1;
            } else {
                break;
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] == -1) {
                    continue;
                }

                // If we can reach arr[i][j] from arr[i-1][j], then increment the count
                if (arr[i - 1][j] > 0) {
                    arr[i][j] = arr[i][j] + arr[i - 1][j];
                }

                // If we can reach arr[i][j] from arr[i][j-1], then increment the count
                if (arr[i][j - 1] > 0) {
                    arr[i][j] = arr[i][j] + arr[i][j - 1];
                }
            }
        }

        // If the final cell is blocked, return zero; otherwise, return count
        return (Math.max(arr[n - 1][n - 1], 0));
    }

    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0, 0},
                {0, -1, 0, 0},
                {-1, 0, 0, 0},
                {0, 0, 0, 0},
        };

        System.out.println(Direction(arr, arr.length));
    }
}
