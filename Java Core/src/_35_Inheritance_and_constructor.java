//If we use a Final keyword for a class it will **not participate in Inheritance
//if we apply final keyword to a method in a class it **will participate in inheritance ,but we cannot override it in child class
//if we apply final keyword to a variable we cannot modify it **out of the class
class base1{
    int x;

    base1() {   //base constructor 1
        System.out.println("base class constructor");
    }

    base1(int a) {   //base constructor 2
        System.out.println("base class constructor"+a);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;             /*this is the addressable to a value of different reference*/
    }
}

class derived1 extends base1{
    int y;

    derived1(){   //derived constructor 1
        System.out.println("derived class constructor 1");
    }

    /*derived1(){   //derived constructor 1
        super(5);  //if we comment this line base constructor 1 will run as it will be default
                   /*super is a keyword used to access the value of parent class
        System.out.println("derived class constructor 2");
    }*/

    derived1(int a,int b){   //derived constructor 2
        System.out.println("derived class constructor 3");
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
public class _35_Inheritance_and_constructor {
    public static void main(String[] args) {
        base1 b=new base1();
        derived1 d=new derived1(/*8,9*/); //if we remove the comment in arguments then we get line 34 output
    }
}
//comment out the upper code and run the down one
  /*  Write the following code in your editor below:

        A class named Arithmetic with a method named add that takes  integers as parameters and returns an integer denoting their sum.
        A class named Adder that inherits from a superclass named Arithmetic.
        Your classes should not be public
 import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//Write your code here
class Arithmetic {
    public int add(int a, int b) {
         return a + b;
        }
}

class Adder extends Arithmetic {
    //Empty Class as no further Implementations required
}
public class _35_Inheritance_and_constructor{
    public static void main(String []args){
        // Create a new Adder object
        Adder a = new Adder();

        // Print the name of the superclass on a new line
        System.out.println("My superclass is: " + a.getClass().getSuperclass().getName());

        // Print the result of 3 calls to Adder's `add(int,int)` method as 3 space-separated integers:
        System.out.print(a.add(10,32) + " " + a.add(10,3) + " " + a.add(10,10) + "\n");
     }
}*/
