import java.util.LinkedList;
import java.util.Queue;

public class _3_Stack_Using_Queue {
    public class StackUsingQueue {
        static Queue<Integer> q1=new LinkedList<>();
        static Queue<Integer> q2=new LinkedList<>();

        static void add(int data){
            while(!q1.isEmpty()){
                q2.add(q1.peek());
                q1.poll();
            }
        }

        public static void main(String[] args) {

        }
    }
}
