import java.security.KeyStore;
import java.util.*;
public class _4_Accessing_Objects_In_Map {
    public static void main(String[] args) {
        Map hm=new HashMap();
        hm.put(1,"sadiq");
        hm.put(2,45);
        hm.put(3,"sadiq2");
        hm.put("sadiq","sadiq3");
        hm.put("sadiq1",342);
        System.out.println("Map");
        System.out.println(hm);
        System.out.println();
        //To Access value with key using get
        System.out.println("Using get");
        System.out.println(hm.get(4));
        System.out.println();
        //To Access Keys Using Set
        System.out.println("Using Iterator");
        Set set=hm.keySet(); //In key set k is small
        Iterator itr=set.iterator();
        while(itr.hasNext()){
            System.out.println("key "+itr.next());
        }
        System.out.println();
        //To Access ***Values Using Collection
        System.out.println("Using Collection");
        Collection values=hm.values();
        Iterator itr1=values.iterator();
        while(itr1.hasNext()){
            System.out.println("Values "+itr1.next());
        }
        System.out.println();
        //To Access the whole Entry (both values and key)
        System.out.println("Entry Using set");
        Set s1=hm.entrySet();
        Iterator itr2= s1.iterator();
        while(itr2.hasNext()){
            //System.out.println(itr2.next());
            //(or)
            Map.Entry data= (Map.Entry) itr2.next();
            System.out.println(data.getKey()+" : "+data.getValue());
        }
    }
}
