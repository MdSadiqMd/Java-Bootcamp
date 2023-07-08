import java.util.LinkedList;
import java.util.Queue;

public class _1_Queue {
    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<10;i++){
            q.add(i);
        }
        System.out.println(q);
        System.out.println(q.peek()); //Printing Top-Most Element of Queue
        q.remove(); //Removing Top-Most Element of the Queue
        System.out.println(q.peek());
        System.out.println(q.size()); //Return the Size of the Queue
    }
}
