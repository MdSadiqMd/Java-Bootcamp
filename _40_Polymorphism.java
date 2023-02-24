/*
Polymorphism - One thing exists in many forms
there are two types
1)Static Polymorphism - nothing but method overloading also called as Compile time polymorphism
2)Dynamic Polymorphism -  nothing but overriding also called run time polymorphism or run time true polymorphism
 */
class Aeroplane{
    public void takeoff(){
        System.out.println("Taking off Aeroplane");
    }
    public void fly(){
        System.out.println("Flying Aeroplane");
    }
}
class cargoplane extends Aeroplane{
    public void fly(){
        System.out.println("Cargoplane flying");
    }
    public void carrygoods(){
        System.out.println("cargoplane carries goods");
    }
}
class passengerplane extends Aeroplane{
    public void fly(){
        System.out.println("Flying passengerplane");
    }
    public void carrypassenger(){
        System.out.println("passenger plane carries passengers");
    }
}
class Airport {
    public void poly(Aeroplane ref) {
        ref.takeoff();
        ref.fly();
    }
}
public class _40_Polymorphism {
    public static void main(String[] args) {
        cargoplane cp=new cargoplane();
        cp.takeoff();
        cp.fly();
        passengerplane pp=new passengerplane();
        pp.takeoff();
        pp.fly(); //here the reference variable should be same of the class ,but in one condition it can be different that is when the reference variable is of from parent
        //             (or)
        /* Aeroplane ref;//this creates a reference variable of parent
        ref=cp;//equating reference variable to cargoplane pointer
        ref.takeoff();
        ref.fly();
        ref=pp;
        ref.takeoff();
        ref.fly();*/
        //             (or)
        //here without calling two child classes one after the other we can call only one class using polymorphism that class is Airport
        /* Airport a=new Airport();
        a.poly(cp);
        a.poly(pp);*/
    }
}
