import java.util.Stack;

public class _4_Maximum_Rectangle_in_All_Ones {
    // Maximum Rectangle with All 1's --> https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/
    static int maxHist(int R, int C, int[] row){
        Stack<Integer> result = new Stack<Integer>();
        int top_val;
        int max_area = 0;
        int area = 0;
        int i = 0;
        while (i < C) {
            if (result.empty() || row[result.peek()] <= row[i]) result.push(i++);
            else {
                top_val = row[result.peek()];
                result.pop();
                area = top_val * i;
                if (!result.empty()) area = top_val * (i - result.peek() - 1);
                max_area = Math.max(area, max_area);
            }
        }
        while (!result.empty()) {
            top_val = row[result.peek()];
            result.pop();
            area = top_val * i;
            if (!result.empty()) area = top_val * (i - result.peek() - 1);
            max_area = Math.max(area, max_area);
        }
        return max_area;
    }
    public static int maxRectangle(int R, int C, int[][] A) {
        int result = maxHist(R, C, A[0]);
        for (int i = 1; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (A[i][j] == 1) A[i][j] += A[i - 1][j];
            }
            result = Math.max(result, maxHist(R, C, A[i]));
        }
        return result;
    }
    public static void main(String[] args) {
        int R = 4;
        int C = 4;
        int[][] A = {
                { 0, 1, 1, 0 },
                { 1, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
        };
        System.out.print( maxRectangle(R, C, A));
    }
}
