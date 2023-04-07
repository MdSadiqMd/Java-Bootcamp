import java.util.HashMap;
import java.util.LinkedHashMap;
/*
Here the key and value is stored in the form of objects
we can give both key and value of Any type either string,int,float,....
In HashMap the order of Insertion is ***not preserved
In Linked HashMap the order of Insertion ***is Preserved
 */
public class _3_HashMap_and_LinkedHashMap {
    public static void main(String[] args) {
        HashMap hm=new HashMap();
        //Map hm=new HashMap(); //This is as same as the upper line as due to Polymorphism
        hm.put(1,"sadiq");
        //hm.put(null,null); //we can also give key and value as null rather giving any value
        hm.put(2,45);
        hm.put(3,"sadiq2");
        hm.put("sadiq","sadiq3");
        hm.put("sadiq1",342);
        System.out.println(hm);

        LinkedHashMap lh=new LinkedHashMap();
        //Map lh=new LinkedHashMap(); //This is as same as the upper line as due to Polymorphism
        lh.put(1,"sadiq");
        //lh.put(null,null); //we can also give key and value as null rather giving any value
        lh.put(2,45);
        lh.put(3,"sadiq2");
        lh.put("sadiq","sadiq3");
        lh.put("sadiq1",342);
        System.out.println(lh);
    }
}
