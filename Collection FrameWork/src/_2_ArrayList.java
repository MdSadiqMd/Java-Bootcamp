//Array List preserve or maintain the order of Insertion That means it shows the output in the same order of Insertion
//Duplicates are allowed in ArrayList
//Array List class uses Dynamic array to store duplicate element of different data types
import java.util.*;
public class _2_ArrayList {
    public static void main(String[] args) {
        //Storing Homogeneous type of data
        ArrayList al=new ArrayList(); //Interface with Dequeue Interface
        al.add(100);
        al.add(200);
        al.add(300);
        System.out.println(al);
        //Storing Heterogeneous type of data
        ArrayList al1=new ArrayList();
        al1.add("sadiq");
        al1.add(200);
        al1.add(300.246);
        System.out.println(al1);
        //Adding two Collections
        al.add(al1);
        System.out.println(al);
        //Adding with respect to Index of Collections
        al.add(2,"Added Through Index"); //***Here the before second Index will move to third and third to fourth and so on
        System.out.println(al);
        //Methods in ArrayList
        System.out.println(al.contains(200));//return whether it is present or not
        System.out.println(al.indexOf(300.246));//return teh index of the element
        System.out.println(al.size());//return the size of the linked list
        al.ensureCapacity(2);//this will set the capacity of the list
        al.trimToSize();//this will remove the unused part of the capacity given
        System.out.println(al);
        //********************************
        List ll2=new ArrayList();
        ll2.add(100);
        ll2.add(200);
        ll2.add(300);
        System.out.println(ll2);
        //System.out.println(ll2.peek()); //*****here this will give error as this object it from List interface not from Dequeue Interface so these methods Doesn't exist
    }
}
