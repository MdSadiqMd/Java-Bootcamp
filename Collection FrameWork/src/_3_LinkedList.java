import java.util.*;
public class _3_LinkedList {
    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.add(100);
        ll.add(200);
        ll.add(300);
        System.out.println(ll);
        LinkedList ll1=new LinkedList();
        ll1.add("sadiq");
        ll1.add(500);
        ll1.add(456.12);
        System.out.println(ll1);
        ll.add(ll1);
        System.out.println(ll);
        ll.add(2,500); //***Here it will not move the other elements it just replaces the Index element
        System.out.println(ll);
        System.out.println(ll.peek());//will return first element
        System.out.println(ll);
        System.out.println(ll.poll());//will return first element ,but it will remove the element after returning the object
        System.out.println(ll);
        //********************************
        List ll2=new LinkedList();
        ll2.add(100);
        ll2.add(200);
        ll2.add(300);
        System.out.println(ll2);
        //System.out.println(ll2.peek()); //*****here this will give error as this object it from List interface not from Dequeue Interface so these methods Doesn't exist
    }
}
