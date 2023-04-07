import java.util.*;
/*
Order of Insertion is not Preserved
Load Factor 0.75
HashTable is Synchronized(one thread can run at a time) and HashMap isn't
 */
public class _6_HashTable {
    public static void main(String[] args) {
        Hashtable ht=new Hashtable();
        ht.put(1,"sadiq");
        ht.put(2,"sadiq1");
        ht.put(3,"sadiq2");
        //ht.put(null,"sadiq2"); //null key is *****not allowed
        System.out.println(ht);
    }
}
