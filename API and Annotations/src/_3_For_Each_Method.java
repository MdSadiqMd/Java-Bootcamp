import java.util.List;
import java.util.*;
import java.util.function.Consumer;

public class _3_For_Each_Method {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        System.out.println(list);

        //(or)
        //List<Integer> list= Arrays.asList(10, 20, 30, 40, 50);

        Consumer<Integer> cons=new Consumer<Integer>() { //giving reference of Consumer Interface
            public void accept(Integer i) {
                System.out.println(i);
            }
        }; //Constructor
    }
}
