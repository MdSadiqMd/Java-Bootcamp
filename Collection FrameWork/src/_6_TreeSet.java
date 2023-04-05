import java.util.*;
//Index Based accessing is not Possible in tree set
//Order is not Preserved it will print sorted it follows Binary search Tree order in background
//Duplicates are Not Allowed
public class _6_TreeSet {
    public static void main(String[] args) {
        TreeSet ts= new TreeSet();
        ts.add(200);
        ts.add(300);
        ts.add(100);
        ts.add(400);
        ts.add(500);
        System.out.println(ts);
        System.out.println(ts.higher(200));
        System.out.println(ts.lower(200));
        System.out.println(ts.ceiling(200));
        System.out.println(ts.floor(200));
        //The difference between floor,ceiling and Higher,lower is that the Higher,lower will return the value is and only the element present in the tree set and if not return error and ceiling and floor will return the near value of the element if the element is not present
        System.out.println(ts.ceiling(150));
        System.out.println(ts.floor(150));
    }
}
