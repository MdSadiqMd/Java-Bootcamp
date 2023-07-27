import java.util.PriorityQueue;

public class _7_Find_Median {
    public static double findMedian(int[] nums) {
        // Create two heaps to store the elements in the array
        // The maxHeap stores the smaller half of the elements (left half)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        // The minHeap stores the larger half of the elements (right half)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            // Balance the heaps so that their sizes differ by at most one
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }

            // Balance the heaps
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } else if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        // Calculate the median based on the sizes of the heaps
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 2, 5, 7, 6};
        double median = findMedian(nums);
        System.out.println("Median of the array: " + median);
    }
}
