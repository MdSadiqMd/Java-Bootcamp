import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class _9_FailFast_FailSafe {
    public static void main(String[] args) {
        ArrayList a1=new ArrayList();
        a1.add("sadiq");
        a1.add(200);
        a1.add(300.246);
        System.out.println(a1);
        /*
        //This Block will Lead to Infinite output as It Adds 100 infinitely
        for(int i=0;i<a1.size();i++){
            System.out.println(a1.get(i));
            a1.add(100);
        }
         */

        //FailFast
        //Here we get Concurrent error of failing fast only After Printing first element to solve this and not get concurrent error we use FailSafe Method
        /*Iterator itr1=a1.iterator();
        while(itr1.hasNext()){
            System.out.println(itr1.next());
            //a1.add(100);
        }*/

        //FailSafe
        //Here in output we are not getting any error and also the add statement we had given in while is also **not adding so here we are failing safe without any run time error
        CopyOnWriteArrayList al1=new CopyOnWriteArrayList();
        al1.add("sadiq");
        al1.add(200);
        al1.add(300.246);
        System.out.println(al1);
        Iterator itr =al1.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
            al1.add(100);
        }
    }
}
