/*
It's like tool for code re-usability
Constructors will not participate in Inheritance, but they get executed because of super method present in base and derived class
***Any number of children can inherit one parent , but one child cannot inherit more than one parent
***If we not extend any parent class for a child class or parent class it extends object class (parent of all classes) as default
 */
class base{ //it is also called super class or parent class or base class
    int x;
    private String name="sadiq";
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
}

class derived extends base{   //here the operations of class base had saved in class name derived
    int y;                    //this class is called subclass ,child class or derived class

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    //System.out.println(name);//we cannot inherit private variables
}

public class _26_Inheritance {
    public static void main(String[] args) {
        base b=new base();
        b.setX(4);
        System.out.println(b.getX());
        derived d=new derived();
        d.setY(5);
        System.out.println(d.getX());  //we can access base class values in derived class
        System.out.println(d.getY());  //we can access derived class values in derived class also
    }
}
