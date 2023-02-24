//Interfaces - it is group of related methods with empty bodies
//we can't create objects from interfaces
interface bicycle{
    int a=100;
    void applybrake(int decrement);
    void speedup(int increment);
}
interface horn{
    void blowhorn1();
    void blowhorn2();
}
class cycle implements bicycle, horn{  //we can extract more than one class in interfaces but cannot in abstract classes
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
public class _40_Interfaces {
    public static void main(String[] args) {
        cycle sadiq = new cycle();
        sadiq.applybrake(1);
        //we can create properties in interfaces
        System.out.println(sadiq.a);
        //we cannot modify properties in interfaces
        /*sadiq.a=50;
        System.out.println(sadiq.a); -- error */
    }
}
