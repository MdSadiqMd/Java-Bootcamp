//Interfaces - it is group of related methods with empty bodies
//we can't create objects from interfaces
//It only allows Abstract Methods and Interface is not object-oriented
//all the variables "should" be Public Static final, and we cannot create a constructor as we cannot create an object of an interface
//************In Java 8 we can create objects in interface to know check methods in Interface
/*Difference between the abstract and Interface
* the abstract class can have normal methods but interface can only have abstract methods
* we cannot have multiple abstract,but we can have multiple interfaces
* In abstract class we use extends and in interface we use implements
* One thing common in both that we cannot create object of both classes */
//Pro tip: if you want to create a class ,but should not be used by anyone then make the class and methods abstract that no one can make an object in any way
interface bicycle{ //creating an interface
    int a=100;
    void applybrake(int decrement); //every method is public and abstract so, we don't need to write "public abstract" separately
    void speedup(int increment);
}
interface horn{
    void blowhorn1();
    void blowhorn2();
}
class cycle implements bicycle, horn{  //we can extract more than one class in interfaces but cannot in abstract classes
                                       //we cannot create an object in interface ,but we cannot do anything in java without classes ,so we create an implements class a create an object there and use it as a reference at other classes or methods
    public void blowhorn(){
        System.out.println("inherited interface");
    }

    public void applybrake(int decrement){
        System.out.println("applying brake");
    }

    public void speedup(int decrement){
        System.out.println("applying speedup");
    }

    @Override
    public void blowhorn1() {
        System.out.println("horn 1");
    }

    @Override
    public void blowhorn2() {
        System.out.println("horn 2");
    }
}
public class _42_Interfaces {
    public static void main(String[] args) {
        cycle sadiq = new cycle();
        sadiq.applybrake(1);
        //we can create properties in interfaces
        System.out.println(sadiq.a);
        //we cannot modify properties in interfaces
        /*sadiq.a=50;
        System.out.println(sadiq.a); --> error */
    }
}
