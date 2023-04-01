//In Priority Queue it will not display the output of the queue as same as the data given in order
//The data will display in the form of Binary Tree
import java.util.PriorityQueue;
public class _5_PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue pq=new PriorityQueue();
        pq.add(30);
        pq.add(40);
        pq.add(10);
        pq.add(20);
        pq.add(50);
        System.out.println(pq);
    }
}
