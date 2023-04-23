/*
Generally when we are giving values in array we define as
String arr[]=new String[5];
here we need to give only String type of data and if else we give Int type of data then the error occur in ***Runtime
Now we use generics that will restrict the input data in what type we want and give error in ***Compile time only
It is Implemented from JDK 5 ,It provides Compile Time Error by enabling the specifications of the data type of Objects that a class or method can work with
 */
import java.util.*;
class Gen1<T>{
    T obj;
    public Gen1(T obj){
        this.obj=obj;
    }
    void Display(){
        System.out.println("The Given DataType is"+obj.getClass().getName());
    }
    public T getObj() {
        return obj;
    }
}
public class _8_Generics_in_Java {
    public static void main(String[] args) {
        ArrayList<Integer> al=new ArrayList<Integer>();
        //Collection<Integer> al=new ArrayList<Integer>();   //Here we can create through name of Parent class of ArrayList Collection
        //ArrayList<int> al=new ArrayList<int>();   //Here we cannot Create parent class on Primitive data types
        al.add(100);
        al.add(200);
        al.add(300);
        System.out.println(al);

        Gen1<Integer> g=new Gen1<Integer>(10);
        g.Display();
        System.out.println(g.getObj());
    }
}
