import java.util.*;
// *** We can Perform LIFO and FIFO from both the ends of the Queue
public class _4_Deque {
    public static void main(String[] args) {
        Deque<Integer> deque=new ArrayDeque<>();
        deque.addLast(4);
        deque.addLast(7);
        deque.addLast(9);
        System.out.println(deque);
        deque.removeLast();
        System.out.println(deque);
    }
}
