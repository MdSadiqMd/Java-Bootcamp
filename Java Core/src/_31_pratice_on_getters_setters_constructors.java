// create an cylinder class and getter and setter of
// radius and height and find surface area and volume of cylinder

class cylinder{
    private int radius;
    private int height;

    //12 to 15 lines we created a constructor
    // which reduce the work of set and get item and
    // give us output

    public cylinder(int radius, int height) {
        this.radius = radius;
        this.height = height;
    }



    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public double surfaceArea(){  //use double
        return (2*3.14*radius*radius)+(2*3.14*radius*height);
    }

    public double volume(){
        return (3.14*radius*radius*height);
    }


}
public class _31_pratice_on_getters_setters_constructors {
    public static void main(String[] args) {
        //uncomment two lines and remove the arguments we get set item and get item output and now we will get output of constructor
        cylinder mycylinder = new cylinder(12,9);
        //mycylinder.setHeight(12);
        System.out.println(mycylinder.getHeight());
        //mycylinder.setRadius(9);
        System.out.println();
        System.out.println(mycylinder.getRadius());
        //here we are returning result from input
        System.out.println(mycylinder.surfaceArea());
        System.out.println(mycylinder.volume());
    }
}
