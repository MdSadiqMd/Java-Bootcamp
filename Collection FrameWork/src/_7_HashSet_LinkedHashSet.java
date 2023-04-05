import java.util.*;
//Index Based Accessing is not Possible
//Duplicates are Not allowed
public class _7_HashSet_LinkedHashSet {
    public static void main(String[] args) {
        //Order of Insertion is not present it follows Hash Table to sort the data the length of Hash table will double Length Dynamically when the 75% of the Hash Table is filled
        System.out.println("HashSet");
        HashSet hs=new HashSet();
        hs.add(200);
        hs.add(300);
        hs.add(100);
        hs.add(400);
        hs.add(500);
        System.out.println(hs);

        //Order is preserved as it uses the Linked List and Hash set Behind the scene
        System.out.println("Linked HashSet");
        LinkedHashSet hs1=new LinkedHashSet();
        hs1.add(200);
        hs1.add(300);
        hs1.add(100);
        hs1.add(400);
        hs1.add(500);
        System.out.println(hs1);
    }
}
