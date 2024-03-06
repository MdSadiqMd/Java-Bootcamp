import java.util.Stack;

public class _3_Largest_Rectangle_in_Histogram {
    public static int area(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int width, height;
        int n = arr.length;
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i == n || arr[stack.peek()] >= arr[i])) {
                height = arr[stack.pop()];
                width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, width * height);
            }
            stack.push(i);
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {6, 7, 5, 2, 4, 5, 9, 3};
        System.out.println(area(arr));
    }
}
