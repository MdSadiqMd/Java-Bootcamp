import java.util.PriorityQueue;

public class _6_Connect_N_Ropes_With_Minimum_Cost {
    public static int connectNRopesWithMinCost(int[] ropes) {
        // Create a min-heap (priority queue) to store the rope lengths
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all the rope lengths to the min-heap
        for (int rope : ropes) {
            minHeap.offer(rope);
        }

        int totalCost = 0;

        // Combine ropes until there is only one rope left in the heap
        while (minHeap.size() > 1) {
            // Take the two smallest ropes from the heap
            int firstRope = minHeap.poll();
            int secondRope = minHeap.poll();

            // Combine the two ropes and add the cost to the total cost
            int combinedRope = firstRope + secondRope;
            totalCost += combinedRope;

            // Add the combined rope back to the heap
            minHeap.offer(combinedRope);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};
        int minCost = connectNRopesWithMinCost(ropes);
        System.out.println("Minimum cost to connect N ropes: " + minCost);
    }
}
