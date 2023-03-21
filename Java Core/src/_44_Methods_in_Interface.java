/*
We can create the objects in interface we use three different method interfaces they are:
1.Default Interface
2.Static Interface
3.Functional Interface
when we create an abstract class without any methods it is called marker or functional interface but, why we create such one's this is due to in java we have some methods to just allow the thing to be done for such we use this thing
 */
interface A1{
    void show();
    //void config(){} --> this will give error as methods cannot be created to solve this After java 8 they introduced the keyword the down line not show any error
    default void config(){
        System.out.println("In config");
    }
    static void abc(){
        System.out.println("In abc");
    }
}

class B1 implements A1{
    //we don't need to declare other methods like config and abc as they will be present after implementation the void method won't present as it not have default or static keyword
    public void show(){
        System.out.println("In show");
    }
}

public class _44_Methods_in_Interface {
    public static void main(String[] args) {
        A1.abc();
        //A1.config();--> this gives error as we cannot access the default variable so, we create an object for that
        A1 obj=new B1();
        obj.config();
    }
}
