import java.util.LinkedList;
import java.util.Queue;

public class _3_Stack_Using_Queue {
    public static class StackUsingQueue {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        static void add(int data) {
            // Move Elements from Q1 to Q2
            while (!q1.isEmpty()) {
                q2.add(q1.peek());
                q1.poll();
            }
            // Insert New Data to Q2
            q1.add(data);
            // Move Back All the Elements from Q2 to Q1
            while (!q2.isEmpty()) {
                q1.add(q2.peek());
                q2.poll();
            }
        }

        // Removing Elements from the Stack
        static int remove() {
            if (q1.isEmpty()) {
                System.out.println("Stack Overflow");
                return -1; // Return a default value or handle the error appropriately
            }
            return q1.poll();
        }

        public static void main(String[] args) {
            add(1);
            add(2);
            add(3);
            System.out.println(remove()); // Remove the top element from the stack
            System.out.println(remove());
        }
    }
}
