//1)create a class circle and inherit in a cylinder

class circle{
    public int radius;

    circle(int r){   //creating an constructor which manually assign value of radius
        System.out.println("class circle of manual radius");
        this.radius=r;
    }

    //using double datatype for finding area
    public double area (){  //creating an constructor to return area of the circle
        return Math.PI*this.radius*this.radius;
    }
}

class cylinder1 extends circle{
    public int height;  //creating an variable as height as the radius is already inherited

    cylinder1(int r,int h){
        super(r);
        System.out.println("class cylinder of manual radius and height");
        this.height=h;
    }

    //using double datatype for finding volume
    public double volume(){  //creating an construtor which return volume of the cylinder
        return Math.PI*this.radius*this.radius*this.height;
    }
}
public class _38_practice_on_inheritance {
    public static void main(String[] args) {
        cylinder1 obj=new cylinder1(1,1);
        circle obj1=new circle(4);
    }
}
