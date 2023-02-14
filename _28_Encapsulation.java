//To the outside world data should **not be exposed directly
//In order to provide the controlled access of data we need to use encapsulation
//Combine working of data and Methods is known as encapsulation
//encapsulation =data hiding + data abstraction
//Shadowing Problem --> Local variable overwriting the instance variable
class human{
    private int age; //here this variable can only be accessed in this class and only methods of this class like data,show
    private String name;
    public void data(){
        age=18;
        name="sadiq";
    }
    public void show(){
        System.out.println(age+" "+name);
    }
}
public class _28_Encapsulation {
    public static void main(String[] args) {
        human obj=new human();
        /*obj.age=16;
        obj.name="sadiq";
        obj.show(); /*16 sadiq --> *****ok,Wait a minute.Here the human and _44_encapsulation are different classes
                                   this is like _44_encapsulation is changing and accessing data of class human it is
                                   concern of privacy.so, we declare the variables of human class private and create a
                                   subclass in human and call that subclass when we need the data */
        obj.data();
        obj.show();
    }
}
