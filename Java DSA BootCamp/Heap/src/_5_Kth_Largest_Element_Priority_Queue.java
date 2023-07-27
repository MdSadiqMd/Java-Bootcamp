import java.util.PriorityQueue;

public class _5_Kth_Largest_Element_Priority_Queue {
    public static int findKthLargest(int[] nums, int k) {
        // Create a min-heap (priority queue) with initial capacity k
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        // Fill the min-heap with the first k elements from the array
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        // For the rest of the elements, if it is larger than the smallest element in the heap, remove the smallest element and add the current element
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        // The top element in the min-heap will be the kth largest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        int kthLargest = findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + kthLargest);
    }
}
