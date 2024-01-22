import java.util.ArrayDeque;
import java.util.Deque;
// *** If the Array of Length "N" and the Length of Window is "K" then possible windows are "N-k+1"
public class Sliding_Window_Maximum {
    public static int[] maximumSliding(int[] arr, int k) {
        int n = arr.length;
        int[] res = new int[n - k + 1];
        if (n == 0) {
            return res;
        }
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int index = 0;
        while (index < k) {
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[index]) {
                deque.pollLast();
            }
            deque.offerLast(index);
            index++;
        }
        res[0] = arr[deque.peekFirst()];
        for (int i = 1; i < n - k + 1; i++) {
            if (!deque.isEmpty() && deque.peekFirst() <= (i - 1)) {
                deque.pollFirst();
            }
            index = i + k - 1; // Update index to the rightmost element in the current window
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[index]) {
                deque.pollLast();
            }
            deque.offerLast(index);
            res[i] = arr[deque.peekFirst()];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maximumSliding(arr, k);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}

