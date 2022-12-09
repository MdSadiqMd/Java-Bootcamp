class base{
    int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}

class derived extends base{   //here the operations of class base had saved in class name derived
    int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
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
