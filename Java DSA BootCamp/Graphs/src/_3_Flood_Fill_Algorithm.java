/*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image.

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

Example 1:

Input: image = {{1,1,1},{1,1,0},{1,0,1}},
sr = 1, sc = 1, newColor = 2.
Output: {{2,2,2},{2,2,0},{2,0,1}}
Explanation: From the center of the image
(with position (sr, sc) = (1, 1)), all
pixels connected by a path of the same color
as the starting pixel are colored with the new
color.Note the bottom corner is not colored 2,
because it is not 4-directionally connected to
the starting pixel.
 */
public class _3_Flood_Fill_Algorithm {
    public void dfs(int sr, int sc, int[][] ans, int[][] image, int[] delsr, int[] delsc, int newColor, int iniColor) {
        ans[sr][sc] = newColor;
        int m = image.length;
        int n = image[0].length;
        for (int i = 0; i < 4; i++) {
            int nrow = sr + delsr[i];
            int ncol = sc + delsc[i];
            if (nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && image[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor) {
                dfs(nrow, ncol, ans, image, delsr, delsc, newColor, iniColor);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int iniColor = image[sr][sc];
        int[][] ans = new int[image.length][image[0].length];

        int[] delsr = {-1, 0, 1, 0};
        int[] delsc = {0, 1, 0, -1};

        for (int i = 0; i < image.length; i++) {
            System.arraycopy(image[i], 0, ans[i], 0, image[0].length);
        }

        dfs(sr, sc, ans, image, delsr, delsc, newColor, iniColor);
        return ans;
    }

    public static void main(String[] args) {
        _3_Flood_Fill_Algorithm dfs = new _3_Flood_Fill_Algorithm();

        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1;
        int sc = 1;
        int newColor = 2;

        int[][] resultImage = dfs.floodFill(image, sr, sc, newColor);

        // Printing the result image
        for (int i = 0; i < resultImage.length; i++) {
            for (int j = 0; j < resultImage[0].length; j++) {
                System.out.print(resultImage[i][j] + " ");
            }
            System.out.println();
        }
    }
}
