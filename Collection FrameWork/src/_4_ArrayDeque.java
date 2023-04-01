//This extends Queue data structure here in Array Queue we can perform the operations from the both ends of the Queue
import java.util.ArrayDeque;
public class _4_ArrayDeque {
    public static void main(String[] args) {
        ArrayDeque ad=new ArrayDeque();
        ad.add(10);
        ad.add(20);
        ad.add(30);
        ad.add("sadiq");
        System.out.println(ad);
        ad.addFirst(100);
        ad.addLast(200);
        System.out.println(ad);

        //offer method in this example offer acts same as add method but in general when we use offer method it may or may not add element to the array Deque it may reject the element based on memory management
        ad.offer("offer1");
        ad.offerFirst("offer1");
        ad.offerLast("offer1");
        System.out.println(ad);
    }
}
