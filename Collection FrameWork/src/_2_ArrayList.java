//Array List preserve or maintain the order of Insertion That means it shows the output in the same order of Insertion
import java.util.*;
public class _2_ArrayList {
    public static void main(String[] args) {
        //Storing Homogeneous type of data
        ArrayList al=new ArrayList();
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
        al.add(2,"Added Through Index"); //Here the before second Index will move to third and third to fourth and so on
        System.out.println(al);
    }
}
