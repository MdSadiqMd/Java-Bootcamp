import java.util.HashMap;
import java.util.WeakHashMap;
/*
Here when we run without hash map and weak hashmap the variable will go to garbage collector
Here when we run with hash map the garbage collector will get dominated by hash map and print the employee status
Here when we run with weak hash map the weak hash map will get dominated by garbage collector and the variable will move to garbage collector
 */
class Employee{
    private String name;
    private int emId;

    public Employee(String name,int emId){
        this.name=name;
        this.emId=emId;
    }

    public String toString(){
        return emId+" "+name;
    }
}
public class _7_HashMap_WeakHashMap {
    public static void main(String[] args) {
        Employee e=new Employee("sadiq",47);
        /*
        HashMap hm=new HashMap();
        hm.put(e,"sadiq");
        */
        //(or)
        /*
        WeakHashMap hm=new WeakHashMap();
        hm.put(e,"sadiq");
        */
        e=null;
        System.gc(); //will call garbage collector
        //System.out.println(hm);
        System.out.println("LastLine");
    }
}
