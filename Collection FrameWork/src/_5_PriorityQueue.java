//In Priority Queue it will not display the output of the queue as same as the data given in order
//The data will display in the form of Binary Tree or Known as minimum Heap Data Structure
//We cannot Store Heterogeneous type of data as String and Int cannot be Sorted in order of binary tree
import java.util.PriorityQueue;
public class _5_PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue pq=new PriorityQueue();
        pq.add(30);
        pq.add(40);
        pq.add(10);
        pq.add(20);
        pq.add(50);
        /*pq.add("sadiq");
        pq.add("Md.sadiq");
        pq.add("sadiq");
        pq.add("asadiq");
        pq.add("bsadiq");*/
        System.out.println(pq);
    }
}
