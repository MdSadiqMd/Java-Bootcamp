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
