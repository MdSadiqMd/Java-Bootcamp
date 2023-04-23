import java.util.*;
/*
Difference between Collections and Collection ?
Collection Framework which have some Inbuilt Classes and Interfaces which are used as an API by the developers
Collections is a class which has Inbuilt methods can apply on Collection methods
 */
public class _9_Collections_Methods {
    public static void main(String[] args) {
       ArrayList a=new ArrayList();
       a.add(400);
       a.add(500);
       a.add(100);
       a.add(200);
       a.add(300);
       System.out.println(a);

       //*****
       System.out.println(Collections.binarySearch(a,500)); //returns a wrong answer we need to sort before applying binary search operation

       Collections.sort(a);
       System.out.println(a);

       System.out.println(Collections.binarySearch(a,500)); //return index
       System.out.println(Collections.binarySearch(a,50)); //returns negative index as the element is not in arraylist

       Collections.rotate(a,3);
       System.out.println(a);

       Collections.shuffle(a);
       System.out.println(a);

       Collections.frequency(a,20);
       System.out.println(a);

       ArrayList a1=new ArrayList();
       a1.add("Sadiq4");
       a1.add("Sadiq5");
       a1.add("Sadiq1");
       a1.add("Sadiq2");
       a1.add("Sadiq3");
       System.out.println(a1);

       Collections.sort(a1);
       System.out.println(a1);

    }
}
