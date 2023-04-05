import java.util.*;
//For Print or Traversing in a given input we often use for-each,for, while,do while loops rather we can use Iterator for Simplicity
public class _8_Iterator_ListIterator {
    public static void main(String[] args) {
        ArrayList a1=new ArrayList();
        a1.add("sadiq");
        a1.add(200);
        a1.add(300.246);
        System.out.println(a1);
        /*
        for(int i=0;i<a1.size();i++){
            System.out.println(a1.get(i));
        }
        (or)
        for(Object o:a1){
            System.out.println(o);
        }
        (or)
        */
        Iterator itr1=a1.iterator();
        while(itr1.hasNext()){
            System.out.println(itr1.next());
        }
        //*********Printing in reverse Direction Using HasPrevious
        ListIterator litr=a1.listIterator(a1.size());
        while(litr.hasPrevious()){
            System.out.println(litr.previous());
        }
    }
}
