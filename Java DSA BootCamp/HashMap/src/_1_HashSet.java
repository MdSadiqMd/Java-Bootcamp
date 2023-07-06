import java.util.*;
public class _1_HashSet {
    public static void main(String[] args) {
        HashSet<Integer> Data=new HashSet<>();

        //Adding Data
        Data.add(1);
        Data.add(2);
        Data.add(3);
        Data.add(4);
        Data.add(5);
        System.out.println(Data);

        //Removing Data
        Data.remove(4);
        System.out.println(Data);

        //Contains Data or Not
        if(Data.contains(3)){
            System.out.println("Present");
        }
        else{
            System.out.println("Not Present");
        }

        //Iterator --> An Iterator is created then an object is created in hashset and it points to null and will point to any random element in the hashset
        //*** Iterator doesn't follow any order
        Iterator<Integer> iterator=Data.iterator();
        while (iterator.hasNext()) {
            int value = iterator.next(); // Retrieve the value from the iterator
            System.out.println(value); // Print the value
        }
    }
}
